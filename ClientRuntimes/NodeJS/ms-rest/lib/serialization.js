﻿// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License. See License.txt in the project root for license information.

'use strict';

var util = require('util');
var moment = require('moment');
/**
 * Serializes the JSON Object. It serializes Buffer object to a 
 * 'base64' encoded string and a Date Object to a string 
 * compliant with ISO8601 format.
 * 
 * @param {Object} toSerialize
 * 
 * @returns {Object} serializedObject
 */
exports.serializeObject = function (toSerialize) {
  if (toSerialize === null || toSerialize === undefined) return null;
  if (Buffer.isBuffer(toSerialize)) {
    toSerialize = toSerialize.toString('base64');
    return toSerialize;
  }
  else if (toSerialize instanceof Date) {
    return toSerialize.toISOString();
  }
  else if (Array.isArray(toSerialize)) {
    var array = [];
    for (var i = 0; i < toSerialize.length; i++) {
      array.push(exports.serializeObject(toSerialize[i]));
    }
    return array;
  } else if (typeof toSerialize === 'object') {
    var dictionary = {};
    for (var property in toSerialize) {
      dictionary[property] = exports.serializeObject(toSerialize[property]);
    }
    return dictionary;
  }
  return toSerialize;
};

/**
 * Deserializes the given input in to a Date() object if it is compliant 
 * with ISO 8601 format
 * 
 * @param {string} input
 * 
 * @returns {Date} Date Object
 */
exports.deserializeDate = function (input) {
  if (exports.isValidISODateTime(input)) {
    return new Date(input);
  } else {
    throw new Error('Invalid input  \'' + input + '\'.  It cannot be deserialized as a Date().');
  }
};

/**
 * Validates if the given string is compliant with the ISO 8601 
 * Date and DateTime format
 * 
 * @param {string} dateString
 * 
 * @returns {bool} true - if valid, false otherwise
 */
exports.isValidISODateTime = function (dateString) {
  var re = /^([0-9]{4})-(1[0-2]|0[1-9])-(3[01]|0[1-9]|[12][0-9])?(T(2[0-3]|[01][0-9]):([0-5][0-9]):([0-5][0-9])(\.[0-9]+)?(Z|[+-](?:2[0-3]|[01][0-9]):[0-5][0-9]))?$/i;
  return re.test(dateString);
};

//TODO: Check for stream
exports.serializeInit = function (client, mapper, object) {
  var payload = {};
  if (requiresFlattening(mapper, object)) payload.properties = {};
  for (var key in mapper) {
    if (key.required) {
      if (object[key] === null || object[key] === undefined) {
        throw new Error(util.format('%s cannot be null or undefined.', key));
      }
    }
    
    if (object[key] !== null && object[key] !== undefined) {
      if (mapper[key].type.name === 'Number') {
        if (typeof object[key] !== 'number') {
          throw new Error(util.format('%s must be of type number.', key));
        }
        assignProperty(key, payload, object);
      } else if (mapper[key].type.name === 'Boolean') {
        if (typeof object[key] !== 'boolean') {
          throw new Error(util.format('%s must be of type boolean.', key));
        }
        assignProperty(key, payload, object);
      } else if (mapper[key].type.name === 'String') {
        if (typeof object[key].valueOf() !== 'string') {
          throw new Error(util.format('%s must be of type string.', key));
        }
        assignProperty(key, payload, object);
      } else if (mapper[key].type.name === 'Enum') {
        if (!mapper[key].type.allowedValues.some(function (item) { return item === object[key]; })) {
          throw new Error(util.format('%s  is not a valid value. The valid values are: %s', 
            object[key], JSON.stringify(mapper[key].type.allowedValues)));
        }
        assignProperty(key, payload, object);
      } else if (mapper[key].type.name === 'ByteArray') {
        if (!Buffer.isBuffer(object[key])) {
          throw new Error(util.format('%s must be of type Buffer.', key));
        }
        object[key] = object[key].toString('base64');
        assignProperty(key, payload, object);
      } else if (mapper[key].type.name === 'Date') {
        if (!(object[key] instanceof Date || 
          (typeof object[key].valueOf() === 'string' && !isNaN(Date.parse(object[key]))))) {
          throw new Error(util.format('%s must be an instanceof Date or a string in ISO8601 format.', key));
        }
        object[key] = (object[key] instanceof Date) ? object[key].toISOString().substring(0, 10) : object[key];
        assignProperty(key, payload, object);
      } else if (mapper[key].type.name === 'DateTime') {
        if (!(object[key] instanceof Date || 
          (typeof object[key].valueOf() === 'string' && !isNaN(Date.parse(object[key]))))) {
          throw new Error(util.format('%s must be an instanceof Date or a string in ISO8601 format.', key));
        }
        object[key] = (object[key] instanceof Date) ? object[key].toISOString() : object[key];
        assignProperty(key, payload, object);
      } else if (mapper[key].type.name === 'DateTimeRfc1123') {
        if (!(object[key] instanceof Date || 
          (typeof object[key].valueOf() === 'string' && !isNaN(Date.parse(object[key]))))) {
          throw new Error(util.format('%s must be an instanceof Date or a string in RFC-1123 format.', key));
        }
        object[key] = (object[key] instanceof Date) ? object[key].toUTCString() : object[key];
        assignProperty(key, payload, object);
      } else if (mapper[key].type.name === 'TimeSpan') {
        if (!moment.isDuration(object[key])) {
          throw new Error(util.format('%s must be a TimeSpan.', key));
        }
        object[key] = object[key].toISOString();
        assignProperty(key, payload, object);
      }
    }
  }
  return payload;
};

/**
 * Serialize the given object based on its metadata defined in the mapper
 *
 * @param {object} mapper The mapper which defines the metadata of the serializable object
 *
 * @param {object|string|Array|number|boolean|Date|stream} object A valid Javascript object to be serialized
 *
 * @param {string} objectName Name of the serialized object
 *
 * @param {object} [client] The ServiceClient instance which contains the reference to its list of model types
 *
 * @returns {object|string|Array|number|boolean|Date|stream} A valid serialized Javascript object
 */
exports.serialize = function (mapper, object, objectName, client) {
  var payload = {};
  var mapperType = mapper.type.name;
  if (!objectName) objectName = objectNameFromSerializedName(mapper.serializedName);
  if (mapperType.match(/^Sequence$/ig) !== null) payload = [];
  //Set Defaults
  if (mapper.defaultValue && (object === null || object === undefined)) object = mapper.defaultValue;
  
  if (mapperType.match(/^(Number|String|Boolean)$/ig) !== null) {
    payload = serializeBasicTypes(mapperType, objectName, object);
  } else if (mapperType.match(/^Enum$/ig) !== null) {
    payload = serializeEnumType(objectName, mapper.type.allowedValues, object);
  } else if (mapperType.match(/^(Date|DateTime|TimeSpan|DateTimeRfc1123)$/ig) !== null) {
    payload = serializeDateTypes(mapperType, object, objectName);
  } else if (mapperType.match(/^ByteArray$/ig) !== null) {
    payload = serializeBufferType(objectName, object);
  } else if (mapperType.match(/^Sequence$/ig) !== null) {
    payload = serializeSequenceType(mapper, object, objectName, client);
  } else if (mapperType.match(/^Dictionary$/ig) !== null) {
    payload = serializeDictionaryType(mapper, object, objectName, client);
  } else if (mapperType.match(/^Composite$/ig) !== null) {
    payload = serializeCompositeType(mapper, object, objectName, client);
  }
  return payload;
}

function serializeSequenceType(mapper, object, objectName, client) {
  if (!client) {
    throw new Error(util.format('Please provide a valid client instance to serialize the ' + 
        'object: \'%s\' of SequenceType', JSON.stringify(object)));
  }
  if (!util.isArray(object)) {
    throw new Error(util.format('%s must be of type Array', objectName));
  }
  if (!mapper.type.element || typeof mapper.type.element !== 'object') {
    throw new Error(util.format('\'element\' metadata for an Array must be defined in the ' + 
      'mapper and it must of type \'object\' in %s', objectName));
  }
  var tempArray = [];
  for (var i = 0; i < object.length; i++) {
    tempArray[i] = exports.serialize(mapper.type.element, object[i], objectName, client);
  }
  return tempArray;
}

function serializeDictionaryType(mapper, object, objectName, client) {
  if (!client) {
    throw new Error(util.format('Please provide a valid client instance to serialize the ' + 
        'object: \'%s\' of DictionaryType', JSON.stringify(object)));
  }
  if (typeof object !== 'object') {
    throw new Error(util.format('%s must be of type object', objectName));
  }
  if (!mapper.type.value || typeof mapper.type.value !== 'object') {
    throw new Error(util.format('\'value\' metadata for a Dictionary must be defined in the ' + 
      'mapper and it must of type \'object\' in %s', objectName));
  }
  var tempDictionary = {};
  for (var key in object) {
    if (object.hasOwnProperty(key)) {
      tempDictionary[key] = exports.serialize(mapper.type.value, object[key], objectName, client);
    }
  }
  return tempDictionary;
}

function serializeCompositeType(mapper, object, objectName, client) {
  if (!client) {
    throw new Error(util.format('Please provide a valid client instance to serialize the ' + 
        'object: \'%s\' of CompositeType', JSON.stringify(object)));
  }
  var payload = {};
  var modelMapper = {};
  var mapperType = mapper.type.name;
  if (mapperType === 'Sequence') payload = [];
  if (object !== null && object !== undefined) {
    var modelProps = mapper.type.modelProperties;
    if (!modelProps) {
      if (!mapper.type.className) {
        throw new Error(util.format('Class name for model \'%s\' is not provided in the mapper \'%s\'',
            objectName, JSON.stringify(mapper)));
      }
      //get the mapper if modelProperties of the CompositeType is not present and 
      //then get the modelProperties from it.
      modelMapper = new client.models[mapper.type.className]().mapper();
      if (!modelMapper) {
        throw new Error(util.format('mapper() cannot be null or undefined for model \'%s\'', 
              mapper.type.className));
      }
      modelProps = modelMapper.type.modelProperties;
      if (!modelProps) {
        throw new Error(util.format('modelProperties cannot be null or undefined in the ' + 
          'mapper \'%s\' of type \'%s\' for object \'%s\'.', JSON.stringify(modelMapper), 
          mapper.type.className, objectName));
      }
    }
    if (requiresFlattening(modelProps, object) && !payload.properties) payload.properties = {};
    for (var key in modelProps) {
      if (modelProps.hasOwnProperty(key)) {
        //make sure required properties of the CompositeType are present
        if (modelProps[key].required) {
          if (object[key] === null || object[key] === undefined) {
            throw new Error(util.format('\'%s\' cannot be null or undefined in \'%s\'.', key, objectName));
          }
        }
        //serialize the property if it is present in the provided object instance
        if (object[key] !== null && object[key] !== undefined) {
          var propertyObjectName = objectName + '.' + objectNameFromSerializedName(modelProps[key].serializedName);
          var propertyMapper = modelProps[key];
          var serializedValue = exports.serialize(propertyMapper, object[key], propertyObjectName, client);
          assignProperty(modelProps[key].serializedName, payload, serializedValue);
        }
      }
    }
    return payload;
  }
  return object;
}

function serializeBasicTypes(typeName, objectName, value) {
  if (typeName.match(/^Number$/ig) !== null) {
    if (typeof value !== 'number') {
      throw new Error(util.format('%s must be of type number.', objectName));
    }
  } else if (typeName.match(/^String$/ig) !== null) {
    if (typeof value.valueOf() !== 'string') {
      throw new Error(util.format('%s must be of type string.', objectName));
    }
  } else if (typeName.match(/^Boolean$/ig) !== null) {
    if (typeof value !== 'boolean') {
      throw new Error(util.format('%s must be of type boolean.', objectName));
    }
  }
  return value;
}

function serializeEnumType(objectName, allowedValues, value) {
  if (!allowedValues) {
    throw new Error(util.format('Please provide a set of allowedValues to validate %s as an Enum Type.', objectName));
  }
  if (!allowedValues.some(function (item) { return item === value; })) {
    throw new Error(util.format('%s is not a valid value for %s. The valid values are: %s', 
      value, objectName, JSON.stringify(allowedValues)));
  }
  return value;
}

function serializeBufferType(objectName, value) {
  if (!Buffer.isBuffer(value)) {
    throw new Error(util.format('%s must be of type Buffer.', objectName));
  }
  value = value.toString('base64');
  return value;
}

function serializeDateTypes(typeName, value, objectName) {
  if (typeName.match(/^Date$/ig) !== null) {
    if (!(value instanceof Date || 
        (typeof value.valueOf() === 'string' && !isNaN(Date.parse(value))))) {
      throw new Error(util.format('%s must be an instanceof Date or a string in ISO8601 format.', objectName));
    }
    value = (value instanceof Date) ? value.toISOString().substring(0, 10) : new Date(value).toISOString().substring(0, 10);
  } else if (typeName.match(/^DateTime$/ig) !== null) {
    if (!(value instanceof Date || 
        (typeof value.valueOf() === 'string' && !isNaN(Date.parse(value))))) {
      throw new Error(util.format('%s must be an instanceof Date or a string in ISO8601 format.', objectName));
    }
    value = (value instanceof Date) ? value.toISOString() :  new Date(value).toISOString();
  } else if (typeName.match(/^DateTimeRfc1123$/ig) !== null) {
    if (!(value instanceof Date || 
        (typeof value.valueOf() === 'string' && !isNaN(Date.parse(value))))) {
      throw new Error(util.format('%s must be an instanceof Date or a string in RFC-1123 format.', objectName));
    }
    value = (value instanceof Date) ? value.toUTCString() :  new Date(value).toUTCString();
  } else if (typeName.match(/^TimeSpan$/ig) !== null) {
    if (!moment.isDuration(value)) {
      throw new Error(util.format('%s must be a TimeSpan/Duration.', objectName));
    }
    value = value.toISOString();
  }
  return value;
}

/**
 * Deserialize the given object based on its metadata defined in the mapper
 *
 * @param {object} mapper The mapper which defines the metadata of the serializable object
 *
 * @param {object|string|Array|number|boolean|Date|stream} responseBody A valid Javascript entity to be deserialized
 *
 * @param {string} objectName Name of the deserialized object
 *
 * @param {object} [client] The ServiceClient instance which contains the reference to its list of model types
 *
 * @returns {object|string|Array|number|boolean|Date|stream} A valid deserialized Javascript object
 */
exports.deserialize = function (mapper, responseBody, objectName, client) {
  if (responseBody === null || responseBody === undefined) return responseBody;
  var payload = {};
  var mapperType = mapper.type.name;
  if (!objectName) objectName = objectNameFromSerializedName(mapper.serializedName);
  if (mapperType.match(/^Sequence$/ig) !== null) payload = [];
  
  if (mapperType.match(/^(Number|String|Boolean|Enum)$/ig) !== null) {
    payload = responseBody;
  } else if (mapperType.match(/^(Date|DateTime|DateTimeRfc1123)$/ig) !== null) {
    payload = new Date(responseBody);
  } else if (mapperType.match(/^(TimeSpan)$/ig) !== null) {
    payload = moment.duration(responseBody);
  } else if (mapperType.match(/^ByteArray$/ig) !== null) {
    payload = new Buffer(responseBody, 'base64');
  } else if (mapperType.match(/^Sequence$/ig) !== null) {
    payload = deserializeSequenceType(mapper, responseBody, objectName, client);
  } else if (mapperType.match(/^Dictionary$/ig) !== null) {
    payload = deserializeDictionaryType(mapper, responseBody, objectName, client);
  } else if (mapperType.match(/^Composite$/ig) !== null) {
    payload = deserializeCompositeType(mapper, responseBody, objectName, client);
  }
  return payload;
}

function deserializeSequenceType(mapper, responseBody, objectName, client) {
  if (!client) {
    throw new Error(util.format('Please provide a valid client instance to deserialize the ' + 
        'responseBody: \'%s\' of SequenceType', JSON.stringify(responseBody)));
  }
  if (!mapper.type.element || typeof mapper.type.element !== 'object') {
    throw new Error(util.format('\'element\' metadata for an Array must be defined in the ' + 
      'mapper and it must of type \'object\' in %s', objectName));
  }
  if (responseBody) {
    var tempArray = [];
    for (var i = 0; i < responseBody.length; i++) {
      tempArray[i] = exports.deserialize(mapper.type.element, responseBody[i], objectName, client);
    }
    return tempArray;
  }
  return responseBody;
}

function deserializeDictionaryType(mapper, responseBody, objectName, client) {
  if (!client) {
    throw new Error(util.format('Please provide a valid client instance to serialize the ' + 
        'responseBody: \'%s\' of DictionaryType', JSON.stringify(responseBody)));
  }
  if (!mapper.type.value || typeof mapper.type.value !== 'object') {
    throw new Error(util.format('\'value\' metadata for a Dictionary must be defined in the ' + 
      'mapper and it must of type \'object\' in %s', objectName));
  }
  if (responseBody) {
    var tempDictionary = {};
    for (var key in responseBody) {
      if (responseBody.hasOwnProperty(key)) {
        tempDictionary[key] = exports.deserialize(mapper.type.value, responseBody[key], objectName, client);
      }
    }
    return tempDictionary;
  }
  return responseBody;
}

function deserializeCompositeType(mapper, responseBody, objectName, client) {
  if (!client) {
    throw new Error(util.format('Please provide a valid client instance to serialize the ' + 
        'responseBody: \'%s\' of CompositeType', JSON.stringify(responseBody)));
  }
  var instance = {};
  var modelMapper = {};
  var mapperType = mapper.type.name;
  if (mapperType === 'Sequence') instance = [];
  if (responseBody !== null && responseBody !== undefined) {
    var modelProps = mapper.type.modelProperties;
    if (!modelProps) {
      if (!mapper.type.className) {
        throw new Error(util.format('Class name for model \'%s\' is not provided in the mapper \'%s\'',
            objectName, JSON.stringify(mapper)));
      }
      //get the mapper if modelProperties of the CompositeType is not present and 
      //then get the modelProperties from it.
      modelMapper = new client.models[mapper.type.className]().mapper();
      if (!modelMapper) {
        throw new Error(util.format('mapper() cannot be null or undefined for model \'%s\'', 
              mapper.type.className));
      }
      modelProps = modelMapper.type.modelProperties;
      if (!modelProps) {
        throw new Error(util.format('modelProperties cannot be null or undefined in the ' + 
          'mapper \'%s\' of type \'%s\' for responseBody \'%s\'.', JSON.stringify(modelMapper), 
          mapper.type.className, objectName));
      }
    }

    for (var key in modelProps) {
      if (modelProps.hasOwnProperty(key)) {
        //deserialize the property if it is present in the provided responseBody instance
        var propertyInstance = responseBody[modelProps[key].serializedName];
        if (stringContainsProperties(modelProps[key].serializedName)) {
          if (responseBody.properties) {
            propertyInstance = responseBody.properties[key];
          }
        }
        var propertyObjectName = objectName + '.' + modelProps[key].serializedName;
        var propertyMapper = modelProps[key];
        var serializedValue;
        //paging
        if (key === 'value' && util.isArray(responseBody[key]) && modelProps[key].serializedName === '') {
          propertyInstance = responseBody[key];
          instance = exports.deserialize(propertyMapper, propertyInstance, propertyObjectName, client);
        } else if (propertyInstance !== null && propertyInstance !== undefined) {
          serializedValue = exports.deserialize(propertyMapper, propertyInstance, propertyObjectName, client);
          instance[key] = serializedValue;
        }
      }
    }
    return instance;
  }
  return responseBody;
}

function assignProperty(serializedName, payload, serializedValue) {
  var key = objectNameFromSerializedName(serializedName);
  if (stringContainsProperties(serializedName)) {
    payload.properties[key] = serializedValue;
  } else {
    payload[key] = serializedValue;
  }
}

function requiresFlattening(mapper, object) {
  return Object.keys(mapper).some(function (key) {
    return ((mapper[key].serializedName.match(/^properties\./ig) !== null) && 
            (object[key] !== null && object[key] !== undefined));
  });
}

function objectNameFromSerializedName(name) {
  if (stringContainsProperties(name)) {
    return name.match(/^properties\.(\w+)$/i)[1];
  }
  return name;
}

function stringContainsProperties(prop) {
  return (prop.match(/^properties\.(\w+)$/i) !== null);
}

exports = module.exports;
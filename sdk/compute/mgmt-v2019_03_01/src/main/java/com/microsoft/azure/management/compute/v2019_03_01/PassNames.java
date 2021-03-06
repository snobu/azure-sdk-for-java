/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.compute.v2019_03_01;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for PassNames.
 */
public enum PassNames {
    /** Enum value OobeSystem. */
    OOBE_SYSTEM("OobeSystem");

    /** The actual serialized value for a PassNames instance. */
    private String value;

    PassNames(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a PassNames instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed PassNames object, or null if unable to parse.
     */
    @JsonCreator
    public static PassNames fromString(String value) {
        PassNames[] items = PassNames.values();
        for (PassNames item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

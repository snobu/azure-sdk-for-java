/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.servicefabric;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Describes a Service Fabric application.
 */
public class ApplicationDescription {
    /**
     * The name of the application, including the 'fabric:' URI scheme.
     */
    @JsonProperty(value = "Name", required = true)
    private String name;

    /**
     * The application type name as defined in the application manifest.
     */
    @JsonProperty(value = "TypeName", required = true)
    private String typeName;

    /**
     * The version of the application type as defined in the application
     * manifest.
     */
    @JsonProperty(value = "TypeVersion", required = true)
    private String typeVersion;

    /**
     * List of application parameters with overridden values from their default
     * values specified in the application manifest.
     */
    @JsonProperty(value = "ParameterList")
    private List<ApplicationParameter> parameterList;

    /**
     * Describes capacity information for services of this application. This
     * description can be used for describing the following.
     * - Reserving the capacity for the services on the nodes
     * - Limiting the total number of nodes that services of this application
     * can run on
     * - Limiting the custom capacity metrics to limit the total consumption of
     * this metric by the services of this application.
     */
    @JsonProperty(value = "ApplicationCapacity")
    private ApplicationCapacityDescription applicationCapacity;

    /**
     * Managed application identity description.
     */
    @JsonProperty(value = "ManagedApplicationIdentity")
    private ManagedApplicationIdentityDescription managedApplicationIdentity;

    /**
     * Get the name of the application, including the 'fabric:' URI scheme.
     *
     * @return the name value
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name of the application, including the 'fabric:' URI scheme.
     *
     * @param name the name value to set
     * @return the ApplicationDescription object itself.
     */
    public ApplicationDescription withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the application type name as defined in the application manifest.
     *
     * @return the typeName value
     */
    public String typeName() {
        return this.typeName;
    }

    /**
     * Set the application type name as defined in the application manifest.
     *
     * @param typeName the typeName value to set
     * @return the ApplicationDescription object itself.
     */
    public ApplicationDescription withTypeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    /**
     * Get the version of the application type as defined in the application manifest.
     *
     * @return the typeVersion value
     */
    public String typeVersion() {
        return this.typeVersion;
    }

    /**
     * Set the version of the application type as defined in the application manifest.
     *
     * @param typeVersion the typeVersion value to set
     * @return the ApplicationDescription object itself.
     */
    public ApplicationDescription withTypeVersion(String typeVersion) {
        this.typeVersion = typeVersion;
        return this;
    }

    /**
     * Get list of application parameters with overridden values from their default values specified in the application manifest.
     *
     * @return the parameterList value
     */
    public List<ApplicationParameter> parameterList() {
        return this.parameterList;
    }

    /**
     * Set list of application parameters with overridden values from their default values specified in the application manifest.
     *
     * @param parameterList the parameterList value to set
     * @return the ApplicationDescription object itself.
     */
    public ApplicationDescription withParameterList(List<ApplicationParameter> parameterList) {
        this.parameterList = parameterList;
        return this;
    }

    /**
     * Get describes capacity information for services of this application. This description can be used for describing the following.
     - Reserving the capacity for the services on the nodes
     - Limiting the total number of nodes that services of this application can run on
     - Limiting the custom capacity metrics to limit the total consumption of this metric by the services of this application.
     *
     * @return the applicationCapacity value
     */
    public ApplicationCapacityDescription applicationCapacity() {
        return this.applicationCapacity;
    }

    /**
     * Set describes capacity information for services of this application. This description can be used for describing the following.
     - Reserving the capacity for the services on the nodes
     - Limiting the total number of nodes that services of this application can run on
     - Limiting the custom capacity metrics to limit the total consumption of this metric by the services of this application.
     *
     * @param applicationCapacity the applicationCapacity value to set
     * @return the ApplicationDescription object itself.
     */
    public ApplicationDescription withApplicationCapacity(ApplicationCapacityDescription applicationCapacity) {
        this.applicationCapacity = applicationCapacity;
        return this;
    }

    /**
     * Get managed application identity description.
     *
     * @return the managedApplicationIdentity value
     */
    public ManagedApplicationIdentityDescription managedApplicationIdentity() {
        return this.managedApplicationIdentity;
    }

    /**
     * Set managed application identity description.
     *
     * @param managedApplicationIdentity the managedApplicationIdentity value to set
     * @return the ApplicationDescription object itself.
     */
    public ApplicationDescription withManagedApplicationIdentity(ManagedApplicationIdentityDescription managedApplicationIdentity) {
        this.managedApplicationIdentity = managedApplicationIdentity;
        return this;
    }

}

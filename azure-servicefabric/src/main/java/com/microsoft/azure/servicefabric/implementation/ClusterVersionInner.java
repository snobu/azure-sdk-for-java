/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.servicefabric.implementation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The cluster version.
 */
public class ClusterVersionInner {
    /**
     * The Service Fabric cluster runtime version.
     */
    @JsonProperty(value = "Version")
    private String version;

    /**
     * Get the Service Fabric cluster runtime version.
     *
     * @return the version value
     */
    public String version() {
        return this.version;
    }

    /**
     * Set the Service Fabric cluster runtime version.
     *
     * @param version the version value to set
     * @return the ClusterVersionInner object itself.
     */
    public ClusterVersionInner withVersion(String version) {
        this.version = version;
        return this;
    }

}

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
 * Describes the result of an operation that created or updated a repair task.
 *
 * This type supports the Service Fabric platform; it is not meant to be used
 * directly from your code.
 */
public class RepairTaskUpdateInfoInner {
    /**
     * The new version of the repair task.
     */
    @JsonProperty(value = "Version", required = true)
    private String version;

    /**
     * Get the new version of the repair task.
     *
     * @return the version value
     */
    public String version() {
        return this.version;
    }

    /**
     * Set the new version of the repair task.
     *
     * @param version the version value to set
     * @return the RepairTaskUpdateInfoInner object itself.
     */
    public RepairTaskUpdateInfoInner withVersion(String version) {
        this.version = version;
        return this;
    }

}

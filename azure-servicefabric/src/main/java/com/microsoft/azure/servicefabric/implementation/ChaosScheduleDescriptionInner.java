/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.servicefabric.implementation;

import com.microsoft.azure.servicefabric.ChaosSchedule;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Defines the Chaos Schedule used by Chaos and the version of the Chaos
 * Schedule. The version value wraps back to 0 after surpassing 2,147,483,647.
 */
public class ChaosScheduleDescriptionInner {
    /**
     * The version number of the Schedule.
     */
    @JsonProperty(value = "Version")
    private Integer version;

    /**
     * Defines the schedule used by Chaos.
     */
    @JsonProperty(value = "Schedule")
    private ChaosSchedule schedule;

    /**
     * Get the version number of the Schedule.
     *
     * @return the version value
     */
    public Integer version() {
        return this.version;
    }

    /**
     * Set the version number of the Schedule.
     *
     * @param version the version value to set
     * @return the ChaosScheduleDescriptionInner object itself.
     */
    public ChaosScheduleDescriptionInner withVersion(Integer version) {
        this.version = version;
        return this;
    }

    /**
     * Get defines the schedule used by Chaos.
     *
     * @return the schedule value
     */
    public ChaosSchedule schedule() {
        return this.schedule;
    }

    /**
     * Set defines the schedule used by Chaos.
     *
     * @param schedule the schedule value to set
     * @return the ChaosScheduleDescriptionInner object itself.
     */
    public ChaosScheduleDescriptionInner withSchedule(ChaosSchedule schedule) {
        this.schedule = schedule;
        return this;
    }

}

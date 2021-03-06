/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.policyinsights.v2018_07_01_preview;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.policyinsights.v2018_07_01_preview.implementation.PolicyInsightsManager;
import com.microsoft.azure.management.policyinsights.v2018_07_01_preview.implementation.OperationsListResultsInner;
import com.microsoft.azure.management.policyinsights.v2018_07_01_preview.implementation.OperationInner;
import java.util.List;

/**
 * Type representing OperationsListResults.
 */
public interface OperationsListResults extends HasInner<OperationsListResultsInner>, HasManager<PolicyInsightsManager> {
    /**
     * @return the odatacount value.
     */
    Integer odatacount();

    /**
     * @return the value value.
     */
    List<OperationInner> value();

}

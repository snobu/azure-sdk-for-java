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
 * The detailed upgrade progress for nodes in the current upgrade domain at the
 * point of failure.
 */
public class FailedUpgradeDomainProgressObject {
    /**
     * The name of the upgrade domain.
     */
    @JsonProperty(value = "DomainName")
    private String domainName;

    /**
     * List of upgrading nodes and their statuses.
     */
    @JsonProperty(value = "NodeUpgradeProgressList")
    private List<NodeUpgradeProgressInfo> nodeUpgradeProgressList;

    /**
     * Get the name of the upgrade domain.
     *
     * @return the domainName value
     */
    public String domainName() {
        return this.domainName;
    }

    /**
     * Set the name of the upgrade domain.
     *
     * @param domainName the domainName value to set
     * @return the FailedUpgradeDomainProgressObject object itself.
     */
    public FailedUpgradeDomainProgressObject withDomainName(String domainName) {
        this.domainName = domainName;
        return this;
    }

    /**
     * Get list of upgrading nodes and their statuses.
     *
     * @return the nodeUpgradeProgressList value
     */
    public List<NodeUpgradeProgressInfo> nodeUpgradeProgressList() {
        return this.nodeUpgradeProgressList;
    }

    /**
     * Set list of upgrading nodes and their statuses.
     *
     * @param nodeUpgradeProgressList the nodeUpgradeProgressList value to set
     * @return the FailedUpgradeDomainProgressObject object itself.
     */
    public FailedUpgradeDomainProgressObject withNodeUpgradeProgressList(List<NodeUpgradeProgressInfo> nodeUpgradeProgressList) {
        this.nodeUpgradeProgressList = nodeUpgradeProgressList;
        return this;
    }

}

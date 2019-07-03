/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sqlvirtualmachine.v2017_03_01_preview;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Active Directory account details to operate Windows Server Failover Cluster.
 */
public class WsfcDomainProfile {
    /**
     * Fully qualified name of the domain.
     */
    @JsonProperty(value = "domainFqdn")
    private String domainFqdn;

    /**
     * Organizational Unit path in which the nodes and cluster will be present.
     */
    @JsonProperty(value = "ouPath")
    private String ouPath;

    /**
     * Account name used for creating cluster (at minimum needs permissions to
     * 'Create Computer Objects' in domain).
     */
    @JsonProperty(value = "clusterBootstrapAccount")
    private String clusterBootstrapAccount;

    /**
     * Account name used for operating cluster i.e. will be part of
     * administrators group on all the participating virtual machines in the
     * cluster.
     */
    @JsonProperty(value = "clusterOperatorAccount")
    private String clusterOperatorAccount;

    /**
     * Account name under which SQL service will run on all participating SQL
     * virtual machines in the cluster.
     */
    @JsonProperty(value = "sqlServiceAccount")
    private String sqlServiceAccount;

    /**
     * Optional path for fileshare witness.
     */
    @JsonProperty(value = "fileShareWitnessPath")
    private String fileShareWitnessPath;

    /**
     * Fully qualified ARM resource id of the witness storage account.
     */
    @JsonProperty(value = "storageAccountUrl")
    private String storageAccountUrl;

    /**
     * Primary key of the witness storage account.
     */
    @JsonProperty(value = "storageAccountPrimaryKey")
    private String storageAccountPrimaryKey;

    /**
     * Get fully qualified name of the domain.
     *
     * @return the domainFqdn value
     */
    public String domainFqdn() {
        return this.domainFqdn;
    }

    /**
     * Set fully qualified name of the domain.
     *
     * @param domainFqdn the domainFqdn value to set
     * @return the WsfcDomainProfile object itself.
     */
    public WsfcDomainProfile withDomainFqdn(String domainFqdn) {
        this.domainFqdn = domainFqdn;
        return this;
    }

    /**
     * Get organizational Unit path in which the nodes and cluster will be present.
     *
     * @return the ouPath value
     */
    public String ouPath() {
        return this.ouPath;
    }

    /**
     * Set organizational Unit path in which the nodes and cluster will be present.
     *
     * @param ouPath the ouPath value to set
     * @return the WsfcDomainProfile object itself.
     */
    public WsfcDomainProfile withOuPath(String ouPath) {
        this.ouPath = ouPath;
        return this;
    }

    /**
     * Get account name used for creating cluster (at minimum needs permissions to 'Create Computer Objects' in domain).
     *
     * @return the clusterBootstrapAccount value
     */
    public String clusterBootstrapAccount() {
        return this.clusterBootstrapAccount;
    }

    /**
     * Set account name used for creating cluster (at minimum needs permissions to 'Create Computer Objects' in domain).
     *
     * @param clusterBootstrapAccount the clusterBootstrapAccount value to set
     * @return the WsfcDomainProfile object itself.
     */
    public WsfcDomainProfile withClusterBootstrapAccount(String clusterBootstrapAccount) {
        this.clusterBootstrapAccount = clusterBootstrapAccount;
        return this;
    }

    /**
     * Get account name used for operating cluster i.e. will be part of administrators group on all the participating virtual machines in the cluster.
     *
     * @return the clusterOperatorAccount value
     */
    public String clusterOperatorAccount() {
        return this.clusterOperatorAccount;
    }

    /**
     * Set account name used for operating cluster i.e. will be part of administrators group on all the participating virtual machines in the cluster.
     *
     * @param clusterOperatorAccount the clusterOperatorAccount value to set
     * @return the WsfcDomainProfile object itself.
     */
    public WsfcDomainProfile withClusterOperatorAccount(String clusterOperatorAccount) {
        this.clusterOperatorAccount = clusterOperatorAccount;
        return this;
    }

    /**
     * Get account name under which SQL service will run on all participating SQL virtual machines in the cluster.
     *
     * @return the sqlServiceAccount value
     */
    public String sqlServiceAccount() {
        return this.sqlServiceAccount;
    }

    /**
     * Set account name under which SQL service will run on all participating SQL virtual machines in the cluster.
     *
     * @param sqlServiceAccount the sqlServiceAccount value to set
     * @return the WsfcDomainProfile object itself.
     */
    public WsfcDomainProfile withSqlServiceAccount(String sqlServiceAccount) {
        this.sqlServiceAccount = sqlServiceAccount;
        return this;
    }

    /**
     * Get optional path for fileshare witness.
     *
     * @return the fileShareWitnessPath value
     */
    public String fileShareWitnessPath() {
        return this.fileShareWitnessPath;
    }

    /**
     * Set optional path for fileshare witness.
     *
     * @param fileShareWitnessPath the fileShareWitnessPath value to set
     * @return the WsfcDomainProfile object itself.
     */
    public WsfcDomainProfile withFileShareWitnessPath(String fileShareWitnessPath) {
        this.fileShareWitnessPath = fileShareWitnessPath;
        return this;
    }

    /**
     * Get fully qualified ARM resource id of the witness storage account.
     *
     * @return the storageAccountUrl value
     */
    public String storageAccountUrl() {
        return this.storageAccountUrl;
    }

    /**
     * Set fully qualified ARM resource id of the witness storage account.
     *
     * @param storageAccountUrl the storageAccountUrl value to set
     * @return the WsfcDomainProfile object itself.
     */
    public WsfcDomainProfile withStorageAccountUrl(String storageAccountUrl) {
        this.storageAccountUrl = storageAccountUrl;
        return this;
    }

    /**
     * Get primary key of the witness storage account.
     *
     * @return the storageAccountPrimaryKey value
     */
    public String storageAccountPrimaryKey() {
        return this.storageAccountPrimaryKey;
    }

    /**
     * Set primary key of the witness storage account.
     *
     * @param storageAccountPrimaryKey the storageAccountPrimaryKey value to set
     * @return the WsfcDomainProfile object itself.
     */
    public WsfcDomainProfile withStorageAccountPrimaryKey(String storageAccountPrimaryKey) {
        this.storageAccountPrimaryKey = storageAccountPrimaryKey;
        return this;
    }

}

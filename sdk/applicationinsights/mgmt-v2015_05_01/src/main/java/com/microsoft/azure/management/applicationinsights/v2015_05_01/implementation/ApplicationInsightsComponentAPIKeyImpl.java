/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.applicationinsights.v2015_05_01.implementation;

import com.microsoft.azure.management.applicationinsights.v2015_05_01.ApplicationInsightsComponentAPIKey;
import com.microsoft.azure.arm.model.implementation.IndexableRefreshableWrapperImpl;
import rx.Observable;
import java.util.List;

class ApplicationInsightsComponentAPIKeyImpl extends IndexableRefreshableWrapperImpl<ApplicationInsightsComponentAPIKey, ApplicationInsightsComponentAPIKeyInner> implements ApplicationInsightsComponentAPIKey {
    private final InsightsManager manager;
    private String resourceGroupName;
    private String resourceName;
    private String keyId;

    ApplicationInsightsComponentAPIKeyImpl(ApplicationInsightsComponentAPIKeyInner inner,  InsightsManager manager) {
        super(null, inner);
        this.manager = manager;
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.resourceName = IdParsingUtils.getValueFromIdByName(inner.id(), "components");
        this.keyId = IdParsingUtils.getValueFromIdByName(inner.id(), "APIKeys");
    }

    @Override
    public InsightsManager manager() {
        return this.manager;
    }

    @Override
    protected Observable<ApplicationInsightsComponentAPIKeyInner> getInnerAsync() {
        APIKeysInner client = this.manager().inner().aPIKeys();
        return client.getAsync(this.resourceGroupName, this.resourceName, this.keyId);
    }



    @Override
    public String apiKey() {
        return this.inner().apiKey();
    }

    @Override
    public String createdDate() {
        return this.inner().createdDate();
    }

    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public List<String> linkedReadProperties() {
        return this.inner().linkedReadProperties();
    }

    @Override
    public List<String> linkedWriteProperties() {
        return this.inner().linkedWriteProperties();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

}

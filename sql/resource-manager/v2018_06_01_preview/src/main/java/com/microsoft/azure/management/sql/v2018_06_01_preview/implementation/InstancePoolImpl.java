/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql.v2018_06_01_preview.implementation;

import com.microsoft.azure.arm.resources.models.implementation.GroupableResourceCoreImpl;
import com.microsoft.azure.management.sql.v2018_06_01_preview.InstancePool;
import rx.Observable;
import com.microsoft.azure.management.sql.v2018_06_01_preview.Sku;
import com.microsoft.azure.management.sql.v2018_06_01_preview.InstancePoolLicenseType;

class InstancePoolImpl extends GroupableResourceCoreImpl<InstancePool, InstancePoolInner, InstancePoolImpl, SqlManager> implements InstancePool, InstancePool.Definition, InstancePool.Update {
    InstancePoolImpl(String name, InstancePoolInner inner, SqlManager manager) {
        super(name, inner, manager);
    }

    @Override
    public Observable<InstancePool> createResourceAsync() {
        InstancePoolsInner client = this.manager().inner().instancePools();
        return client.createOrUpdateAsync(this.resourceGroupName(), this.name(), this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<InstancePool> updateResourceAsync() {
        InstancePoolsInner client = this.manager().inner().instancePools();
        return client.createOrUpdateAsync(this.resourceGroupName(), this.name(), this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<InstancePoolInner> getInnerAsync() {
        InstancePoolsInner client = this.manager().inner().instancePools();
        return client.getByResourceGroupAsync(this.resourceGroupName(), this.name());
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }


    @Override
    public InstancePoolLicenseType licenseType() {
        return this.inner().licenseType();
    }

    @Override
    public Sku sku() {
        return this.inner().sku();
    }

    @Override
    public String subnetId() {
        return this.inner().subnetId();
    }

    @Override
    public int vCores() {
        return this.inner().vCores();
    }

    @Override
    public InstancePoolImpl withLicenseType(InstancePoolLicenseType licenseType) {
        this.inner().withLicenseType(licenseType);
        return this;
    }

    @Override
    public InstancePoolImpl withSubnetId(String subnetId) {
        this.inner().withSubnetId(subnetId);
        return this;
    }

    @Override
    public InstancePoolImpl withVCores(int vCores) {
        this.inner().withVCores(vCores);
        return this;
    }

    @Override
    public InstancePoolImpl withSku(Sku sku) {
        this.inner().withSku(sku);
        return this;
    }

}
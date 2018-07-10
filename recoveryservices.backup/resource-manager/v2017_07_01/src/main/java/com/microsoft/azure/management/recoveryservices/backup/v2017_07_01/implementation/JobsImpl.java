/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * abc
 */

package com.microsoft.azure.management.recoveryservices.backup.v2017_07_01.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.recoveryservices.backup.v2017_07_01.Jobs;
import rx.Completable;

class JobsImpl extends WrapperImpl<JobsInner> implements Jobs {
    private final RecoveryServicesManager manager;

    JobsImpl(RecoveryServicesManager manager) {
        super(manager.inner().jobs());
        this.manager = manager;
    }

    public RecoveryServicesManager manager() {
        return this.manager;
    }

    @Override
    public Completable exportAsync(String vaultName, String resourceGroupName) {
        JobsInner client = this.inner();
        return client.exportAsync(vaultName, resourceGroupName).toCompletable();
    }

}
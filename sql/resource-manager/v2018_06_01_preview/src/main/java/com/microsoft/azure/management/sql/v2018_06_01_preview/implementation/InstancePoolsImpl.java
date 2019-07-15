/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 * def
 */

package com.microsoft.azure.management.sql.v2018_06_01_preview.implementation;

import com.microsoft.azure.arm.resources.collection.implementation.GroupableResourcesCoreImpl;
import com.microsoft.azure.management.sql.v2018_06_01_preview.InstancePools;
import com.microsoft.azure.management.sql.v2018_06_01_preview.InstancePool;
import rx.Observable;
import rx.Completable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import com.microsoft.azure.arm.resources.ResourceUtilsCore;
import com.microsoft.azure.arm.utils.RXMapper;
import rx.functions.Func1;
import com.microsoft.azure.PagedList;
import com.microsoft.azure.Page;

class InstancePoolsImpl extends GroupableResourcesCoreImpl<InstancePool, InstancePoolImpl, InstancePoolInner, InstancePoolsInner, SqlManager>  implements InstancePools {
    protected InstancePoolsImpl(SqlManager manager) {
        super(manager.inner().instancePools(), manager);
    }

    @Override
    protected Observable<InstancePoolInner> getInnerAsync(String resourceGroupName, String name) {
        InstancePoolsInner client = this.inner();
        return client.getByResourceGroupAsync(resourceGroupName, name);
    }

    @Override
    protected Completable deleteInnerAsync(String resourceGroupName, String name) {
        InstancePoolsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, name).toCompletable();
    }

    @Override
    public Observable<String> deleteByIdsAsync(Collection<String> ids) {
        if (ids == null || ids.isEmpty()) {
            return Observable.empty();
        }
        Collection<Observable<String>> observables = new ArrayList<>();
        for (String id : ids) {
            final String resourceGroupName = ResourceUtilsCore.groupFromResourceId(id);
            final String name = ResourceUtilsCore.nameFromResourceId(id);
            Observable<String> o = RXMapper.map(this.inner().deleteAsync(resourceGroupName, name), id);
            observables.add(o);
        }
        return Observable.mergeDelayError(observables);
    }

    @Override
    public Observable<String> deleteByIdsAsync(String...ids) {
        return this.deleteByIdsAsync(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public void deleteByIds(Collection<String> ids) {
        if (ids != null && !ids.isEmpty()) {
            this.deleteByIdsAsync(ids).toBlocking().last();
        }
    }

    @Override
    public void deleteByIds(String...ids) {
        this.deleteByIds(new ArrayList<String>(Arrays.asList(ids)));
    }

    @Override
    public PagedList<InstancePool> listByResourceGroup(String resourceGroupName) {
        InstancePoolsInner client = this.inner();
        return this.wrapList(client.listByResourceGroup(resourceGroupName));
    }

    @Override
    public Observable<InstancePool> listByResourceGroupAsync(String resourceGroupName) {
        InstancePoolsInner client = this.inner();
        return client.listByResourceGroupAsync(resourceGroupName)
        .flatMapIterable(new Func1<Page<InstancePoolInner>, Iterable<InstancePoolInner>>() {
            @Override
            public Iterable<InstancePoolInner> call(Page<InstancePoolInner> page) {
                return page.items();
            }
        })
        .map(new Func1<InstancePoolInner, InstancePool>() {
            @Override
            public InstancePool call(InstancePoolInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public PagedList<InstancePool> list() {
        InstancePoolsInner client = this.inner();
        return this.wrapList(client.list());
    }

    @Override
    public Observable<InstancePool> listAsync() {
        InstancePoolsInner client = this.inner();
        return client.listAsync()
        .flatMapIterable(new Func1<Page<InstancePoolInner>, Iterable<InstancePoolInner>>() {
            @Override
            public Iterable<InstancePoolInner> call(Page<InstancePoolInner> page) {
                return page.items();
            }
        })
        .map(new Func1<InstancePoolInner, InstancePool>() {
            @Override
            public InstancePool call(InstancePoolInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public InstancePoolImpl define(String name) {
        return wrapModel(name);
    }

    @Override
    protected InstancePoolImpl wrapModel(InstancePoolInner inner) {
        return  new InstancePoolImpl(inner.name(), inner, manager());
    }

    @Override
    protected InstancePoolImpl wrapModel(String name) {
        return new InstancePoolImpl(name, new InstancePoolInner(), this.manager());
    }

}
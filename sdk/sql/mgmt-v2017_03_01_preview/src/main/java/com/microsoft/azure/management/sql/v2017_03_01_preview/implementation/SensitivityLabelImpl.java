/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.sql.v2017_03_01_preview.implementation;

import com.microsoft.azure.management.sql.v2017_03_01_preview.SensitivityLabel;
import com.microsoft.azure.arm.model.implementation.CreatableUpdatableImpl;
import com.microsoft.azure.management.sql.v2017_03_01_preview.SensitivityLabelSource;
import rx.Observable;

class SensitivityLabelImpl extends CreatableUpdatableImpl<SensitivityLabel, SensitivityLabelInner, SensitivityLabelImpl> implements SensitivityLabel, SensitivityLabel.Definition, SensitivityLabel.Update {
    private final SqlManager manager;
    private String resourceGroupName;
    private String serverName;
    private String databaseName;
    private String schemaName;
    private String tableName;
    private String columnName;
    private SensitivityLabelSource sensitivityLabelSource;

    SensitivityLabelImpl(String name, SqlManager manager) {
        super(name, new SensitivityLabelInner());
        this.manager = manager;
        // Set resource name
        this.columnName = name;
        //
    }

    SensitivityLabelImpl(SensitivityLabelInner inner, SqlManager manager) {
        super(inner.name(), inner);
        this.manager = manager;
        // Set resource name
        this.columnName = inner.name();
        // set resource ancestor and positional variables
        this.resourceGroupName = IdParsingUtils.getValueFromIdByName(inner.id(), "resourceGroups");
        this.serverName = IdParsingUtils.getValueFromIdByName(inner.id(), "servers");
        this.databaseName = IdParsingUtils.getValueFromIdByName(inner.id(), "databases");
        this.schemaName = IdParsingUtils.getValueFromIdByName(inner.id(), "schemas");
        this.tableName = IdParsingUtils.getValueFromIdByName(inner.id(), "tables");
        this.columnName = IdParsingUtils.getValueFromIdByName(inner.id(), "columns");
        this.sensitivityLabelSource = SensitivityLabelSource.fromString(IdParsingUtils.getValueFromIdByName(inner.id(), "sensitivityLabels"));
        //
    }

    @Override
    public SqlManager manager() {
        return this.manager;
    }

    @Override
    public Observable<SensitivityLabel> createResourceAsync() {
        SensitivityLabelsInner client = this.manager().inner().sensitivityLabels();
        return client.createOrUpdateAsync(this.resourceGroupName, this.serverName, this.databaseName, this.schemaName, this.tableName, this.columnName, this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    public Observable<SensitivityLabel> updateResourceAsync() {
        SensitivityLabelsInner client = this.manager().inner().sensitivityLabels();
        return client.createOrUpdateAsync(this.resourceGroupName, this.serverName, this.databaseName, this.schemaName, this.tableName, this.columnName, this.inner())
            .map(innerToFluentMap(this));
    }

    @Override
    protected Observable<SensitivityLabelInner> getInnerAsync() {
        SensitivityLabelsInner client = this.manager().inner().sensitivityLabels();
        return client.getAsync(this.resourceGroupName, this.serverName, this.databaseName, this.schemaName, this.tableName, this.columnName, this.sensitivityLabelSource);
    }

    @Override
    public boolean isInCreateMode() {
        return this.inner().id() == null;
    }


    @Override
    public String id() {
        return this.inner().id();
    }

    @Override
    public String informationType() {
        return this.inner().informationType();
    }

    @Override
    public String informationTypeId() {
        return this.inner().informationTypeId();
    }

    @Override
    public Boolean isDisabled() {
        return this.inner().isDisabled();
    }

    @Override
    public String labelId() {
        return this.inner().labelId();
    }

    @Override
    public String labelName() {
        return this.inner().labelName();
    }

    @Override
    public String name() {
        return this.inner().name();
    }

    @Override
    public String type() {
        return this.inner().type();
    }

    @Override
    public SensitivityLabelImpl withExistingColumn(String resourceGroupName, String serverName, String databaseName, String schemaName, String tableName, String columnName) {
        this.resourceGroupName = resourceGroupName;
        this.serverName = serverName;
        this.databaseName = databaseName;
        this.schemaName = schemaName;
        this.tableName = tableName;
        this.columnName = columnName;
        return this;
    }

    @Override
    public SensitivityLabelImpl withInformationType(String informationType) {
        this.inner().withInformationType(informationType);
        return this;
    }

    @Override
    public SensitivityLabelImpl withInformationTypeId(String informationTypeId) {
        this.inner().withInformationTypeId(informationTypeId);
        return this;
    }

    @Override
    public SensitivityLabelImpl withLabelId(String labelId) {
        this.inner().withLabelId(labelId);
        return this;
    }

    @Override
    public SensitivityLabelImpl withLabelName(String labelName) {
        this.inner().withLabelName(labelName);
        return this;
    }

}

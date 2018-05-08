/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.logic.v2016_06_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The workflow run action repetition index.
 */
public class RepetitionIndex {
    /**
     * The scope.
     */
    @JsonProperty(value = "scopeName")
    private String scopeName;

    /**
     * The index.
     */
    @JsonProperty(value = "itemIndex", required = true)
    private int itemIndex;

    /**
     * Get the scopeName value.
     *
     * @return the scopeName value
     */
    public String scopeName() {
        return this.scopeName;
    }

    /**
     * Set the scopeName value.
     *
     * @param scopeName the scopeName value to set
     * @return the RepetitionIndex object itself.
     */
    public RepetitionIndex withScopeName(String scopeName) {
        this.scopeName = scopeName;
        return this;
    }

    /**
     * Get the itemIndex value.
     *
     * @return the itemIndex value
     */
    public int itemIndex() {
        return this.itemIndex;
    }

    /**
     * Set the itemIndex value.
     *
     * @param itemIndex the itemIndex value to set
     * @return the RepetitionIndex object itself.
     */
    public RepetitionIndex withItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
        return this;
    }

}
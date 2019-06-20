/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.servicefabric;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for UpgradeKind.
 */
public final class UpgradeKind extends ExpandableStringEnum<UpgradeKind> {
    /** Static value Invalid for UpgradeKind. */
    public static final UpgradeKind INVALID = fromString("Invalid");

    /** Static value Rolling for UpgradeKind. */
    public static final UpgradeKind ROLLING = fromString("Rolling");

    /**
     * Creates or finds a UpgradeKind from its string representation.
     * @param name a name to look for
     * @return the corresponding UpgradeKind
     */
    @JsonCreator
    public static UpgradeKind fromString(String name) {
        return fromString(name, UpgradeKind.class);
    }

    /**
     * @return known UpgradeKind values
     */
    public static Collection<UpgradeKind> values() {
        return values(UpgradeKind.class);
    }
}

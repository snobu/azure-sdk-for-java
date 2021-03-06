/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.automation.v2015_10_31;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for GroupTypeEnum.
 */
public final class GroupTypeEnum extends ExpandableStringEnum<GroupTypeEnum> {
    /** Static value User for GroupTypeEnum. */
    public static final GroupTypeEnum USER = fromString("User");

    /** Static value System for GroupTypeEnum. */
    public static final GroupTypeEnum SYSTEM = fromString("System");

    /**
     * Creates or finds a GroupTypeEnum from its string representation.
     * @param name a name to look for
     * @return the corresponding GroupTypeEnum
     */
    @JsonCreator
    public static GroupTypeEnum fromString(String name) {
        return fromString(name, GroupTypeEnum.class);
    }

    /**
     * @return known GroupTypeEnum values
     */
    public static Collection<GroupTypeEnum> values() {
        return values(GroupTypeEnum.class);
    }
}

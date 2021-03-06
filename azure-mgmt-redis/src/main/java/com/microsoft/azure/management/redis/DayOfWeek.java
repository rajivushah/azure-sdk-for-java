/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.redis;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for DayOfWeek.
 */
public final class DayOfWeek {
    /** Static value Monday for DayOfWeek. */
    public static final DayOfWeek MONDAY = new DayOfWeek("Monday");

    /** Static value Tuesday for DayOfWeek. */
    public static final DayOfWeek TUESDAY = new DayOfWeek("Tuesday");

    /** Static value Wednesday for DayOfWeek. */
    public static final DayOfWeek WEDNESDAY = new DayOfWeek("Wednesday");

    /** Static value Thursday for DayOfWeek. */
    public static final DayOfWeek THURSDAY = new DayOfWeek("Thursday");

    /** Static value Friday for DayOfWeek. */
    public static final DayOfWeek FRIDAY = new DayOfWeek("Friday");

    /** Static value Saturday for DayOfWeek. */
    public static final DayOfWeek SATURDAY = new DayOfWeek("Saturday");

    /** Static value Sunday for DayOfWeek. */
    public static final DayOfWeek SUNDAY = new DayOfWeek("Sunday");

    private String value;

    /**
     * Creates a custom value for DayOfWeek.
     * @param value the custom value
     */
    public DayOfWeek(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return value;
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DayOfWeek)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        DayOfWeek rhs = (DayOfWeek) obj;
        if (value == null) {
            return rhs.value == null;
        } else {
            return value.equals(rhs.value);
        }
    }
}

/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator 0.17.0.0
 * Changes may cause incorrect behavior and will be lost if the code is
 * regenerated.
 */

package com.microsoft.azure.keyvault.models;

import java.util.Map;

import com.microsoft.azure.keyvault.KeyIdentifier;

/**
 * The key item containing key metadata.
 */
public class KeyItem {
    /**
     * Key Identifier.
     */
    private String kid;

    /**
     * The key management attributes.
     */
    private KeyAttributes attributes;

    /**
     * Application-specific metadata in the form of key-value pairs.
     */
    private Map<String, String> tags;

    /**
     * Get the kid value.
     *
     * @return the kid value
     */
    public String kid() {
        return this.kid;
    }

    /**
     * Set the kid value.
     *
     * @param kid the kid value to set
     * @return the KeyItem object itself.
     */
    public KeyItem withKid(String kid) {
        this.kid = kid;
        return this;
    }

    /**
     * Get the attributes value.
     *
     * @return the attributes value
     */
    public KeyAttributes attributes() {
        return this.attributes;
    }

    /**
     * Set the attributes value.
     *
     * @param attributes the attributes value to set
     * @return the KeyItem object itself.
     */
    public KeyItem withAttributes(KeyAttributes attributes) {
        this.attributes = attributes;
        return this;
    }

    /**
     * Get the tags value.
     *
     * @return the tags value
     */
    public Map<String, String> tags() {
        return this.tags;
    }

    /**
     * Set the tags value.
     *
     * @param tags the tags value to set
     * @return the KeyItem object itself.
     */
    public KeyItem withTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * The key identifier.
     * @return The Identifier value
     */
    public KeyIdentifier identifier() {
        KeyIdentifier identifier = null;

        if (kid() != null && !kid().isEmpty()) {
            identifier = new KeyIdentifier(kid());
        }

        return identifier;
    }
}

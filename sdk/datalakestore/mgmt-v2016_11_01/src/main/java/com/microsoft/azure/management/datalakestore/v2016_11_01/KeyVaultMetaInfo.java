/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datalakestore.v2016_11_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Metadata information used by account encryption.
 */
public class KeyVaultMetaInfo {
    /**
     * The resource identifier for the user managed Key Vault being used to
     * encrypt.
     */
    @JsonProperty(value = "keyVaultResourceId", required = true)
    private String keyVaultResourceId;

    /**
     * The name of the user managed encryption key.
     */
    @JsonProperty(value = "encryptionKeyName", required = true)
    private String encryptionKeyName;

    /**
     * The version of the user managed encryption key.
     */
    @JsonProperty(value = "encryptionKeyVersion", required = true)
    private String encryptionKeyVersion;

    /**
     * Get the resource identifier for the user managed Key Vault being used to encrypt.
     *
     * @return the keyVaultResourceId value
     */
    public String keyVaultResourceId() {
        return this.keyVaultResourceId;
    }

    /**
     * Set the resource identifier for the user managed Key Vault being used to encrypt.
     *
     * @param keyVaultResourceId the keyVaultResourceId value to set
     * @return the KeyVaultMetaInfo object itself.
     */
    public KeyVaultMetaInfo withKeyVaultResourceId(String keyVaultResourceId) {
        this.keyVaultResourceId = keyVaultResourceId;
        return this;
    }

    /**
     * Get the name of the user managed encryption key.
     *
     * @return the encryptionKeyName value
     */
    public String encryptionKeyName() {
        return this.encryptionKeyName;
    }

    /**
     * Set the name of the user managed encryption key.
     *
     * @param encryptionKeyName the encryptionKeyName value to set
     * @return the KeyVaultMetaInfo object itself.
     */
    public KeyVaultMetaInfo withEncryptionKeyName(String encryptionKeyName) {
        this.encryptionKeyName = encryptionKeyName;
        return this;
    }

    /**
     * Get the version of the user managed encryption key.
     *
     * @return the encryptionKeyVersion value
     */
    public String encryptionKeyVersion() {
        return this.encryptionKeyVersion;
    }

    /**
     * Set the version of the user managed encryption key.
     *
     * @param encryptionKeyVersion the encryptionKeyVersion value to set
     * @return the KeyVaultMetaInfo object itself.
     */
    public KeyVaultMetaInfo withEncryptionKeyVersion(String encryptionKeyVersion) {
        this.encryptionKeyVersion = encryptionKeyVersion;
        return this;
    }

}

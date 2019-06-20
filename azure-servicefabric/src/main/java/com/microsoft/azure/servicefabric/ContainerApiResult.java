/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.servicefabric;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Container API result.
 */
public class ContainerApiResult {
    /**
     * HTTP status code returned by the target container API.
     */
    @JsonProperty(value = "Status", required = true)
    private int status;

    /**
     * HTTP content type.
     */
    @JsonProperty(value = "Content-Type")
    private String contentType;

    /**
     * HTTP content encoding.
     */
    @JsonProperty(value = "Content-Encoding")
    private String contentEncoding;

    /**
     * container API result body.
     */
    @JsonProperty(value = "Body")
    private String body;

    /**
     * Get hTTP status code returned by the target container API.
     *
     * @return the status value
     */
    public int status() {
        return this.status;
    }

    /**
     * Set hTTP status code returned by the target container API.
     *
     * @param status the status value to set
     * @return the ContainerApiResult object itself.
     */
    public ContainerApiResult withStatus(int status) {
        this.status = status;
        return this;
    }

    /**
     * Get hTTP content type.
     *
     * @return the contentType value
     */
    public String contentType() {
        return this.contentType;
    }

    /**
     * Set hTTP content type.
     *
     * @param contentType the contentType value to set
     * @return the ContainerApiResult object itself.
     */
    public ContainerApiResult withContentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    /**
     * Get hTTP content encoding.
     *
     * @return the contentEncoding value
     */
    public String contentEncoding() {
        return this.contentEncoding;
    }

    /**
     * Set hTTP content encoding.
     *
     * @param contentEncoding the contentEncoding value to set
     * @return the ContainerApiResult object itself.
     */
    public ContainerApiResult withContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
        return this;
    }

    /**
     * Get container API result body.
     *
     * @return the body value
     */
    public String body() {
        return this.body;
    }

    /**
     * Set container API result body.
     *
     * @param body the body value to set
     * @return the ContainerApiResult object itself.
     */
    public ContainerApiResult withBody(String body) {
        this.body = body;
        return this;
    }

}

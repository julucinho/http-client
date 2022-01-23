package com.julucinho.httpclient.impl;

import com.julucinho.httpclient.HttpRequestBuilder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractHttpRequestBuilder implements HttpRequestBuilder {

    protected final AbstractHttpRequestModel httpRequest;

}

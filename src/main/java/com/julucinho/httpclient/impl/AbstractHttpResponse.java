package com.julucinho.httpclient.impl;

import com.julucinho.httpclient.HttpRequestModel;
import com.julucinho.httpclient.HttpResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractHttpResponse implements HttpResponse {

    protected final HttpRequestModel httpRequestModel;
    protected final java.net.http.HttpResponse<String> unwrappedHttpResponse;
}

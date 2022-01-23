package com.julucinho.httpclient.impl;


import com.julucinho.httpclient.HttpRequestBuilder;
import com.julucinho.httpclient.HttpRequestStarter;

import java.net.http.HttpRequest;

public class HttpRequestStarterImpl implements HttpRequestStarter {

    @Override
    public HttpRequestBuilder startGetRequestModelFor(String url) {
        return HttpRequestBuilderImpl.of(HttpRequestModelImpl.of(url, new HttpRequestGetMethod()));
    }

    @Override
    public HttpRequestBuilder startPostRequestModelFor(String url, HttpRequest.BodyPublisher body) {
        return HttpRequestBuilderImpl.of(HttpRequestModelImpl.of(url, new HttpRequestPostMethod(), body));
    }

    @Override
    public HttpRequestBuilder startPutRequestModelFor(String url, HttpRequest.BodyPublisher body) {
        return HttpRequestBuilderImpl.of(HttpRequestModelImpl.of(url, new HttpRequestPutMethod(), body));
    }

    @Override
    public HttpRequestBuilder startDeleteRequestModelFor(String url) {
        return HttpRequestBuilderImpl.of(HttpRequestModelImpl.of(url, new HttpRequestDeleteMethod()));
    }
}

package io.github.julucinho.httpclient.impl;

import io.github.julucinho.httpclient.HttpRequestMethod;
import io.github.julucinho.httpclient.HttpRequestModel;
import io.github.julucinho.httpclient.HttpResponseHandler;
import io.github.julucinho.httpclient.RetryCounter;

import java.net.http.HttpRequest.BodyPublisher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractHttpRequestModel implements HttpRequestModel {

    protected String uri;
    protected final List<HttpRequestPathVariable> pathVariables = new ArrayList<>();
    protected final List<HttpRequestQueryParameter> queryParameters = new ArrayList<>();
    protected final Map<String, String> headers = new HashMap<>();
    protected BodyPublisher body;
    protected HttpRequestMethod method;
    protected HttpResponseHandler genericResponseHandler;
    protected final Map<Integer, HttpResponseHandler> responseHandlersByStatusCode = new HashMap<>();
    protected final Map<Class<? extends Exception>, HttpResponseHandler> responseHandlersByExceptionType = new HashMap<>();
    protected final Map<Integer, RetryCounter> retryCountersByStatusCode = new HashMap<>();
    protected final Map<Class<? extends Exception>, RetryCounter> retryCountersByExceptionType = new HashMap<>();

}

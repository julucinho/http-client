package com.julucinho.httpclient.impl;

import com.julucinho.httpclient.HttpRequestMethod;
import com.julucinho.httpclient.HttpRequestModel;
import com.julucinho.httpclient.HttpResponseHandler;
import com.julucinho.httpclient.RetryCounter;

import java.net.http.HttpRequest.BodyPublisher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractHttpRequestModel implements HttpRequestModel {

    protected String uri;
    protected List<HttpRequestPathVariable> pathVariables = new ArrayList<>();
    protected List<HttpRequestQueryParameter> queryParameters = new ArrayList<>();
    protected Map<String, String> headers = new HashMap<>();
    protected BodyPublisher body;
    protected HttpRequestMethod method;
    protected Map<Integer, HttpResponseHandler> responseHandlersByStatusCode = new HashMap<>();
    protected HttpResponseHandler genericResponseHandler;
    protected Map<Class<? extends Exception>, HttpResponseHandler> responseHandlersByExceptionType = new HashMap<>();
    protected Map<Integer, RetryCounter> retryCountersByStatusCode = new HashMap<>();
    protected Map<Class<? extends Exception>, RetryCounter> retryCountersByExceptionType = new HashMap<>();


}

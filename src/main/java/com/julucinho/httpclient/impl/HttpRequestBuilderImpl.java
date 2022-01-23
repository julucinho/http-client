package com.julucinho.httpclient.impl;


import com.julucinho.httpclient.*;
import com.julucinho.httpclient.commons.RetriersByExceptionTypeFactory;

public class HttpRequestBuilderImpl extends AbstractHttpRequestBuilder {

    public static HttpRequestBuilder of(AbstractHttpRequestModel httpRequest){
        return new HttpRequestBuilderImpl(httpRequest);
    }

    private HttpRequestBuilderImpl(AbstractHttpRequestModel httpRequest) {
        super(httpRequest);
    }

    @Override
    public HttpRequestBuilder andAddHeaderOf(String key, String value) {
        this.httpRequest.headers.put(key, value);
        return this;
    }

    @Override
    public HttpRequestBuilder andAddHeadersFactory(HttpRequestHeaderFactory httpRequestHeaderFactory) {
        httpRequestHeaderFactory.makeHeaders().forEach(this.httpRequest.headers::put);
        return this;
    }

    @Override
    public HttpRequestBuilder andAddPathVariableOf(String pathVariableName, String pathVariableValue) {
        this.httpRequest.pathVariables.add(new HttpRequestPathVariable(pathVariableName, pathVariableValue));
        return this;
    }

    @Override
    public HttpRequestBuilder andAddQueryParameterOf(String queryParameterName, String queryParameterValue) {
        this.httpRequest.queryParameters.add(new HttpRequestQueryParameter(queryParameterName, queryParameterValue));
        return this;
    }

    @Override
    public HttpRequestModel andFinishBuildingModel() {
        return this.httpRequest;
    }

    @Override
    public HttpRequestBuilder andAddResponseHandlerByHttpStatusCode(Integer statusCode, HttpResponseHandler httpResponseHandler) {
        this.httpRequest.responseHandlersByStatusCode.put(statusCode, httpResponseHandler);
        return this;
    }

    @Override
    public HttpRequestBuilder andAddResponseHandlersByHttpStatusCode(HttpResponseHandlersByStatusCodeFactory httpResponseHandlersByStatusCodeFactory) {
        httpResponseHandlersByStatusCodeFactory.makeHandlers().forEach(this.httpRequest.responseHandlersByStatusCode::put);
        return this;
    }

    @Override
    public HttpRequestBuilder andAddResponseHandlerForAnyNotSuccessfulResponse(HttpResponseHandler httpResponseHandler) {
        this.httpRequest.genericResponseHandler = httpResponseHandler;
        return this;
    }

    @Override
    public HttpRequestBuilder andAddResponseHandlersByExceptionType(HttpResponseHandlersByExceptionTypeFactory httpResponseHandlersByExceptionTypeFactory) {
        httpResponseHandlersByExceptionTypeFactory.makeHandlers().forEach(this.httpRequest.responseHandlersByExceptionType::put);
        return this;
    }

    @Override
    public HttpRequestBuilder andAddResponseHandlerByExceptionType(Class<? extends Exception> exceptionType, HttpResponseHandler httpResponseHandler) {
        this.httpRequest.responseHandlersByExceptionType.put(exceptionType, httpResponseHandler);
        return this;
    }

    @Override
    public HttpRequestBuilder andAddRetrierByHttpStatusCode(Integer statusCode, RetrierModel retrierModel) {
        this.httpRequest.retryCountersByStatusCode.put(statusCode, RetryCounterImpl.of(retrierModel));
        return this;
    }

    @Override
    public HttpRequestBuilder andAddRetriersByHttpStatusCode(RetriersByStatusCodeFactory retriersByStatusCodeFactory) {
        retriersByStatusCodeFactory.makeRetriers().forEach((statusCode, retrierModel) -> this.httpRequest.retryCountersByStatusCode.put(statusCode, RetryCounterImpl.of(retrierModel)));
        return this;
    }

    @Override
    public HttpRequestBuilder andAddRetriersByExceptionType(RetriersByExceptionTypeFactory retriersByExceptionTypeFactory) {
        retriersByExceptionTypeFactory.makeRetriers().forEach((exceptionType, retrierModel) -> this.httpRequest.retryCountersByExceptionType.put(exceptionType, RetryCounterImpl.of(retrierModel)));
        return this;
    }

    @Override
    public HttpRequestBuilder andAddRetrierByExceptionType(Class<? extends Exception> exceptionType, RetrierModel retrierModel) {
        this.httpRequest.retryCountersByExceptionType.put(exceptionType, RetryCounterImpl.of(retrierModel));
        return this;
    }
}

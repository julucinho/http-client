package io.github.julucinho.httpclient;


import io.github.julucinho.httpclient.impl.HttpResponseHandlersByStatusCodeFactory;

public interface HttpRequestBuilderForHandlers {

    HttpRequestBuilder andAddResponseHandlerByHttpStatusCode(Integer statusCode, HttpResponseHandler httpResponseHandler);
    HttpRequestBuilder andAddResponseHandlersByHttpStatusCode(HttpResponseHandlersByStatusCodeFactory httpResponseHandlersByStatusCodeFactory);
    HttpRequestBuilder andAddResponseHandlerForAnyNotSuccessfulResponse(HttpResponseHandler httpResponseHandler);
    HttpRequestBuilder andAddResponseHandlersByExceptionType(HttpResponseHandlersByExceptionTypeFactory httpResponseHandlersByExceptionTypeFactory);
    HttpRequestBuilder andAddResponseHandlerByExceptionType(Class<? extends Exception> exceptionType, HttpResponseHandler httpResponseHandler);

}

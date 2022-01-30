package io.github.julucinho.httpclient;


import io.github.julucinho.httpclient.impl.HttpResponseHandlersByStatusCodeFactory;

public interface HttpRequestBuilderForHandlers {

    HttpRequestBuilder andAddResponseHandlerByHttpStatusCode(Integer statusCode, HttpResponseHandler httpResponseHandler);
    HttpRequestBuilder andAddResponseHandlersByHttpStatusCodeFactory(HttpResponseHandlersByStatusCodeFactory httpResponseHandlersByStatusCodeFactory);
    HttpRequestBuilder andAddResponseHandlerForAnyNotSuccessfulResponse(HttpResponseHandler httpResponseHandler);
    HttpRequestBuilder andAddExceptionHandlersByExceptionTypeFactory(HttpExceptionHandlersByExceptionTypeFactory httpExceptionHandlersByExceptionTypeFactory);
    HttpRequestBuilder andAddExceptionHandlerByExceptionType(Class<? extends Exception> exceptionType, ExceptionHandler exceptionHandler);

}

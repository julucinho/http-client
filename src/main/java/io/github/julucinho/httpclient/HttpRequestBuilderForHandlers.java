package io.github.julucinho.httpclient;


public interface HttpRequestBuilderForHandlers {

    HttpRequestBuilder andAddResponseHandlerByHttpStatusCode(Integer statusCode, HttpResponseHandler httpResponseHandler);
    HttpRequestBuilder andAddResponseHandlersByHttpStatusCodeFactory(HttpResponseHandlersByStatusCodeFactory httpResponseHandlersByStatusCodeFactory);
    HttpRequestBuilder andAddResponseHandlerForAnyNotSuccessfulResponse(HttpResponseHandler httpResponseHandler);
    HttpRequestBuilder andAddExceptionHandlersByExceptionTypeFactory(HttpExceptionHandlersByExceptionTypeFactory httpExceptionHandlersByExceptionTypeFactory);
    HttpRequestBuilder andAddExceptionHandlerByExceptionType(Class<? extends Exception> exceptionType, ExceptionHandler exceptionHandler);

}

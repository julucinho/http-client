package com.julucinho.httpclient;

import com.julucinho.httpclient.commons.RetriersByExceptionTypeFactory;

public interface HttpRequestBuilderForRetrying {

    HttpRequestBuilder andAddRetrierByHttpStatusCode(Integer statusCode, RetrierModel retrierModel);
    HttpRequestBuilder andAddRetriersByHttpStatusCode(RetriersByStatusCodeFactory retriersByStatusCodeFactory);
    HttpRequestBuilder andAddRetriersByExceptionType(RetriersByExceptionTypeFactory retriersByExceptionTypeFactory);
    HttpRequestBuilder andAddRetrierByExceptionType(Class<? extends Exception> exceptionType, RetrierModel retrierModel);
}

package com.julucinho.httpclient;


import com.julucinho.httpclient.impl.exceptions.RetryNeededOnExceptionThrownException;

public interface HttpRequestMethod {

    HttpResponse execute(HttpRequestModel httpRequestModel) throws RetryNeededOnExceptionThrownException;

}

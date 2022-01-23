package com.julucinho.httpclient.impl;


import com.julucinho.httpclient.HttpRequestMethod;
import com.julucinho.httpclient.HttpRequestModel;
import com.julucinho.httpclient.HttpResponse;
import com.julucinho.httpclient.impl.exceptions.RetryNeededOnExceptionThrownException;

public class HttpRequestGetMethod implements HttpRequestMethod {

    @Override
    public HttpResponse execute(HttpRequestModel httpRequestModel) throws RetryNeededOnExceptionThrownException {
        var finalRequest = FinalHttpRequestFactory.makeFinalRequestForGetMethodFrom((AbstractHttpRequestModel) httpRequestModel);
        try {
            var unwrappedResponse = FinalHttpRequestExecutor.execute(finalRequest);
            return new HttpResponseImpl(httpRequestModel, unwrappedResponse);
        }
        catch (Exception e) {
            ExceptionThrownByHttpRequestChecker.of((AbstractHttpRequestModel) httpRequestModel).checkOn(e);
            throw e;
        }
    }
}

package com.julucinho.httpclient.impl;


import com.julucinho.httpclient.HttpRequestMethod;
import com.julucinho.httpclient.HttpRequestModel;
import com.julucinho.httpclient.HttpResponse;
import com.julucinho.httpclient.impl.exceptions.RetryNeededOnExceptionThrownException;

public class HttpRequestPostMethod implements HttpRequestMethod {

    @Override
    public HttpResponse execute(HttpRequestModel httpRequestModel) throws RetryNeededOnExceptionThrownException {
        var finalRequest = FinalHttpRequestFactory.makeFinalRequestForPostMethodFrom((AbstractHttpRequestModel) httpRequestModel);
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

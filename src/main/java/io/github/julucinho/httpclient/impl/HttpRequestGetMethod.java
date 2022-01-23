package io.github.julucinho.httpclient.impl;


import io.github.julucinho.httpclient.HttpRequestMethod;
import io.github.julucinho.httpclient.HttpRequestModel;
import io.github.julucinho.httpclient.HttpResponse;
import io.github.julucinho.httpclient.impl.exceptions.RetryNeededOnExceptionThrownException;

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

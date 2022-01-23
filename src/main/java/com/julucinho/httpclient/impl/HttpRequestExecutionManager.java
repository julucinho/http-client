package com.julucinho.httpclient.impl;

import com.julucinho.httpclient.HttpResponse;
import com.julucinho.httpclient.impl.exceptions.RetryNeededOnExceptionThrownException;
import com.julucinho.httpclient.impl.exceptions.RetryNeededOnHttpStatusCodeException;
import com.julucinho.httpclient.impl.loggers.HttpRequestSendingManagerLogger;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
class HttpRequestExecutionManager {

    protected AbstractHttpRequestModel httpRequest;

    static HttpRequestExecutionManager of(AbstractHttpRequestModel httpRequest){
        var manager = new HttpRequestExecutionManager();
        manager.httpRequest = httpRequest;
        return manager;
    }

    protected HttpResponse run() {
        try {
            var response = this.httpRequest.method.execute(this.httpRequest);
            response.ifNeedsHandling(HttpResponseStatusCodeChecker.of(this.httpRequest)::checkOnResponse);
            return response;
        } catch (RetryNeededOnHttpStatusCodeException | RetryNeededOnExceptionThrownException exception) {
            HttpRequestSendingManagerLogger.logRetryMessage(exception.getMessage());
            return this.run();
        }
    }

}

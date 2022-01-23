package com.julucinho.httpclient.impl.exceptions;

import com.julucinho.httpclient.HttpResponse;
import lombok.Getter;

@Getter
public class RetryNeededOnHttpStatusCodeException extends RuntimeException{

    private final HttpResponse httpResponse;

    public RetryNeededOnHttpStatusCodeException(HttpResponse httpResponse){
        super("Retry needed on ".concat(httpResponse.getStatusCode().toString()).concat(" received"));
        this.httpResponse = httpResponse;
    }

}

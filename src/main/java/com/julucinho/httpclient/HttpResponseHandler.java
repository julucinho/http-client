package com.julucinho.httpclient;

@FunctionalInterface
public interface HttpResponseHandler {

    void handle(HttpResponse httpResponse);

}

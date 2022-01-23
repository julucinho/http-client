package io.github.julucinho.httpclient.impl;

import io.github.julucinho.httpclient.impl.exceptions.IORuntimeException;
import io.github.julucinho.httpclient.impl.exceptions.InterruptedRuntimeException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FinalHttpRequestExecutor {


    public static HttpResponse<String> execute(HttpRequest finalRequest){
        try {
            return HttpClient.newHttpClient().send(finalRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new IORuntimeException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new InterruptedRuntimeException(e);
        }
    }
}

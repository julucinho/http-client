package com.julucinho.httpclient;

public interface RetryCounter {
    boolean thereIsRetryAvailable();
    void decreaseRetriesAvailable();
}

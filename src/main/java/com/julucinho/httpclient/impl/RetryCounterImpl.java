package com.julucinho.httpclient.impl;

import com.julucinho.httpclient.RetrierModel;
import com.julucinho.httpclient.RetryCounter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RetryCounterImpl implements RetryCounter {

    private final RetrierModel retrierModel;

    public static RetryCounter of(RetrierModel retrierModel){
        return new RetryCounterImpl(retrierModel);
    }

    @Override
    public boolean thereIsRetryAvailable() {
        return this.retrierModel.getRetriesRemaining() > 0;
    }

    @Override
    public void decreaseRetriesAvailable() {
        this.retrierModel.setRetriesRemaining(this.retrierModel.getRetriesRemaining()-1);
    }
}

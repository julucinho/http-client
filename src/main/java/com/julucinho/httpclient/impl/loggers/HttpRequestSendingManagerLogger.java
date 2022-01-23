package com.julucinho.httpclient.impl.loggers;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HttpRequestSendingManagerLogger {

    public static void logRetryMessage(String retryMessage){
        Logger.logInfo(retryMessage);
    }

}

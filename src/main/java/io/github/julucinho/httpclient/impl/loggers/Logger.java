package io.github.julucinho.httpclient.impl.loggers;

import io.github.julucinho.httpclient.utils.ThreadIdRetrievementUtil;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Logger {

    public static void logInfo(String message){     }

    public static void logError(String message){

    }

    private static String getSuffix(){
        return " | ".concat(ThreadIdRetrievementUtil.retrieveThreadId());
    }

}

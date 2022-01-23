package io.github.julucinho.httpclient.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class ThreadIdRetrievementUtil {

    public static String retrieveThreadId(){
        return "Current thread: "
                .concat(String.valueOf(Thread.currentThread().getId())
                .concat(":")
                .concat(Thread.currentThread().getName()));
    }

}

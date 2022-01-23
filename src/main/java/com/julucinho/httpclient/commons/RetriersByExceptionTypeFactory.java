package com.julucinho.httpclient.commons;


import com.julucinho.httpclient.RetrierModel;

import java.util.Map;

public interface RetriersByExceptionTypeFactory extends RetriersFactory<Map<Class<? extends Exception>, RetrierModel>> {
}

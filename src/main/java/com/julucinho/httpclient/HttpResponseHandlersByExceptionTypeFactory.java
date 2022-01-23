package com.julucinho.httpclient;


import com.julucinho.httpclient.commons.HandlersFactory;

import java.util.Map;

public interface HttpResponseHandlersByExceptionTypeFactory extends HandlersFactory<Map<Class<? extends Exception>, HttpResponseHandler>> { }

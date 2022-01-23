package io.github.julucinho.httpclient;


import io.github.julucinho.httpclient.commons.HandlersFactory;

import java.util.Map;

public interface HttpResponseHandlersByExceptionTypeFactory extends HandlersFactory<Map<Class<? extends Exception>, HttpResponseHandler>> { }

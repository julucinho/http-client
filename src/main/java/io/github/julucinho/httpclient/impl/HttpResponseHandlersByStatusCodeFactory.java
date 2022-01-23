package io.github.julucinho.httpclient.impl;


import io.github.julucinho.httpclient.HttpResponseHandler;
import io.github.julucinho.httpclient.commons.HandlersFactory;

import java.util.Map;

public interface HttpResponseHandlersByStatusCodeFactory extends HandlersFactory<Map<Integer, HttpResponseHandler>> { }

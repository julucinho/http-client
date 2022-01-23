package com.julucinho.httpclient.impl;


import com.julucinho.httpclient.HttpResponseHandler;
import com.julucinho.httpclient.commons.HandlersFactory;

import java.util.Map;

public interface HttpResponseHandlersByStatusCodeFactory extends HandlersFactory<Map<Integer, HttpResponseHandler>> { }

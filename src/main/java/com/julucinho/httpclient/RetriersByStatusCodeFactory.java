package com.julucinho.httpclient;

import com.julucinho.httpclient.commons.RetriersFactory;

import java.util.Map;

public interface RetriersByStatusCodeFactory extends RetriersFactory<Map<Integer, RetrierModel>> {
}

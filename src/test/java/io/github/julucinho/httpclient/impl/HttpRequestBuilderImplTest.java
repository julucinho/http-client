package io.github.julucinho.httpclient.impl;

import io.github.julucinho.httpclient.HttpRequestHeaderFactory;
import io.github.julucinho.httpclient.HttpResponseHandler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@ExtendWith(MockitoExtension.class)
class HttpRequestBuilderImplTest {

    @Test
    @DisplayName("Should add header correctly")
    void shouldAddHeaderCorrectly(){
        var request = HttpRequestModelImpl.of("http://localhost:8080/users", new HttpRequestGetMethod());
        var builder = HttpRequestBuilderImpl.of(request);
        var key = "chuchu";
        builder.andAddHeaderOf(key, "Duda");
        Assertions.assertNotNull(request.headers.get(key));
    }

    @Test
    @DisplayName("Should return builder instance when finishing method of adding header")
    void shouldReturnBuilderInstanceWhenFinishingMethodOfAddingHeader(){
        var request = HttpRequestModelImpl.of("http://localhost:8080/users", new HttpRequestGetMethod());
        var builder = HttpRequestBuilderImpl.of(request);
        var returnedBuilder = builder.andAddHeaderOf("chuchu", "Duda");
        Assertions.assertNotNull(returnedBuilder);
        Assertions.assertEquals(builder, returnedBuilder);
    }

    private static class HeadersFactoryForTestingMatters implements HttpRequestHeaderFactory{

        static final String KEY_1 = "chuchu";
        static final String KEY_2 = "biridinho";
        static final String KEY_3 = "biridao";

        @Override
        public Map<String, String> makeHeaders() {
            var headers = new HashMap<String, String>();
            headers.put(KEY_1, "Duda");
            headers.put(KEY_2, "Zena");
            headers.put(KEY_3, "Mingau");
            return headers;
        }
    }

    @Test
    @DisplayName("Should add headers factory correctly")
    void shouldAddHeadersFactoryCorrectly(){
        var request = HttpRequestModelImpl.of("http://localhost:8080/users", new HttpRequestGetMethod());
        var builder = HttpRequestBuilderImpl.of(request);
        builder.andAddHeadersFactory(new HeadersFactoryForTestingMatters());
        Arrays.asList(HeadersFactoryForTestingMatters.KEY_1,
                HeadersFactoryForTestingMatters.KEY_2,
                HeadersFactoryForTestingMatters.KEY_3)
                .forEach(key -> Assertions.assertNotNull(request.headers.get(key)));
    }

    @Test
    @DisplayName("Should return builder instance when finishing method of adding headers factory")
    void shouldReturnBuilderInstanceWhenFinishingMethodOfAddingHeaderFactory(){
        var request = HttpRequestModelImpl.of("http://localhost:8080/users", new HttpRequestGetMethod());
        var builder = HttpRequestBuilderImpl.of(request);
        var returnedBuilder = builder.andAddHeadersFactory(new HeadersFactoryForTestingMatters());
        Assertions.assertNotNull(returnedBuilder);
        Assertions.assertEquals(builder, returnedBuilder);
    }

    @Test
    @DisplayName("Should add path variable correctly")
    void shouldAddPathVariableCorrectly(){
        var request = HttpRequestModelImpl.of("http://localhost:8080/users", new HttpRequestGetMethod());
        var builder = HttpRequestBuilderImpl.of(request);
        builder.andAddPathVariableOf("test", "testValue");
        Assertions.assertFalse(request.pathVariables.isEmpty());
        Assertions.assertEquals("/test/testValue", request.pathVariables.get(0).buildPathVariable());
    }

    @Test
    @DisplayName("Should return builder instance when finishing method of adding path variable")
    void shouldReturnBuilderInstanceWhenFinishingMethodOfAddingPathVariable(){
        var request = HttpRequestModelImpl.of("http://localhost:8080/users", new HttpRequestGetMethod());
        var builder = HttpRequestBuilderImpl.of(request);
        var returnedBuilder = builder.andAddPathVariableOf("test", "testValue");
        Assertions.assertNotNull(returnedBuilder);
        Assertions.assertEquals(builder, returnedBuilder);
    }

    @Test
    @DisplayName("Should add query param correctly")
    void shouldAddQueryParamCorrectly(){
        var request = HttpRequestModelImpl.of("http://localhost:8080/users", new HttpRequestGetMethod());
        var builder = HttpRequestBuilderImpl.of(request);
        builder.andAddQueryParameterOf("test", "testValue");
        Assertions.assertFalse(request.queryParameters.isEmpty());
        Assertions.assertEquals("test=testValue", request.queryParameters.get(0).buildQueryParameter());
    }

    @Test
    @DisplayName("Should return builder instance when finishing method of adding query param")
    void shouldReturnBuilderInstanceWhenFinishingMethodOfAddingQueryParam(){
        var request = HttpRequestModelImpl.of("http://localhost:8080/users", new HttpRequestGetMethod());
        var builder = HttpRequestBuilderImpl.of(request);
        var returnedBuilder = builder.andAddQueryParameterOf("test", "testValue");
        Assertions.assertNotNull(returnedBuilder);
        Assertions.assertEquals(builder, returnedBuilder);
    }

    @Test
    @DisplayName("Should finish building process returning request model instance")
    void shouldFinishBuildingProcessReturningRequestModelInstance(){
        var request = HttpRequestModelImpl.of("http://localhost:8080/users", new HttpRequestGetMethod());
        var builder = HttpRequestBuilderImpl.of(request);
        var resultFromBuilding = builder.andFinishBuildingModel();
        Assertions.assertNotNull(resultFromBuilding);
        Assertions.assertEquals(request, resultFromBuilding);
    }

    @Test
    @DisplayName("Should add response handler by status code correctly")
    void shouldAddResponseHandlerByStatusCodeCorrectly(){
        var request = HttpRequestModelImpl.of("http://localhost:8080/users", new HttpRequestGetMethod());
        var builder = HttpRequestBuilderImpl.of(request);
        var statusCode = 400;
        var handler = (HttpResponseHandler) response -> System.out.println("hello, 400");
        builder.andAddResponseHandlerByHttpStatusCode(statusCode, handler);
        Assertions.assertFalse(request.responseHandlersByStatusCode.isEmpty());
        Assertions.assertEquals(handler, request.responseHandlersByStatusCode.get(statusCode));
    }

    @Test
    @DisplayName("Should return builder instance when finishing method of adding handler by status code")
    void shouldReturnBuilderInstanceWhenFinishingMethodOfAddingResponseHandlerByStatusCode(){
        var request = HttpRequestModelImpl.of("http://localhost:8080/users", new HttpRequestGetMethod());
        var builder = HttpRequestBuilderImpl.of(request);
        var statusCode = 400;
        var handler = (HttpResponseHandler) response -> System.out.println("hello, 400");
        var returnedBuilder = builder.andAddResponseHandlerByHttpStatusCode(statusCode, handler);
        Assertions.assertNotNull(returnedBuilder);
        Assertions.assertEquals(builder, returnedBuilder);
    }



}

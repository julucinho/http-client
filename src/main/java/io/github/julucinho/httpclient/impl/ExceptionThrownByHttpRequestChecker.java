package io.github.julucinho.httpclient.impl;

import io.github.julucinho.httpclient.impl.exceptions.RetryNeededOnExceptionThrownException;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import static java.util.Optional.ofNullable;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionThrownByHttpRequestChecker {

    private final AbstractHttpRequestModel httpRequestModel;

    public static ExceptionThrownByHttpRequestChecker of(AbstractHttpRequestModel httpRequestModel) {
        return new ExceptionThrownByHttpRequestChecker(httpRequestModel);
    }

    public void checkOn(Exception e) {
        var handlerByThisException = ofNullable(((AbstractHttpRequestModel) httpRequestModel).responseHandlersByExceptionType.get(e.getClass()));
        if (handlerByThisException.isPresent()) {
            throw new RetryNeededOnExceptionThrownException(e.getClass());
        }
    }
}

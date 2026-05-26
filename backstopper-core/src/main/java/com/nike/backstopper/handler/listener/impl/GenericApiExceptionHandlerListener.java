package com.nike.backstopper.handler.listener.impl;

import com.nike.backstopper.apierror.SortedApiErrorSet;
import com.nike.backstopper.exception.ApiException;
import com.nike.backstopper.handler.listener.ApiExceptionHandlerListener;
import com.nike.backstopper.handler.listener.ApiExceptionHandlerListenerResult;
import com.nike.internal.util.Pair;
import com.nike.internal.util.StringUtils;
import java.util.ArrayList;
import java.util.List;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

/**
 * Handles generic {@link ApiException} errors by simply setting {@link ApiExceptionHandlerListenerResult#errors} to
 * {@link ApiException#getApiErrors()} and adding any {@link ApiException#getExtraDetailsForLogging()} and/or
 * {@link ApiException#getExtraResponseHeaders()}.
 */
@Named
@Singleton
public class GenericApiExceptionHandlerListener implements ApiExceptionHandlerListener {

    @Override
    public ApiExceptionHandlerListenerResult shouldHandleException(Throwable ex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

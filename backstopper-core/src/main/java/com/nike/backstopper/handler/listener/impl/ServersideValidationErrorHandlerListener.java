package com.nike.backstopper.handler.listener.impl;

import com.nike.backstopper.apierror.ApiError;
import com.nike.backstopper.apierror.SortedApiErrorSet;
import com.nike.backstopper.apierror.projectspecificinfo.ProjectApiErrors;
import com.nike.backstopper.exception.ServersideValidationError;
import com.nike.backstopper.exception.network.DownstreamRequestOrResponseBodyFailedValidationException;
import com.nike.backstopper.handler.ApiExceptionHandlerUtils;
import com.nike.backstopper.handler.listener.ApiExceptionHandlerListener;
import com.nike.backstopper.handler.listener.ApiExceptionHandlerListenerResult;
import com.nike.internal.util.Pair;
import java.util.ArrayList;
import java.util.List;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import jakarta.validation.ConstraintViolation;
import static com.nike.backstopper.apierror.SortedApiErrorSet.singletonSortedSetOf;

/**
 * Handles {@link ServersideValidationError} exceptions by adding the relevant logging info useful for debugging to the
 * returned {@link ApiExceptionHandlerListenerResult#extraDetailsForLogging} and setting the returned
 * {@link ApiExceptionHandlerListenerResult#errors} to {@link ProjectApiErrors#getServersideValidationApiError()}.
 *
 * <p>NOTE: This class also handles {@link DownstreamRequestOrResponseBodyFailedValidationException} exceptions the same
 * way if the exception's cause is a {@link ServersideValidationError}. It will just extract the wrapped
 * {@link ServersideValidationError} and use that as if it was passed in directly.
 *
 * @author Nic Munroe
 */
@Named
@Singleton
@SuppressWarnings("WeakerAccess")
public class ServersideValidationErrorHandlerListener implements ApiExceptionHandlerListener {

    protected final ProjectApiErrors projectApiErrors;

    protected final ApiExceptionHandlerUtils utils;

    /**
     * @param projectApiErrors The {@link ProjectApiErrors} that should be used by this instance when finding
     *                          {@link ApiError}s. Cannot be null.
     * @param utils The {@link ApiExceptionHandlerUtils} that should be used by this instance. You can pass in
     *              {@link ApiExceptionHandlerUtils#DEFAULT_IMPL} if you don't need custom logic.
     */
    @Inject
    public ServersideValidationErrorHandlerListener(ProjectApiErrors projectApiErrors, ApiExceptionHandlerUtils utils) {
        if (projectApiErrors == null)
            throw new IllegalArgumentException("ProjectApiErrors cannot be null");
        if (utils == null)
            throw new IllegalArgumentException("apiExceptionHandlerUtils cannot be null.");
        this.projectApiErrors = projectApiErrors;
        this.utils = utils;
    }

    @Override
    public ApiExceptionHandlerListenerResult shouldHandleException(Throwable ex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return A {@link SortedApiErrorSet} containing {@link ProjectApiErrors#getServersideValidationApiError()}
     *          after populating the extraDetailsForLogging with the relevant info from the exception.
     */
    protected SortedApiErrorSet processServersideValidationError(ServersideValidationError ex, List<Pair<String, String>> extraDetailsForLogging) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

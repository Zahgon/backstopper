package com.nike.backstopper.handler.listener.impl;

import com.nike.backstopper.apierror.ApiError;
import com.nike.backstopper.apierror.ApiErrorWithMetadata;
import com.nike.backstopper.apierror.SortedApiErrorSet;
import com.nike.backstopper.apierror.projectspecificinfo.ProjectApiErrors;
import com.nike.backstopper.exception.ClientDataValidationError;
import com.nike.backstopper.handler.ApiExceptionHandlerUtils;
import com.nike.backstopper.handler.listener.ApiExceptionHandlerListener;
import com.nike.backstopper.handler.listener.ApiExceptionHandlerListenerResult;
import com.nike.internal.util.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import jakarta.validation.ConstraintViolation;
import static com.nike.backstopper.apierror.SortedApiErrorSet.singletonSortedSetOf;

/**
 * Handles {@link ClientDataValidationError} exceptions by adding the relevant logging info useful for debugging to the
 * returned {@link ApiExceptionHandlerListenerResult#extraDetailsForLogging} and setting the returned
 * {@link ApiExceptionHandlerListenerResult#errors} to the appropriate mapped errors from {@link #projectApiErrors}
 * based on the messages in the constraint violations.
 *
 * @author Nic Munroe
 */
@Named
@Singleton
@SuppressWarnings("WeakerAccess")
public class ClientDataValidationErrorHandlerListener implements ApiExceptionHandlerListener {

    protected final ProjectApiErrors projectApiErrors;

    protected final ApiExceptionHandlerUtils utils;

    /**
     * @param projectApiErrors The {@link ProjectApiErrors} that should be used by this instance when finding
     *                          {@link ApiError}s. Cannot be null.
     * @param utils The {@link ApiExceptionHandlerUtils} that should be used by this instance. You can pass in
     *              {@link ApiExceptionHandlerUtils#DEFAULT_IMPL} if you don't need custom logic.
     */
    @Inject
    public ClientDataValidationErrorHandlerListener(ProjectApiErrors projectApiErrors, ApiExceptionHandlerUtils utils) {
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
     * Populates the extraDetailsForLogging with some relevant info from the exception for debugging and then returns a
     * SortedApiErrorSet containing the appropriate mapped errors from {@link #projectApiErrors}.
     */
    protected SortedApiErrorSet processClientDataValidationError(ClientDataValidationError ex, List<Pair<String, String>> extraDetailsForLogging) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Helper method for translating the given set of constraint violations set into a set of {@link ApiError} objects
     * by calling {@link #convertValidationErrorToApiError(ConstraintViolation)} on each one.
     */
    protected SortedApiErrorSet convertValidationErrorsToApiErrors(List<ConstraintViolation<Object>> validationErrors) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return Converts the given constraint violation to a {@link ApiError} if the constraint violation's
     *          {@link ConstraintViolation#getMessage()} can be converted via
     *          {@link ProjectApiErrors#convertToApiError(String, ApiError)}, otherwise falls back to
     *          {@link ProjectApiErrors#getGenericServiceError()}.
     */
    protected ApiError convertValidationErrorToApiError(ConstraintViolation<Object> validationError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

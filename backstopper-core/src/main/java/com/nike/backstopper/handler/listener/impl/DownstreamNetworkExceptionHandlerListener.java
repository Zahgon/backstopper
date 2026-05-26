package com.nike.backstopper.handler.listener.impl;

import com.nike.backstopper.apierror.ApiError;
import com.nike.backstopper.apierror.SortedApiErrorSet;
import com.nike.backstopper.apierror.projectspecificinfo.ProjectApiErrors;
import com.nike.backstopper.exception.network.ServerHttpStatusCodeException;
import com.nike.backstopper.exception.network.ServerTimeoutException;
import com.nike.backstopper.exception.network.ServerUnknownHttpStatusCodeException;
import com.nike.backstopper.exception.network.ServerUnreachableException;
import com.nike.backstopper.handler.listener.ApiExceptionHandlerListener;
import com.nike.backstopper.handler.listener.ApiExceptionHandlerListenerResult;
import com.nike.internal.util.Pair;
import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import static com.nike.backstopper.apierror.SortedApiErrorSet.singletonSortedSetOf;

/**
 * Handles most of the {@code com.nike.backstopper.exception.network.*} exceptions which are thrown when
 * something goes wrong during a downstream call to another service. Some are not handled - they are either
 * expected/intended to convert to a generic service error or they can (optionally) be handled by a different
 * {@link ApiExceptionHandlerListener}.
 *
 * @author Nic Munroe
 */
@Named
@Singleton
@SuppressWarnings("WeakerAccess")
public class DownstreamNetworkExceptionHandlerListener implements ApiExceptionHandlerListener {

    protected final ProjectApiErrors projectApiErrors;

    private static final Integer INT_503_BOXED = 503;

    private static final Integer INT_429_BOXED = 429;

    /**
     * @param projectApiErrors The {@link ProjectApiErrors} that should be used by this instance when finding
     *                          {@link ApiError}s. Cannot be null.
     */
    @Inject
    public DownstreamNetworkExceptionHandlerListener(ProjectApiErrors projectApiErrors) {
        if (projectApiErrors == null)
            throw new IllegalArgumentException("ProjectApiErrors cannot be null");
        this.projectApiErrors = projectApiErrors;
    }

    @Override
    public ApiExceptionHandlerListenerResult shouldHandleException(Throwable ex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return Helper method for processing the given {@link ServerHttpStatusCodeException} by adding relevant log pairs
     *          to extraDetailsForLogging and returning the appropriate {@link SortedApiErrorSet}.
     */
    protected SortedApiErrorSet processServerHttpStatusCodeException(ServerHttpStatusCodeException ex, List<Pair<String, String>> extraDetailsForLogging) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return true if the given exception should propagate a 429 error to the original caller, false otherwise.
     *          This method will not be called unless the given exception is a 429.
     */
    @SuppressWarnings("unused")
    protected boolean shouldPropagate429Error(ServerHttpStatusCodeException ex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return true if we should log the raw response from the given exception, false otherwise.
     */
    @SuppressWarnings("unused")
    protected boolean shouldLogRawResponse(ServerHttpStatusCodeException ex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return Helper method for processing the given ServerUnknownHttpStatusCodeException by adding relevant log pairs
     *          to extraDetailsForLogging and returning the appropriate {@link SortedApiErrorSet}.
     */
    protected SortedApiErrorSet processServerUnknownHttpStatusCodeException(ServerUnknownHttpStatusCodeException ex, List<Pair<String, String>> extraDetailsForLogging) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return true if the given exception should be treated as a
     *          {@link ProjectApiErrors#getTemporaryServiceProblemApiError()}, false otherwise. This method may also
     *          add any relevant log data pairs to extraDetailsForLogging if it returns true.
     */
    protected boolean isTemporaryProblem(Throwable ex, @SuppressWarnings("unused") List<Pair<String, String>> extraDetailsForLogging) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

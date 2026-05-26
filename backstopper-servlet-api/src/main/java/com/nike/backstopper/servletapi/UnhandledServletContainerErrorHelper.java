package com.nike.backstopper.servletapi;

import com.nike.backstopper.apierror.projectspecificinfo.ProjectApiErrors;
import com.nike.backstopper.exception.ApiException;
import com.nike.backstopper.exception.WrapperException;
import com.nike.internal.util.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import jakarta.servlet.ServletRequest;

/**
 * This class is intended to help with integrating Backstopper with Servlet containers for handling otherwise-unhandled
 * errors that occur outside of a stack, but instead originate in the servlet container itself. The recommended way to
 * use this class is:
 *
 * <ol>
 *     <li>
 *         Configure your servlet container to map all Throwables and other error conditions (e.g. 404) that *it* (the
 *         servlet container) handles to a page like /error that your Backstopper-enabled stack is listening on.
 *     </li>
 *     <li>
 *         When the servlet container catches one of those errors and forwards it to your catch-all /error page,
 *         you should then call {@link #extractOrGenerateErrorForRequest(ServletRequest, ProjectApiErrors)} to
 *         extract or generate the Throwable for Backstopper to handle.
 *     </li>
 *     <li>
 *         Since you're now in the context of your Backstopper-enabled stack, you can throw whatever is returned by
 *         {@link #extractOrGenerateErrorForRequest(ServletRequest, ProjectApiErrors)} and Backstopper will handle
 *         it appropriately.
 *     </li>
 * </ol>
 *
 * @author Nic Munroe
 */
@Named
@Singleton
@SuppressWarnings("WeakerAccess")
public class UnhandledServletContainerErrorHelper {

    protected static final List<String> DEFAULT_THROWABLE_REQUEST_ATTR_NAMES = Arrays.asList(// Try the Springboot 3 attrs first.
    //      Corresponds to org.springframework.boot.web.reactive.error.DefaultErrorAttributes.ERROR_ATTRIBUTE.
    "org.springframework.boot.web.reactive.error.DefaultErrorAttributes.ERROR", //      Corresponds to org.springframework.boot.web.servlet.error.DefaultErrorAttributes.ERROR_ATTRIBUTE.
    "org.springframework.boot.web.servlet.error.DefaultErrorAttributes.ERROR", // Fall back to the Servlet API value last.
    //      Corresponds to jakarta.servlet.RequestDispatcher.ERROR_EXCEPTION.
    "jakarta.servlet.error.exception");

    protected static final List<String> DEFAULT_ERROR_STATUS_CODE_REQUEST_ATTR_NAMES = Collections.singletonList(// Servlet API value.
    //      Corresponds to jakarta.servlet.RequestDispatcher.ERROR_STATUS_CODE.
    "jakarta.servlet.error.status_code");

    @NotNull
    public Throwable extractOrGenerateErrorForRequest(ServletRequest request, @NotNull ProjectApiErrors projectApiErrors) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @NotNull
    protected List<String> getThrowableRequestAttrNames() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nullable
    protected Throwable extractErrorThrowable(@NotNull ServletRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @NotNull
    protected List<String> getErrorStatusCodeRequestAttrNames() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nullable
    protected Integer extractErrorStatusCode(@NotNull ServletRequest request) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nullable
    protected Integer extractRequestAttrAsInteger(@NotNull ServletRequest request, @NotNull String attrName) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package com.nike.backstopper.handler.spring.listener.impl;

import com.nike.backstopper.apierror.ApiError;
import com.nike.backstopper.apierror.ApiErrorWithMetadata;
import com.nike.backstopper.apierror.projectspecificinfo.ProjectApiErrors;
import com.nike.backstopper.handler.ApiExceptionHandlerUtils;
import com.nike.backstopper.handler.listener.ApiExceptionHandlerListenerResult;
import com.nike.internal.util.Pair;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import java.util.ArrayList;
import java.util.List;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

/**
 * An extension and concrete implementation of {@link OneOffSpringCommonFrameworkExceptionHandlerListener} that
 * knows how to handle Spring WebMVC specific exceptions.
 *
 * @author Nic Munroe
 */
@Named
@Singleton
@SuppressWarnings("WeakerAccess")
public class OneOffSpringWebMvcFrameworkExceptionHandlerListener extends OneOffSpringCommonFrameworkExceptionHandlerListener {

    /**
     * @param projectApiErrors The {@link ProjectApiErrors} that should be used by this instance when finding {@link
     * ApiError}s. Cannot be null.
     * @param utils The {@link ApiExceptionHandlerUtils} that should be used by this instance. You can pass in
     * {@link ApiExceptionHandlerUtils#DEFAULT_IMPL} if you don't need custom logic.
     */
    @Inject
    public OneOffSpringWebMvcFrameworkExceptionHandlerListener(ProjectApiErrors projectApiErrors, ApiExceptionHandlerUtils utils) {
        super(projectApiErrors, utils);
    }

    @Override
    @NotNull
    protected ApiExceptionHandlerListenerResult handleSpringMvcOrWebfluxSpecificFrameworkExceptions(@NotNull Throwable ex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected ApiExceptionHandlerListenerResult handleServletRequestBindingException(ServletRequestBindingException ex, List<Pair<String, String>> extraDetailsForLogging) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

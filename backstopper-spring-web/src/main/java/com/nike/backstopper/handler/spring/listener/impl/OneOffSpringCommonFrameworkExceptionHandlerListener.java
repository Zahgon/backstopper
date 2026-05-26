package com.nike.backstopper.handler.spring.listener.impl;

import com.nike.backstopper.apierror.ApiError;
import com.nike.backstopper.apierror.ApiErrorBase;
import com.nike.backstopper.apierror.ApiErrorWithMetadata;
import com.nike.backstopper.apierror.projectspecificinfo.ProjectApiErrors;
import com.nike.backstopper.handler.ApiExceptionHandlerUtils;
import com.nike.backstopper.handler.listener.ApiExceptionHandlerListener;
import com.nike.backstopper.handler.listener.ApiExceptionHandlerListenerResult;
import com.nike.internal.util.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.core.MethodParameter;
import org.springframework.core.codec.DecodingException;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.method.annotation.MethodArgumentConversionNotSupportedException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.server.MethodNotAllowedException;
import org.springframework.web.server.MissingRequestValueException;
import org.springframework.web.server.NotAcceptableStatusException;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerErrorException;
import org.springframework.web.server.ServerWebInputException;
import org.springframework.web.server.UnsupportedMediaTypeStatusException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import static com.nike.backstopper.apierror.SortedApiErrorSet.singletonSortedSetOf;
import static java.util.Collections.singleton;

/**
 * Handles the one-off spring framework exceptions common to any spring environment (e.g. WebMVC and WebFlux) that
 * don't fall into any other {@link ApiExceptionHandlerListener}'s domain.
 *
 * <p>The exceptions handled here are primarily ones that are found in the spring-web dependency as that's common to
 * both WebMVC and WebFlux apps, however this also contains support for Spring Security exceptions via simply checking
 * classnames, and a few spring-webmvc exceptions that we can also handle by checking classname (so we don't need the
 * spring-security or spring-webmvc dependencies in this backstopper-spring-web module). Also note that a few
 * exceptions in spring-web extend from Servlet API exceptions. Those are not handled here since we don't want a
 * servlet-api dependency included. Instead they are handled by the backstopper-spring-web-mvc's
 * {@code OneOffSpringWebMvcFrameworkExceptionHandlerListener} class.
 *
 * <p>NOTE: This class is abstract - concrete implementations must implement
 * {@link #handleSpringMvcOrWebfluxSpecificFrameworkExceptions(Throwable)} to handle the Spring WebMVC or WebFlux
 * exceptions relevant to the specific Spring environment flavor they're covering.
 *
 * @author Nic Munroe
 */
@SuppressWarnings("WeakerAccess")
public abstract class OneOffSpringCommonFrameworkExceptionHandlerListener implements ApiExceptionHandlerListener {

    protected final ProjectApiErrors projectApiErrors;

    protected final ApiExceptionHandlerUtils utils;

    // Support all the various 404 cases from competing dependencies using classname matching.
    protected final Set<String> DEFAULT_TO_404_CLASSNAMES = new LinkedHashSet<>(Arrays.asList(// NoHandlerFoundException is found in the spring-webmvc dependency, not spring-web.
    "org.springframework.web.servlet.resource.NoResourceFoundException", "org.springframework.web.servlet.NoHandlerFoundException"));

    // Support Spring Security exceptions that should map to a 403.
    protected final Set<String> DEFAULT_TO_403_CLASSNAMES = singleton("org.springframework.security.access.AccessDeniedException");

    // Support Spring Security exceptions that should map to a 401.
    protected final Set<String> DEFAULT_TO_401_CLASSNAMES = new LinkedHashSet<>(Arrays.asList("org.springframework.security.authentication.BadCredentialsException", "org.springframework.security.authentication.InsufficientAuthenticationException", "org.springframework.security.authentication.AuthenticationCredentialsNotFoundException", "org.springframework.security.authentication.LockedException", "org.springframework.security.authentication.DisabledException", "org.springframework.security.authentication.CredentialsExpiredException", "org.springframework.security.authentication.AccountExpiredException", "org.springframework.security.core.userdetails.UsernameNotFoundException"));

    // Support 503 cases from competing dependencies using classname matching.
    protected final Set<String> DEFAULT_TO_503_CLASSNAMES = Collections.emptySet();

    /**
     * @param projectApiErrors The {@link ProjectApiErrors} that should be used by this instance when finding {@link
     *                         ApiError}s. Cannot be null.
     * @param utils            The {@link ApiExceptionHandlerUtils} that should be used by this instance. You can pass
     *                         in {@link ApiExceptionHandlerUtils#DEFAULT_IMPL} if you don't need custom logic.
     */
    public OneOffSpringCommonFrameworkExceptionHandlerListener(ProjectApiErrors projectApiErrors, ApiExceptionHandlerUtils utils) {
        if (projectApiErrors == null) {
            throw new IllegalArgumentException("ProjectApiErrors cannot be null");
        }
        if (utils == null) {
            throw new IllegalArgumentException("ApiExceptionHandlerUtils cannot be null.");
        }
        this.projectApiErrors = projectApiErrors;
        this.utils = utils;
    }

    @NotNull
    protected abstract ApiExceptionHandlerListenerResult handleSpringMvcOrWebfluxSpecificFrameworkExceptions(@NotNull Throwable ex);

    // NOTE: If you're comparing the exception handling done in this method with Spring's
    //      DefaultHandlerExceptionResolver and/or ResponseEntityExceptionHandler to verify completeness, keep in
    //      mind that MethodArgumentNotValidException and BindException are handled by
    //      ConventionBasedSpringValidationErrorToApiErrorHandlerListener - they should not be handled here.
    @Override
    public ApiExceptionHandlerListenerResult shouldHandleException(Throwable ex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected ApiExceptionHandlerListenerResult handleError(ApiError error, List<Pair<String, String>> extraDetailsForLogging) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected ApiExceptionHandlerListenerResult handleHttpMessageConversionException(HttpMessageConversionException ex, List<Pair<String, String>> extraDetailsForLogging) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean isMissingExpectedContentCase(HttpMessageConversionException ex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean nullSafeStringContains(String strToCheck, String snippet) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected ApiExceptionHandlerListenerResult handleTypeMismatchException(TypeMismatchException ex, List<Pair<String, String>> extraDetailsForLogging, boolean addBaseExceptionMessageToLoggingDetails, @Nullable List<Pair<String, String>> extraMetadata) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String extractPropertyName(TypeMismatchException tme) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected String extractRequiredTypeNoInfoLeak(Class<?> type) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean isRequiredTypeAssignableToOneOf(Class<?> desiredClass, Class<?>... allowedClasses) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean isA404NotFoundExceptionClassname(String exClassname) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean isA403ForibddenExceptionClassname(String exClassname) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean isA401UnauthorizedExceptionClassname(String exClassname) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean isA503TemporaryProblemExceptionClassname(String exClassname) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @NotNull
    protected ApiExceptionHandlerListenerResult handleResponseStatusException(@NotNull ResponseStatusException ex) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nullable
    protected List<Pair<String, String>> extractExtraMetadataForHeaderOrQueryParamException(Exception maybeMethodParamEx) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected void addExtraDetailsForLoggingForResponseStatusException(@NotNull ResponseStatusException ex, @NotNull List<Pair<String, String>> extraDetailsForLogging) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @NotNull
    protected String concatenateCollectionToString(@Nullable Collection<?> collection) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @NotNull
    protected ApiError determineApiErrorToUseForGenericResponseStatusCode(int statusCode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @NotNull
    protected ApiError generateGenericApiErrorForResponseStatusCode(int statusCode) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Nullable
    protected RequiredParamData parseExReasonForMissingRequiredParam(@NotNull ResponseStatusException ex, @NotNull String[] exReasonWords, @NotNull String exReason) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected record RequiredParamData(String paramName, String paramType, List<Pair<String, String>> extraMetadata) {

        public Map<String, Object> getAsApiErrorMetadata() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

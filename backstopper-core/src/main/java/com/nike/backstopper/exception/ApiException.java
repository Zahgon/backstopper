package com.nike.backstopper.exception;

import com.nike.backstopper.apierror.ApiError;
import com.nike.internal.util.Pair;
import com.nike.internal.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import static java.util.Collections.singletonList;

/**
 * Generic API RuntimeException to explicitly invoke the error handling system. Most of the time you'll want to create
 * an instance using the {@link ApiException.Builder}, e.g.
 * {@code
 * ApiException.newBuilder().withApiErrors(SOME_ERROR, OTHER_ERROR).withExceptionMessage("super useful message").build()}.
 * The builder has many options that directly affect the response and what is logged, so take a close look at the
 * available methods.
 *
 * @author Nic Munroe
 */
public class ApiException extends RuntimeException {

    /**
     * The {@link ApiError}s associated with this instance. Will never be null or empty.
     */
    private final List<ApiError> apiErrors;

    /**
     * Any extra details you want logged when this error is handled. Will never be null, but might be empty.
     * NOTE: This will always be a mutable list so it can be modified at any time.
     */
    private final List<Pair<String, String>> extraDetailsForLogging;

    /**
     * Any extra headers you want sent to the caller when this error is handled. Will never be null, but might be empty.
     * NOTE: This will always be a mutable list so it can be modified at any time.
     */
    private final List<Pair<String, List<String>>> extraResponseHeaders;

    /**
     * Allows users to override the default behavior (logging stack traces for 5xx errors but not 4xx errors) and
     * instead force stack trace on/off if they want to override the default 4xx vs. 5xx decision behavior.
     */
    private final StackTraceLoggingBehavior stackTraceLoggingBehavior;

    /**
     * Handles the simple common case where you just want to throw a single {@link ApiError} and nothing else.
     */
    public ApiException(ApiError error) {
        super(extractMessage(error));
        if (error == null)
            throw new IllegalArgumentException("error cannot be null");
        this.apiErrors = new ArrayList<>(singletonList(error));
        this.extraDetailsForLogging = new ArrayList<>();
        this.extraResponseHeaders = new ArrayList<>();
        this.stackTraceLoggingBehavior = StackTraceLoggingBehavior.DEFER_TO_DEFAULT_BEHAVIOR;
    }

    /**
     * Initializes this instance based on the values from the given {@link Builder}.
     *
     * @param builder The {@link Builder} to use for initializing this instance's fields.
     */
    public ApiException(Builder builder) {
        super(extractMessage(builder.apiErrors, builder.message));
        if (builder.cause != null) {
            this.initCause(builder.cause);
        }
        if (builder.apiErrors.isEmpty()) {
            throw new IllegalArgumentException("The Builder's apiErrors cannot be empty");
        }
        this.apiErrors = new ArrayList<>(builder.apiErrors);
        this.extraDetailsForLogging = new ArrayList<>(builder.extraDetailsForLogging);
        this.extraResponseHeaders = new ArrayList<>(builder.extraResponseHeaders);
        this.stackTraceLoggingBehavior = (builder.stackTraceLoggingBehavior == null) ? StackTraceLoggingBehavior.DEFER_TO_DEFAULT_BEHAVIOR : builder.stackTraceLoggingBehavior;
    }

    /**
     * Creates an instance on top of {@link Exception#Exception(String)} super constructor. You can safely pass in null
     * for message if you have no message. If another exception caused this to be thrown then you'll want
     * {@link #ApiException(List, List, String, Throwable)} instead so that the proper super constructor is used.
     *
     * <p>NOTE: Most of the time you wouldn't want to use this constructor directly - use the
     * {@link ApiException.Builder} instead.
     *
     * @deprecated Use the {@link Builder} (or the {@link ApiException#ApiException(Builder) constructor} that takes a
     * builder) instead.
     */
    @Deprecated
    public ApiException(List<ApiError> apiErrors, List<Pair<String, String>> extraDetailsForLogging, String message) {
        this(apiErrors, extraDetailsForLogging, null, message);
    }

    /**
     * Creates an instance on top of {@link Exception#Exception(String)} super constructor. You can safely pass in null
     * for message if you have no message. If another exception caused this to be thrown then you'll want
     * {@link #ApiException(List, List, List, String, Throwable)} instead so that the proper super constructor is used.
     *
     * <p>NOTE: Most of the time you wouldn't want to use this constructor directly - use the
     * {@link ApiException.Builder} instead.
     *
     * @deprecated Use the {@link Builder} (or the {@link ApiException#ApiException(Builder) constructor} that takes a
     * builder) instead.
     */
    @Deprecated
    public ApiException(List<ApiError> apiErrors, List<Pair<String, String>> extraDetailsForLogging, List<Pair<String, List<String>>> extraResponseHeaders, String message) {
        super(extractMessage(apiErrors, message));
        if (apiErrors == null || apiErrors.isEmpty())
            throw new IllegalArgumentException("apiErrors cannot be null or empty");
        if (extraDetailsForLogging == null)
            extraDetailsForLogging = Collections.emptyList();
        if (extraResponseHeaders == null)
            extraResponseHeaders = Collections.emptyList();
        this.apiErrors = new ArrayList<>(apiErrors);
        this.extraDetailsForLogging = new ArrayList<>(extraDetailsForLogging);
        this.extraResponseHeaders = new ArrayList<>(extraResponseHeaders);
        this.stackTraceLoggingBehavior = StackTraceLoggingBehavior.DEFER_TO_DEFAULT_BEHAVIOR;
    }

    /**
     * Creates an instance on top of {@link Exception#Exception(String, Throwable)} super constructor. You can safely
     * pass in null for message if you have no message. If another exception did *not* cause this to be thrown then
     * you'll want {@link #ApiException(List, List, String)} instead so that the proper super constructor is used.
     *
     * <p>NOTE: Most of the time you wouldn't want to use this constructor directly - use the
     * {@link ApiException.Builder} instead.
     *
     * @deprecated Use the {@link Builder} (or the {@link ApiException#ApiException(Builder) constructor} that takes a
     * builder) instead.
     */
    @Deprecated
    public ApiException(List<ApiError> apiErrors, List<Pair<String, String>> extraDetailsForLogging, String message, Throwable cause) {
        this(apiErrors, extraDetailsForLogging, null, message, cause);
    }

    /**
     * Creates an instance on top of {@link Exception#Exception(String, Throwable)} super constructor. You can safely
     * pass in null for message if you have no message. If another exception did *not* cause this to be thrown then
     * you'll want {@link #ApiException(List, List, List, String)} instead so that the proper super constructor is used.
     *
     * <p>NOTE: Most of the time you wouldn't want to use this constructor directly - use the
     * {@link ApiException.Builder} instead.
     *
     * @deprecated Use the {@link Builder} (or the {@link ApiException#ApiException(Builder) constructor} that takes a
     * builder) instead.
     */
    @Deprecated
    public ApiException(List<ApiError> apiErrors, List<Pair<String, String>> extraDetailsForLogging, List<Pair<String, List<String>>> extraResponseHeaders, String message, Throwable cause) {
        super(extractMessage(apiErrors, message), cause);
        if (apiErrors == null || apiErrors.isEmpty())
            throw new IllegalArgumentException("apiErrors cannot be null or empty");
        if (extraDetailsForLogging == null)
            extraDetailsForLogging = Collections.emptyList();
        if (extraResponseHeaders == null)
            extraResponseHeaders = Collections.emptyList();
        this.apiErrors = new ArrayList<>(apiErrors);
        this.extraDetailsForLogging = new ArrayList<>(extraDetailsForLogging);
        this.extraResponseHeaders = new ArrayList<>(extraResponseHeaders);
        this.stackTraceLoggingBehavior = StackTraceLoggingBehavior.DEFER_TO_DEFAULT_BEHAVIOR;
    }

    /**
     * Shortcut for calling {@link ApiException.Builder#newBuilder()} directly.
     */
    public static Builder newBuilder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * The {@link ApiError}s associated with this instance. Will never be null or empty.
     */
    public List<ApiError> getApiErrors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Any extra details you want logged when this error is handled. Will never be null, but might be empty.
     */
    public List<Pair<String, String>> getExtraDetailsForLogging() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Any extra headers you want sent to the caller when this error is handled. Will never be null, but might be empty.
     */
    public List<Pair<String, List<String>>> getExtraResponseHeaders() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Extracts message from input {@link ApiError}. Will return null if the input error is null
     */
    protected static String extractMessage(ApiError error) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Extracts and joins all messages from the input List&lt;{@link ApiError}> if the desired message is null.
     * <p>
     * Will return null if the input error List is null
     */
    protected static String extractMessage(List<ApiError> apiErrors, String desiredMessage) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return The desired stack trace logging behavior for this error. Will never be null.
     * See {@link StackTraceLoggingBehavior} for details on the options.
     */
    public StackTraceLoggingBehavior getStackTraceLoggingBehavior() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Builder for {@link ApiException}.
     */
    @SuppressWarnings("WeakerAccess")
    public static class Builder {

        private final List<ApiError> apiErrors = new ArrayList<>();

        private final List<Pair<String, String>> extraDetailsForLogging = new ArrayList<>();

        private final List<Pair<String, List<String>>> extraResponseHeaders = new ArrayList<>();

        private String message;

        private Throwable cause;

        private StackTraceLoggingBehavior stackTraceLoggingBehavior;

        public Builder() {
        }

        public static Builder newBuilder() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Adds the given errors to what will ultimately become {@link ApiException#apiErrors}.
         */
        public Builder withApiErrors(Collection<ApiError> apiErrors) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Adds the given errors to what will ultimately become {@link ApiException#apiErrors}.
         */
        public Builder withApiErrors(ApiError... apiErrors) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Adds the given logging details to what will ultimately become {@link ApiException#extraDetailsForLogging}.
         */
        public Builder withExtraDetailsForLogging(Collection<Pair<String, String>> extraDetailsForLogging) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Adds the given logging details to what will ultimately become {@link ApiException#extraDetailsForLogging}.
         */
        @SafeVarargs
        public final Builder withExtraDetailsForLogging(Pair<String, String>... extraDetailsForLogging) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Adds the given response headers to what will ultimately become {@link ApiException#extraResponseHeaders}.
         */
        public Builder withExtraResponseHeaders(Collection<Pair<String, List<String>>> extraResponseHeaders) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Adds the given response headers to what will ultimately become {@link ApiException#extraResponseHeaders}.
         */
        @SafeVarargs
        public final Builder withExtraResponseHeaders(Pair<String, List<String>>... extraResponseHeaders) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * The given message will be used as part of the {@link Exception#Exception(String)} or
         * {@link Exception#Exception(String, Throwable)} super constructor. Could be used as context for what went
         * wrong if the API Errors aren't self explanatory.
         */
        public Builder withExceptionMessage(String message) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * The given throwable will be applied to the {@link Exception#Exception(String, Throwable)} super constructor.
         * If another error caused this {@link ApiException} in the first place then you should definitely include it
         * here so it can be logged and help with debugging the issue.
         */
        public Builder withExceptionCause(Throwable cause) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Sets the given {@link StackTraceLoggingBehavior} for what will ultimately become
         * {@link ApiException#stackTraceLoggingBehavior}.
         */
        public Builder withStackTraceLoggingBehavior(StackTraceLoggingBehavior stackTraceLoggingBehavior) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        /**
         * Creates the {@link ApiException} from the data this builder contains.
         */
        public ApiException build() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}

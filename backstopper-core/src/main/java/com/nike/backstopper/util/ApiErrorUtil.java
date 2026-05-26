package com.nike.backstopper.util;

import com.nike.backstopper.apierror.ApiError;
import java.util.Objects;

/**
 * Utility class to enable sharing code between {@link ApiError} implementations. Most Backstopper end-users
 * won't need to use this class unless you're creating custom {@link ApiError} implementations (which is not
 * common).
 */
public class ApiErrorUtil {

    private ApiErrorUtil() {
        // Do nothing.
    }

    /**
     * Method for generating a hashcode for the given {@link ApiError} . This can be used in implementations of
     * {@link ApiError}.
     */
    public static int generateApiErrorHashCode(ApiError apiError) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * Method for checking equality of two {@link ApiError}. This can be used in implementations of {@link ApiError}
     */
    public static boolean isApiErrorEqual(ApiError apiError, Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

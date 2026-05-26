package com.nike.backstopper.apierror;

import com.nike.backstopper.util.ApiErrorUtil;
import java.util.Comparator;
import static com.nike.backstopper.util.ApiErrorUtil.generateApiErrorHashCode;
import static com.nike.backstopper.util.ApiErrorUtil.isApiErrorEqual;

/**
 * A comparator that knows how to compare {@link ApiError} instances by {@link ApiError#getName()} first,
 * then by {@link ApiError#getErrorCode()}, and finally by everything else by comparing hashcodes using
 * {@link ApiErrorUtil#generateApiErrorHashCode(ApiError)}.
 * <p>
 * <p>Note that this means two {@link ApiError}s that are identical other than metadata will be considered
 * different by this comparator.
 *
 * @author Nic Munroe
 */
@SuppressWarnings("WeakerAccess")
public class ApiErrorComparator implements Comparator<ApiError> {

    @Override
    public int compare(ApiError o1, ApiError o2) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package com.nike.backstopper.apierror.sample;

import com.nike.backstopper.apierror.ApiError;
import com.nike.backstopper.apierror.projectspecificinfo.ProjectApiErrors;
import java.util.Arrays;
import java.util.List;

/**
 * A sample/example {@link ProjectApiErrors} that uses {@link SampleCoreApiError} values for
 * {@link #getCoreApiErrors()} and the various {@code get[Special]ApiError()} methods. The only things concrete
 * extensions will need to implement is {@link #getProjectSpecificApiErrors()} and
 * {@link #getProjectSpecificErrorCodeRange()}.
 *
 * <p>This is only suitable for production usage if the error codes and messages associated with the
 * {@link SampleCoreApiError} values are fine for your project. In practice most organizations should copy/paste
 * {@link SampleCoreApiError} and customize the error codes and messages for their organization, and then copy/paste
 * this base class to use their organization's new set of core errors. If the organization-specific version of
 * {@link ProjectApiErrors} is published in a reusable library then it can be shared around to all projects that should
 * use the same values for their core errors and all they will have to do is implement
 * {@link #getProjectSpecificApiErrors()} and {@link #getProjectSpecificErrorCodeRange()}.
 *
 * @author Nic Munroe
 */
@SuppressWarnings("WeakerAccess")
public abstract class SampleProjectApiErrorsBase extends ProjectApiErrors {

    private static final List<ApiError> SAMPLE_CORE_API_ERRORS_AS_LIST = Arrays.asList(SampleCoreApiError.values());

    @Override
    protected List<ApiError> getCoreApiErrors() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ApiError getGenericServiceError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ApiError getOusideDependencyReturnedAnUnrecoverableErrorApiError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ApiError getServersideValidationApiError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ApiError getTemporaryServiceProblemApiError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ApiError getOutsideDependencyReturnedTemporaryErrorApiError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ApiError getGenericBadRequestApiError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ApiError getMissingExpectedContentApiError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ApiError getTypeConversionApiError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ApiError getMalformedRequestApiError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ApiError getUnauthorizedApiError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ApiError getForbiddenApiError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ApiError getNotFoundApiError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ApiError getMethodNotAllowedApiError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ApiError getNoAcceptableRepresentationApiError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ApiError getUnsupportedMediaTypeApiError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public ApiError getTooManyRequestsApiError() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

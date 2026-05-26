package com.nike.backstopper.validation.constraints.impl;

import com.nike.backstopper.validation.constraints.StringConvertsToClassType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Implementation of the validation logic for {@link StringConvertsToClassType}. See that annotation's javadocs for more
 * info.
 *
 * @author Nic Munroe
 */
@SuppressWarnings({ "WeakerAccess", "ResultOfMethodCallIgnored" })
public class StringConvertsToClassTypeValidator implements ConstraintValidator<StringConvertsToClassType, String> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private Class<?> desiredClass;

    private boolean allowCaseInsensitiveEnumMatch;

    @Override
    public void initialize(StringConvertsToClassType constraintAnnotation) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean isDesiredClassAssignableToOneOf(Class<?>... allowedClasses) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("unchecked")
    protected boolean validateAsEnum(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean validateAsByte(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean validateAsShort(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean validateAsInt(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean validateAsLong(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean validateAsFloat(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean validateAsDouble(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected boolean validateAsBoolean(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    protected boolean validateAsChar(String value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package com.nike.backstopper.apierror.projectspecificinfo.range;

/**
 * Helper class useful for implementing the concept of an integer range for
 * {@link com.nike.backstopper.apierror.projectspecificinfo.ProjectSpecificErrorCodeRange}.
 *
 * @author Nic Munroe
 */
@SuppressWarnings("WeakerAccess")
public class IntegerRange {

    /**
     * The lower bound for this range (inclusive).
     */
    public final int lowerRangeInclusive;

    /**
     * The upper bound for this range (inclusive).
     */
    public final int upperRangeInclusive;

    @SuppressWarnings("WeakerAccess")
    protected IntegerRange(int lowerRangeInclusive, int upperRangeInclusive) {
        if (upperRangeInclusive < lowerRangeInclusive) {
            throw new IllegalArgumentException("upper range value (" + upperRangeInclusive + ") cannot be less than lower range value (" + lowerRangeInclusive + ")");
        }
        this.lowerRangeInclusive = lowerRangeInclusive;
        this.upperRangeInclusive = upperRangeInclusive;
    }

    /**
     * @param lowerRangeInclusive The lower bound of this range (inclusive).
     * @param upperRangeInclusive The upper bound of this range (inclusive).
     * @return A new instance with the given bounds.
     */
    public static IntegerRange of(int lowerRangeInclusive, int upperRangeInclusive) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return true if the given {@code valueString} can be parsed to an integer and is within the range bounds of this
     * instance, false otherwise.
     */
    public boolean isInRange(String valueString) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return true if the given {@code value} is within the range bounds of this instance, false otherwise.
     */
    public boolean isInRange(int value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

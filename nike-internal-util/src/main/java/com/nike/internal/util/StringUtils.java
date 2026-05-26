package com.nike.internal.util;

import java.util.Collection;

/**
 * What project is complete without a StringUtils? This is essentially here so that we don't have to pull in the entire
 * Apache Commons Lang dependency for a few utils and so that we have a dumping ground for the inevitable custom string
 * utility methods.
 *
 * @author Nic Munroe
 */
@SuppressWarnings("WeakerAccess")
public class StringUtils {

    /**
     * Intentionally private - use the static methods.
     */
    private StringUtils() {
        // do nothing
    }

    /**
     * @return A string that contains the items in the given collection with the given delimiter between values. The
     *          delimiter will not appear as a prefix to the returned string or as a suffix, it is only used in between
     *          two items. The items in the list are turned into strings via {@link String#valueOf(Object)}. This is
     *          simply a helper for calling {@link #join(Collection, String, String, String)}, passing in null for
     *          prefix and suffix.
     *          <p>NOTE: An {@link IllegalArgumentException} will be thrown if you pass in null for the collection of
     *          items or the delimiter.
     */
    public static String join(Collection<?> iterable, String delimiter) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return A string that contains the items in the given collection with the given delimiter between values, the
     *          given prefix before any of the items, and the given suffix after all the items. The delimiter will not
     *          appear as a prefix to the returned string or as a suffix, it is only used in between two items. The
     *          items in the list are turned into strings via {@link String#valueOf(Object)}. You can safely pass in
     *          null for the prefix and/or suffix and they will be turned into the empty string, effectively removing
     *          them from the returned string.
     *          <p>NOTE: An {@link IllegalArgumentException} will be thrown if you pass in null for the collection of
     *          items or the delimiter.
     */
    public static String join(Collection<?> iterable, String delimiter, String prefix, String suffix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // isEmpty, isNotEmpty, isBlank, and isNotBlank are copied directly from Apache Commons Lang3 (version 3.4),
    //      including javadocs. See the license notification in NOTICE.txt at the root of this project for license info.
    /**
     * <p>Checks if a CharSequence is empty ("") or null.</p>
     *
     * <pre>
     * StringUtils.isEmpty(null)      = true
     * StringUtils.isEmpty("")        = true
     * StringUtils.isEmpty(" ")       = false
     * StringUtils.isEmpty("bob")     = false
     * StringUtils.isEmpty("  bob  ") = false
     * </pre>
     *
     * <p>NOTE: This method changed in Lang version 2.0.
     * It no longer trims the CharSequence.
     * That functionality is available in isBlank().</p>
     *
     * @param cs  the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is empty or null
     * @since 3.0 Changed signature from isEmpty(String) to isEmpty(CharSequence)
     */
    public static boolean isEmpty(final CharSequence cs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>Checks if a CharSequence is not empty ("") and not null.</p>
     *
     * <pre>
     * StringUtils.isNotEmpty(null)      = false
     * StringUtils.isNotEmpty("")        = false
     * StringUtils.isNotEmpty(" ")       = true
     * StringUtils.isNotEmpty("bob")     = true
     * StringUtils.isNotEmpty("  bob  ") = true
     * </pre>
     *
     * @param cs  the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is not empty and not null
     * @since 3.0 Changed signature from isNotEmpty(String) to isNotEmpty(CharSequence)
     */
    public static boolean isNotEmpty(final CharSequence cs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>Checks if a CharSequence is whitespace, empty ("") or null.</p>
     *
     * <pre>
     * StringUtils.isBlank(null)      = true
     * StringUtils.isBlank("")        = true
     * StringUtils.isBlank(" ")       = true
     * StringUtils.isBlank("bob")     = false
     * StringUtils.isBlank("  bob  ") = false
     * </pre>
     *
     * @param cs  the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is null, empty or whitespace
     * @since 2.0
     * @since 3.0 Changed signature from isBlank(String) to isBlank(CharSequence)
     */
    public static boolean isBlank(final CharSequence cs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * <p>Checks if a CharSequence is not empty (""), not null and not whitespace only.</p>
     *
     * <pre>
     * StringUtils.isNotBlank(null)      = false
     * StringUtils.isNotBlank("")        = false
     * StringUtils.isNotBlank(" ")       = false
     * StringUtils.isNotBlank("bob")     = true
     * StringUtils.isNotBlank("  bob  ") = true
     * </pre>
     *
     * @param cs  the CharSequence to check, may be null
     * @return {@code true} if the CharSequence is
     *  not empty and not null and not whitespace
     * @since 2.0
     * @since 3.0 Changed signature from isNotBlank(String) to isNotBlank(CharSequence)
     */
    public static boolean isNotBlank(final CharSequence cs) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

package com.nike.internal.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple fluent map builder that allows you to easily initialize static map fields with hardcoded data. We could use
 * the Guava library's ImmutableMap, but there's no reason to require pulling in all of Guava just for this one simple
 * thing.
 *
 * @author Nic Munroe
 */
@SuppressWarnings("WeakerAccess")
public class MapBuilder<K, V> {

    private final Map<K, V> map = new HashMap<>();

    private MapBuilder() {
        /* private to enforce builder pattern */
    }

    public static <K, V> MapBuilder<K, V> builder() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static <K, V> MapBuilder<K, V> builder(K firstKey, V firstVal) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public MapBuilder<K, V> put(K key, V value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @SuppressWarnings("UnusedReturnValue")
    public MapBuilder<K, V> putAll(Map<K, V> otherMap) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public Map<K, V> build() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}

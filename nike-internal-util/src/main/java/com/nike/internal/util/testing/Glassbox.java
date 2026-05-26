package com.nike.internal.util.testing;

import java.lang.reflect.Field;

/**
 * A copy of the Mockito 1.x Whitebox class - they dropped this class in Mockito 2.x, but it's very handy.
 * <p>
 * NOTE: This is intended for use during testing, _not_ in production code! In particular there is no caching of
 * {@link Field} - it is extracted every time for the same class. This usually isn't noticeable for tests, but can
 * be much too slow for high volume low latency production purposes.
 */
public class Glassbox {

    public static Object getInternalState(Object target, String field) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static void setInternalState(Object target, String field, Object value) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static Field getFieldFromHierarchy(Class<?> clazz, String field) {
        Field f = getField(clazz, field);
        while (f == null && clazz != Object.class) {
            clazz = clazz.getSuperclass();
            f = getField(clazz, field);
        }
        if (f == null) {
            throw new RuntimeException("You want me to get this field: '" + field + "' on this class: '" + clazz.getSimpleName() + "' but this field is not declared withing hierarchy of this class!");
        }
        return f;
    }

    private static Field getField(Class<?> clazz, String field) {
        try {
            return clazz.getDeclaredField(field);
        } catch (NoSuchFieldException e) {
            return null;
        }
    }
}

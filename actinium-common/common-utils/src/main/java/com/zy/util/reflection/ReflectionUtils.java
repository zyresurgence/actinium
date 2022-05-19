package com.zy.util.reflection;

import java.lang.reflect.Field;

public class ReflectionUtils {
    public static Object getFieldValue(Object object, Field field)
            throws IllegalArgumentException, IllegalAccessException {
        if (object == null) {
            String msg = "\"object\" is null.";
            throw new IllegalArgumentException(msg);
        }

        if (field == null) {
            String msg = "\"field\" is null.";
            throw new IllegalArgumentException(msg);
        }

        field.setAccessible(true);
        return field.get(object);
    }
}

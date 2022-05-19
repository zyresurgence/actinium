package com.zy.util.reflection;

public abstract class CastUtils {

    public CastUtils() {
    }

    public static final <S, D> D cast(S value) {
        return (D)value;
    }
}

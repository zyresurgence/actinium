package com.zy.service;

import java.io.Serializable;

public interface ServiceContext extends Serializable {
    Object getAttribute(String var1);

    <T> T getAttribute(String var1, Class<T> var2);

    Object removeAttribute(String var1);

    void setAttribute(String var1, Object var2);
}
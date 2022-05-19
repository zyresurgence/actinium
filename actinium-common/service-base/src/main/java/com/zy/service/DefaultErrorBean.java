package com.zy.service;

import com.zy.lang.InvalidArgumentException;
import java.io.Serializable;
import org.apache.commons.lang3.StringUtils;

public class DefaultErrorBean implements ErrorBean, Serializable {
    private static final long serialVersionUID = 3750663020812488256L;
    private String code = "";
    private String message = "";

    public DefaultErrorBean() {
    }

    public DefaultErrorBean(String code) {
        code = StringUtils.trimToEmpty(code);
        if (StringUtils.isBlank(code)) {
            String msg = "\"code\" is empty.";
            throw new InvalidArgumentException(msg);
        } else {
            this.message = StringUtils.trimToEmpty(this.message);
            this.code = code;
        }
    }

    public DefaultErrorBean(String code, String message) {
        code = StringUtils.trimToEmpty(code);
        if (StringUtils.isBlank(code)) {
            String msg = "\"code\" is empty.";
            throw new InvalidArgumentException(msg);
        } else {
            message = StringUtils.trimToEmpty(message);
            this.code = code;
            this.message = message;
        }
    }

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return "DefaultErrorBean [code=" + this.code + ", message=" + this.message + "]";
    }
}

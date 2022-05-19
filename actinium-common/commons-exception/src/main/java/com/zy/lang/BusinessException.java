package com.zy.lang;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 8072589743738754440L;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }
}

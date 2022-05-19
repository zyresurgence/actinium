package com.zy.lang;

import org.apache.commons.lang3.StringUtils;

public class InvalidArgumentException extends BusinessException {
    private static final long serialVersionUID = 1588516949236687346L;
    private String argument = "";

    public InvalidArgumentException(String argument) {
        this.argument = StringUtils.trimToEmpty(argument);
    }

    public InvalidArgumentException(String argument, String message) {
        super(message);
        this.argument = StringUtils.trimToEmpty(argument);
    }

    public InvalidArgumentException(String argument, String message, Throwable cause) {
        super(message, cause);
        this.argument = StringUtils.trimToEmpty(argument);
    }

    public InvalidArgumentException(String argument, Throwable cause) {
        super(cause);
        this.argument = StringUtils.trimToEmpty(argument);
    }

    public String getArgument() {
        return this.argument;
    }
}

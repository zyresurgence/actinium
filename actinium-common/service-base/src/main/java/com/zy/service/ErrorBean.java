package com.zy.service;

import java.io.Serializable;

public interface ErrorBean extends Serializable {

    String getCode();

    String getMessage();
}

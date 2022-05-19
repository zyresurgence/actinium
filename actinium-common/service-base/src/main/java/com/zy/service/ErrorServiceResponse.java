package com.zy.service;

public interface ErrorServiceResponse<E extends ErrorBean> extends ServiceResponse {
    E getError();
}

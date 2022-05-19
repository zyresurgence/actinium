package com.zy.service;

public interface SuccessServiceResponse<D> extends ServiceResponse {
    D getData();
}
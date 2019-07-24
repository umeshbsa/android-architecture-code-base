package com.app.architecture.model.base;

public class BaseResponse<T> {

    public int statusCode;
    public T responseData;
    public Errors error;
}

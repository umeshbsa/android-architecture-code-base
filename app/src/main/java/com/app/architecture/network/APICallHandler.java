package com.app.architecture.network;


import com.app.architecture.model.base.Errors;

/**
 * Base api handler
 *
 * @param <T> current model class
 */
public interface APICallHandler<T> {

    // api type and model response
    void onSuccess(APIType apiType, T response);

    void onFailure(APIType apiType, int code, Errors errors);
}

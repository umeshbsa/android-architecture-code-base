package com.app.architecture.network;

/*
  All api code Post, Get, Put, Delete
 */

import com.app.architecture.model.apimodel.output.User;
import com.app.architecture.model.base.BaseResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IApiRequest {


    @FormUrlEncoded
    @POST("api/v1/user/login")
    Call<BaseResponse<User>> emailLoginAPI(@Field("email") String email,
                                        @Field("password") String password
    );
}


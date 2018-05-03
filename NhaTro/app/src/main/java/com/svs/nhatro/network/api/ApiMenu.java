package com.svs.nhatro.network.api;

import com.google.gson.JsonObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by DangQuang on 5/3/18.
 **/

public interface ApiMenu {

    @POST("motel/update-profile")
    Call<JsonObject> postUpdateProfile(@Body Map<String, Object> body);

    @POST("motel/update-roles")
    Call<JsonObject> postUpdateRole(@Body Map<String, Object> body);

    @POST("members/change-password")
    Call<JsonObject> postChangePass(@Body Map<String, Object> body);

    @POST("members/forgot-password")
    Call<JsonObject> postForgotPass(@Body Map<String, Object> body);
}

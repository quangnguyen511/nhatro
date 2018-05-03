package com.svs.nhatro.network.api;

import com.google.gson.JsonObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by DangQuang on 11/14/17.
 **/

public interface ApiAuth {
    @POST("members/postLogin")
    Call<JsonObject> postLogin(@Body Map<String, Object> body);

    @POST("members/postSignup")
    Call<JsonObject> postSignup(@Body Map<String, Object> body);

    @POST("motel/send-mail-again")
    Call<JsonObject> postSendMailAgain(@Body Map<String, Object> body);

    @GET("members/getLogout")
    Call<JsonObject> getLogOut(@Header("Authorization") String authorization);
}

package com.svs.nhatro.network.api;

import com.google.gson.JsonObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by DangQuang on 5/3/18.
 **/

public interface ApiPost {

    @POST("motel/post-news")
    Call<JsonObject> postNews(@Body Map<String, Object> body);

    @POST("motel/filter-motel")
    Call<JsonObject> postFilterHostel(@Body Map<String, Object> body);

    @POST("motel/delete-news-of-user")
    Call<JsonObject> postDeleteNews(@Body Map<String, Object> body);

    @GET("motel/get-news")
    Call<JsonObject> getNews(@Header("Authorization") String authorization);
}

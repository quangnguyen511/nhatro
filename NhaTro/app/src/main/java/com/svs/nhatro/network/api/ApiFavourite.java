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

public interface ApiFavourite {

    @POST("motel/like-news")
    Call<JsonObject> postLikeNews(@Body Map<String, Object> body);

    @POST("motel/unlike-news-by-user")
    Call<JsonObject> postUnlikeNews(@Body Map<String, Object> body);

    @GET("motel/get-news-liked-of-user")
    Call<JsonObject> getNewsLiked(@Header("Authorization") String authorization);
}

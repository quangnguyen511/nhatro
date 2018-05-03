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

public interface ApiHome {

    @GET("motel/get-room-of-user")
    Call<JsonObject> getHostels(@Header("Authorization") String authorization);
}

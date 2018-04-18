package com.svs.nhatro.network.api;
/*
 * Created by QuangNguyen on 16/04/2018.
 */

import com.google.gson.JsonObject;

import java.lang.reflect.Type;

import retrofit2.Call;

public interface ApiRequestListener {
    void onRequestApi(int nCode, Type mType, Call<JsonObject> call);

}

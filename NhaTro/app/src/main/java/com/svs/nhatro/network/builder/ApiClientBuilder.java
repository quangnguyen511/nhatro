package com.svs.nhatro.network.builder;
/*
 * Created by QuangNguyen on 16/04/2018.
 */

import com.google.gson.JsonObject;
import com.svs.nhatro.base.BaseApplication;
import com.svs.nhatro.network.api.ApiKey;
import com.svs.nhatro.network.api.ApiRequestListener;

import java.lang.reflect.Type;

import retrofit2.Call;

abstract class ApiClientBuilder {
    private ApiRequestListener mListener;
    private String mApiKey;
    private BaseApplication baseApp;

    ApiClientBuilder(ApiRequestListener listener, BaseApplication baseApp) {
        this.mListener = listener;
        this.baseApp = baseApp;
    }

    void requestApi(Type nType, Call<JsonObject> call) {
        if (mListener != null) {
            mListener.onRequestApi(ApiKey.CODE_DEFAULT, nType, call);
        }
    }

    void requestApi(int nCode, Type nType, Call<JsonObject> call) {
        if (mListener != null) {
            mListener.onRequestApi(nCode, nType, call);
        }
    }

//    void addApiKey(ApiParams params) {
//        if (TextUtils.isEmpty(mApiKey))
//            mApiKey = ApiConfig.createConnectionDetail(AppConfig.mConnectType).getApiKey();
//        params.add(ApiKey.API_KEY, mApiKey);
//    }

//    String getToken() {
//        return baseApp.getUserModel() != null ? baseApp.getUserModel().getAccessToken() : "";
//    }
}

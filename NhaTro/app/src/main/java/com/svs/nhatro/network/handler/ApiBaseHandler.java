package com.svs.nhatro.network.handler;
/*
 * Created by QuangNguyen on 16/04/2018.
 */

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.svs.nhatro.base.BaseActivity;
import com.svs.nhatro.base.BaseModel;
import com.svs.nhatro.model.ErrorModel;
import com.svs.nhatro.network.api.ApiRequestListener;
import com.svs.nhatro.network.api.ApiResponseListener;
import com.svs.nhatro.utils.AppUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiBaseHandler {
    private BaseActivity mActivity;
    private ApiResponseListener mResponseListener;
    public ApiRequestListener requestListener = (nCode, nType, call) -> {
        boolean isNetwork = AppUtils.isNetworkAvailable(mActivity);
        if (call != null && isNetwork) {
            if (call.isExecuted()) {
                call.cancel();
            }
            call.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(@NonNull Call<JsonObject> call, @NonNull Response<JsonObject> response) {
                    BaseModel mData = null;
                    if (response.body() != null) {
                        Gson gson = new Gson();
                        mData = gson.fromJson(response.body(), nType);
                    }
                    onDataResponse(nCode, mData);
                }

                @Override
                public void onFailure(@NonNull Call<JsonObject> call, @NonNull Throwable t) {
                    mResponseListener.onDataError(nCode, ErrorModel.parseData(t.getMessage()));
                    mActivity.dismissLoading();
                }
            });
        } else {
            if (!isNetwork) {

            }
//                AppUtils.showAlertDialog(mActivity, mActivity.getString(R.string.error_network),
//                        mActivity.getString(R.string.error_no_internet), null, AppConstant.STATUS_ERROR, null);
        }
    };

    public ApiBaseHandler(BaseActivity activity, ApiResponseListener responseListener) {
        this.mActivity = activity;
        this.mResponseListener = responseListener;

    }

    private void onDataResponse(int nCode, BaseModel nData) {
        mResponseListener.onDataResponse(nCode, nData);
    }
}

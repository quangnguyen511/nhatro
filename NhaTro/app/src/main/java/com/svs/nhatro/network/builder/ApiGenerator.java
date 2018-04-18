package com.svs.nhatro.network.builder;
/*
 * Created by QuangNguyen on 16/04/2018.
 */

import android.support.annotation.NonNull;

import com.svs.nhatro.config.AppConfig;
import com.svs.nhatro.model.ErrorModel;
import com.svs.nhatro.network.connect.ApiConfig;
import com.svs.nhatro.network.connect.ApiConfigDetail;
import com.svs.nhatro.network.connect.ApiConfigType;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiGenerator {

    private static ApiGenerator mInstance = new ApiGenerator();
    private Retrofit mRetrofit;

    private ApiGenerator() {
        mRetrofit = createRetrofit(AppConfig.mConnectType);
    }

    public static synchronized ApiGenerator getInstance() {
        if (mInstance == null)
            mInstance = new ApiGenerator();
        return mInstance;
    }

    public Retrofit createRetrofit(ApiConfigType connectType) {
        ApiConfigDetail apiConfigDetail = ApiConfig.createConnectionDetail(connectType);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new ApiCustomInterceptor(apiConfigDetail));
        httpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        return new Retrofit.Builder()
                .baseUrl(apiConfigDetail.getBaseURL())
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    public <S> S createService(Class<S> serviceClass) {
        return mRetrofit.create(serviceClass);
    }

    @SuppressWarnings("ConstantConditions")
    public static class ApiCustomInterceptor implements Interceptor {
        private ApiConfigDetail apiConfigDetail;

        public ApiCustomInterceptor(ApiConfigDetail apiConfigDetail) {
            this.apiConfigDetail = apiConfigDetail;
        }

        @Override
        public Response intercept(@NonNull Chain chain) throws IOException {
            Response response = chain.proceed(chain.request());
            if (response.code() != 200) {
                throw new IOException(ErrorModel.getErrorString(response));
            }
            String stringResponse = response.body().string();

            try {
                JSONObject root = new JSONObject(stringResponse);
                if (root.getString("status").equals("false")) {
                    throw new IOException(root.toString());
                } else {
                    Object data = root.get("data");
                    if (data instanceof JSONObject) {
                        return response.newBuilder()
                                .message("Successful")
                                .body(ResponseBody.create(response.body().contentType(),
                                        root.getJSONObject("data").toString()))
                                .build();
                    } else if (data instanceof JSONArray) {
                        return response.newBuilder()
                                .message("Successful")
                                .body(ResponseBody.create(response.body().contentType(),
                                        stringResponse))
                                .build();
                    }
                }

            } catch (Exception e) {
                throw new IOException(e.getMessage());
            }
            return null;
        }
    }

}

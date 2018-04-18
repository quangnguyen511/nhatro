package com.svs.nhatro.model;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import okhttp3.Response;

/**
 * Created by DangQuang on 4/16/18.
 **/

public class ErrorModel {
    @SerializedName("message")
    private String message;
    @SerializedName("status_code")
    private int code;

    public static ErrorModel parseData(String json) {
        ErrorModel errorModel;
        try {
            Gson gson = new Gson();
            errorModel = gson.fromJson(json, ErrorModel.class);
            if (errorModel != null) return errorModel;
            errorModel = new ErrorModel();
            errorModel.setMessage(json);
        } catch (Exception e) {
            errorModel = new ErrorModel();
            errorModel.setMessage(json);
        }
        return errorModel;
    }

    public static String getErrorString(Response response) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setCode(response.code());
        String body = response.body().toString();
        if (!body.startsWith("<!DOCTYPE HTML")) {
            errorModel.setMessage(body);
        } else {
            errorModel.setMessage("");
        }
        return errorModel.toString();
    }

    public String getMessage() {
        if (TextUtils.isEmpty(message)) return "Opps! Some things wrong.";
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

package com.svs.nhatro.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.IntentCompat;

import com.svs.nhatro.activity.AuthActivity;
import com.svs.nhatro.activity.MainActivity;

/**
 * Created by DangQuang on 4/18/18.
 **/

public class StartActivityUtils {
    @SuppressLint("WrongConstant")
    public static void toMain(Context context) {
        Intent intent = new Intent().setClass(context,
                MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }

    @SuppressLint("WrongConstant")
    public static void toAuth(Context context) {
        Intent intent = new Intent().setClass(context,
                AuthActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | IntentCompat.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
    }
}

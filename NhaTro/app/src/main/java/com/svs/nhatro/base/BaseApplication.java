package com.svs.nhatro.base;
/*
 * Created by QuangNguyen on 16/04/2018.
 */

import android.app.Application;

import com.svs.nhatro.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath(getString(R.string.font_gothic_regular))
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}

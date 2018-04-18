package com.svs.nhatro.activity;

import android.os.Bundle;
import android.os.Handler;

import com.svs.nhatro.R;
import com.svs.nhatro.base.BaseActivity;
import com.svs.nhatro.utils.StartActivityUtils;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(() -> {
            StartActivityUtils.toAuth(getApplicationContext());
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }, 1500);
    }
}

package com.svs.nhatro.activity;

import android.app.ActionBar;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.svs.nhatro.R;
import com.svs.nhatro.base.BaseActivity;
import com.svs.nhatro.utils.StartActivityUtils;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getActionBar();
        if (actionBar != null)
            actionBar.hide();
        new Handler().postDelayed(() -> {
            StartActivityUtils.toAuth(getApplicationContext());
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        }, 1500);
    }
}

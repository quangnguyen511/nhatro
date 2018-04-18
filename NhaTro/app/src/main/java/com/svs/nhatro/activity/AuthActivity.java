package com.svs.nhatro.activity;

import android.os.Bundle;

import com.svs.nhatro.R;
import com.svs.nhatro.base.BaseActivity;
import com.svs.nhatro.fragment.authentication.LoginFragment;

public class AuthActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        replaceFragment(new LoginFragment(), false);
    }
}

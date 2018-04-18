package com.svs.nhatro.others.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.svs.nhatro.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by DangQuang on 4/18/18.
 **/

public class ForgotPassDialog extends DialogFragment {

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_forgot_password,container,false);
        unbinder = ButterKnife.bind(this,view);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

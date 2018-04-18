package com.svs.nhatro.others.dialog;
/*
 * Created by HoangDong on 08/11/2017.
 */

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;

import com.svs.nhatro.R;

public class LoadingDialog extends Dialog {

    public LoadingDialog(Context context) {
        super(context, android.R.style.Theme_Holo_Dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (getWindow() != null) {
            getWindow().setDimAmount(0.3f);
            getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        setContentView(R.layout.dialog_loading);
    }
}

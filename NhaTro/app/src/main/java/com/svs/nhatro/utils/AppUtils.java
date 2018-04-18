package com.svs.nhatro.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.TextView;

import com.svs.nhatro.interfaces.DialogListener;

/**
 * Created by DangQuang on 4/16/18.
 **/

public class AppUtils {
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = null;
        if (cm != null) {
            netInfo = cm.getActiveNetworkInfo();
        }
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }
    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static void showAlert(final Context context, String title, String content, @Nullable final DialogListener listener) {
//        Dialog dialog = new Dialog(context);
//        dialog.setContentView(R.layout.dialog_notice);
//        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
//        TextView tvTitle = dialog.findViewById(R.id.dialogNotice_tvTitle);
//        TextView tvContent = dialog.findViewById(R.id.dialogNotice_tvContent);
//        TextView tvDone = dialog.findViewById(R.id.dialogNotice_tvOK);
//        tvTitle.setText(title);
//        tvContent.setText(content);
//        tvDone.setOnClickListener(view -> {
//            dialog.dismiss();
//            if (listener != null)
//                listener.onConfirmClicked();
//        });
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.show();
    }
}

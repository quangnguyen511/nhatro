package com.svs.nhatro.base;
/*
 * Created by QuangNguyen on 16/04/2018.
 */

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.svs.nhatro.R;
import com.svs.nhatro.model.ErrorModel;
import com.svs.nhatro.network.api.ApiResponseListener;
import com.svs.nhatro.network.builder.ApiClient;
import com.svs.nhatro.network.handler.ApiBaseHandler;
import com.svs.nhatro.others.dialog.LoadingDialog;
import com.svs.nhatro.utils.AppUtils;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public abstract class BaseActivity extends AppCompatActivity implements ApiResponseListener {

    public ApiClient mApiClient;
    View.OnClickListener onBackClick = view -> onBackPressed();
    private LoadingDialog mDialogView;

    public void setActionBarBack(View view, String title) {
//        TextView tvTitle = view.findViewById(R.id.actionbarBack_tvTitle);
//        ImageView imvBack = view.findViewById(R.id.actionbarBack_imvBack);
//        if (tvTitle != null) {
//            tvTitle.setText(title);
//        }
//        if (imvBack != null) {
//            imvBack.setOnClickListener(onBackClick);
//        }

    }

    public void setActionBarClose(View view, String title) {
//        TextView tvTitle = view.findViewById(R.id.actionbarClose_tvTitle);
//        ImageView imvClose = view.findViewById(R.id.actionbarClose_imvClose);
//        if (tvTitle != null) {
//            tvTitle.setText(title);
//        }
//        if (imvClose != null) {
//            imvClose.setOnClickListener(onBackClick);
//        }
    }

//    public UserModel getCurrentUser() {
//        return ((BaseApplication) getApplication()).getUserModel();
//    }
//
//    public void setCurrentUser(UserModel user) {
//        ((BaseApplication) getApplication()).setUserModel(user);
//    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApiBaseHandler mBaseHandler = new ApiBaseHandler(this, this);
        mApiClient = new ApiClient(mBaseHandler.requestListener, (BaseApplication) getApplication());
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getActionBar();
        if (actionBar != null)
            actionBar.hide();
    }

    public void showLoading() {
        if (AppUtils.isNetworkAvailable(this))
            if (mDialogView != null) {
                mDialogView.show();
            } else {
                mDialogView = new LoadingDialog(this);
                mDialogView.setCanceledOnTouchOutside(false);
                mDialogView.show();
            }
    }

    public void dismissLoading() {
        if (mDialogView != null) {
            mDialogView.dismiss();
        }
    }

    private void addReplaceFragment(BaseFragment fragment, boolean isReplace, boolean isAddToBackStack) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager != null && fragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            if (isReplace)
                fragmentTransaction.replace(R.id.frmContainer, fragment);
            else {
                android.support.v4.app.Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.frmContainer);
                if (currentFragment != null) {
                    fragmentTransaction.hide(currentFragment);
                }
                fragmentTransaction.add(R.id.frmContainer, fragment, fragment.getClass().getSimpleName());
            }
            if (isAddToBackStack) {
                fragmentTransaction.addToBackStack(fragment.getClass().getSimpleName());
            }
            fragmentTransaction.commit();
        }
    }

    public void replaceFragment(BaseFragment fragment, boolean isAddToBackStack) {

        addReplaceFragment(fragment, true, isAddToBackStack);
    }

    public void addFragment(BaseFragment fragment, boolean isAddToBackStack) {
        addReplaceFragment(fragment, false, isAddToBackStack);
    }

    public void clearAllBackStack() {
        FragmentManager fm = getSupportFragmentManager();
        int count = fm.getBackStackEntryCount();
        for (int i = 0; i < count; ++i) {
            fm.popBackStack();
        }
    }

    @Override
    public void onDataError(int nCode, ErrorModel error) {
        if (error.getMessage().contains(getString(R.string.error_parse_json)) || error.getMessage().contains(getString(R.string.error_parse_type)))
            AppUtils.showAlert(this, getString(R.string.error), getString(R.string.error_server), null);
        else
            AppUtils.showAlert(this, getString(R.string.error), error.getMessage(), null);

    }

    @Override
    public void onDataResponse(int nCode, BaseModel nData) {

    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}

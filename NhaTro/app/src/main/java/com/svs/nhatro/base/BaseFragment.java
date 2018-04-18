package com.svs.nhatro.base;
/*
 * Created by QuangNguyen on 16/04/2018.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.svs.nhatro.R;
import com.svs.nhatro.interfaces.FragmentResultListener;
import com.svs.nhatro.model.ErrorModel;
import com.svs.nhatro.network.api.ApiResponseListener;
import com.svs.nhatro.network.builder.ApiClient;
import com.svs.nhatro.network.handler.ApiBaseHandler;
import com.svs.nhatro.utils.AppUtils;

public abstract class BaseFragment extends Fragment implements ApiResponseListener {
    public ApiClient mApiClient;
    private FragmentResultListener resultListener;
    private int mCodeRequest;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ApiBaseHandler mBaseHandler = new ApiBaseHandler((BaseActivity) getActivity(), this);
        mApiClient = new ApiClient(mBaseHandler.requestListener, (BaseApplication) getActivity().getApplication());

    }

//    public UserModel getCurrentUser() {
//        if (getActivity() instanceof MainActivity)
//            return ((MainActivity) getActivity()).getCurrentUser();
//        else
//            return new UserModel();
//    }

    public void setFragmentForResult(int codeRequest, FragmentResultListener fragmentResultListener) {
        this.resultListener = fragmentResultListener;
        this.mCodeRequest = codeRequest;
    }

    protected void callBackFragmentResult(Bundle bundle) {
        if (resultListener != null)
            resultListener.onFragmentForResult(mCodeRequest, bundle);
    }

    public void setActionBarBack(View view, String title) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).setActionBarBack(view, title);
        }
    }

    public void setActionBarClose(View view, String title) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).setActionBarClose(view, title);
        }
    }

    public void setActionBarTitle(View view, String title) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).setActionBarTitle(view, title);
        }
    }

//    public void setCurrentUser(UserModel user) {
//        if (getActivity() instanceof BaseActivity) {
//            ((BaseActivity) getActivity()).setCurrentUser(user);
//        }
//    }

    public void clearAllBackStack() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).clearAllBackStack();
        }
    }

    public void replaceFragment(BaseFragment fragment, boolean isAddToBackStack) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).replaceFragment(fragment, isAddToBackStack);
        }
    }

    public void addFragment(BaseFragment fragment, boolean isAddToBackStack) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).addFragment(fragment, isAddToBackStack);
        }
    }

    public void showLoading() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).showLoading();
        }
    }

    public void dismissLoading() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).dismissLoading();
        }
    }

    public void clearErrorText(TextView[] textViews) {
        for (TextView textView : textViews)
            textView.setText("");
    }

    @Override
    public void onDataError(int nCode, ErrorModel error) {
        if (!this.isDetached()) {
            if (error.getMessage().contains(getString(R.string.error_parse_json)) || error.getMessage().contains(getString(R.string.error_parse_type)))
                AppUtils.showAlert(getActivity(), getString(R.string.error), getString(R.string.error_server), null);
            else
                AppUtils.showAlert(getActivity(), getString(R.string.error), error.getMessage(), null);
        }
    }

    @Override
    public void onDataResponse(int nCode, BaseModel nData) {

    }

}

package com.svs.nhatro.fragment.authentication;


import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.svs.nhatro.R;
import com.svs.nhatro.base.BaseFragment;
import com.svs.nhatro.utils.AppUtils;
import com.svs.nhatro.utils.KeyboardUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginEmailFragment extends BaseFragment {

    @BindView(R.id.fragLogEmail_etEmail)
    EditText etEmail;
    @BindView(R.id.fragLogEmail_etPassword)
    EditText etPassword;
    @BindView(R.id.fragLogEmail_tvForgot)
    TextView tvForgot;
    @BindView(R.id.fragLogEmail_tvSignUp)
    TextView tvSignUp;

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_email, container, false);
        unbinder = ButterKnife.bind(this, view);
        KeyboardUtils.setupUI(view, getActivity());
        initialize();
        return view;
    }

    @OnClick({R.id.fragLogEmail_tvLogin, R.id.fragLogEmail_tvForgot, R.id.fragLogEmail_tvSignUp})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragLogEmail_tvLogin:
                if (checkValidInput()) {

                }
                break;
            case R.id.fragLogEmail_tvForgot:
                break;
            case R.id.fragLogEmail_tvSignUp:
//                addFragment(new S);
                break;
        }
    }

    private void initialize() {
        tvForgot.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
        tvSignUp.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
    }

    private boolean checkValidInput() {
        String error = "";
        if (TextUtils.isEmpty(etEmail.getText()) || TextUtils.isEmpty(etPassword.getText()))
            error = getString(R.string.empty_email_password);
        else if (!AppUtils.isValidEmail(etEmail.getText().toString()))
            error = getString(R.string.valid_input_email);
        if (TextUtils.isEmpty(error)) {
            return true;
        } else {
            AppUtils.showAlert(getContext(), getString(R.string.alert), error, null);
            return false;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

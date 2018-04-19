package com.svs.nhatro.fragment.authentication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

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
public class SignUpFragment extends BaseFragment {

    @BindView(R.id.fragSignUp_etPhone)
    EditText etPhone;
    @BindView(R.id.fragSignUp_etLastName)
    EditText etLastName;
    @BindView(R.id.fragSignUp_etFirstName)
    EditText etFirstName;
    @BindView(R.id.fragSignUp_etEmail)
    EditText etEmail;
    @BindView(R.id.fragSignUp_etPassword)
    EditText etPassword;
    @BindView(R.id.fragSignUp_etConfirmPassword)
    EditText etConfirmPassword;

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        unbinder = ButterKnife.bind(this, view);
        KeyboardUtils.setupUI(view,getActivity());
        return view;
    }

    @OnClick(R.id.fragSignUp_tvSignUp)
    public void onViewClicked() {
        if(checkValidInput()){

        }
    }

    private boolean checkValidInput() {
        String error = "";
        if (TextUtils.isEmpty(etPhone.getText()) || TextUtils.isEmpty(etFirstName.getText()) || TextUtils.isEmpty(etLastName.getText()) ||
                TextUtils.isEmpty(etEmail.getText()) || TextUtils.isEmpty(etPassword.getText()) || TextUtils.isEmpty(etConfirmPassword.getText()))
            error = getString(R.string.empty_input);
        if (AppUtils.isValidEmail(etEmail.getText().toString()))
            error = getString(R.string.valid_input_email);
        if (!TextUtils.isEmpty(error))
            return true;
        else {
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

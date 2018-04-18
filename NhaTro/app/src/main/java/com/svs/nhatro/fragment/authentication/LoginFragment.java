package com.svs.nhatro.fragment.authentication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.svs.nhatro.R;
import com.svs.nhatro.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment {

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.fragLogin_tvFacebook, R.id.fragLogin_tvGoogle, R.id.fragLogin_tvEmail})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragLogin_tvFacebook:
                break;
            case R.id.fragLogin_tvGoogle:
                break;
            case R.id.fragLogin_tvEmail:
                addFragment(new LoginEmailFragment(), true);
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

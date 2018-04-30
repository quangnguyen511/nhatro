package com.svs.nhatro.fragment.menu;


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
public class MenuFragment extends BaseFragment {

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.fragMenu_tvInformation, R.id.fragMenu_tvHostel, R.id.fragMenu_tvHistory, R.id.fragMenu_tvSecurity, R.id.fragMenu_tvLogOut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragMenu_tvInformation:
                break;
            case R.id.fragMenu_tvHostel:
                break;
            case R.id.fragMenu_tvHistory:
                break;
            case R.id.fragMenu_tvSecurity:
                break;
            case R.id.fragMenu_tvLogOut:
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

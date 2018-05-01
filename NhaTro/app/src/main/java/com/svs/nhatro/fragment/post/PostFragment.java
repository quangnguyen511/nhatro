package com.svs.nhatro.fragment.post;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.svs.nhatro.R;
import com.svs.nhatro.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class PostFragment extends BaseFragment {

    @BindView(R.id.fragPost_etAddress)
    EditText etAddress;
    @BindView(R.id.fragPost_etSquare)
    EditText etSquare;
    @BindView(R.id.fragPost_etPrice)
    EditText etPrice;
    @BindView(R.id.fragPost_etContact)
    EditText etContact;
    @BindView(R.id.fragPost_etDescription)
    EditText etDescription;
    @BindView(R.id.fragPost_rvImages)
    RecyclerView rvImages;
    @BindView(R.id.fragPost_frmAddImage)
    FrameLayout frmAddImage;
    Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.fragPost_frmAddImage, R.id.fragPost_tvPost})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragPost_frmAddImage:
                break;
            case R.id.fragPost_tvPost:
                break;
        }
    }
}

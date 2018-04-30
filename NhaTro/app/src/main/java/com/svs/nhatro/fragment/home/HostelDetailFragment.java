package com.svs.nhatro.fragment.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.svs.nhatro.R;
import com.svs.nhatro.base.BaseFragment;
import com.svs.nhatro.others.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HostelDetailFragment extends BaseFragment {

    @BindView(R.id.fragHostelDetail_imvTop)
    ImageView imvTop;
    @BindView(R.id.fragHostelDetail_imvBack)
    ImageView imvBack;
    @BindView(R.id.fragHostelDetail_tvAddress)
    TextView tvAddress;
    @BindView(R.id.fragHostelDetail_tvPrice)
    TextView tvPrice;
    @BindView(R.id.fragHostelDetail_tvPhoneNumber)
    TextView tvPhoneNumber;
    @BindView(R.id.fragHostelDetail_imvFavorite)
    ImageView imvFavorite;
    @BindView(R.id.fragHostelDetail_imvUser)
    CircleImageView imvUser;
    @BindView(R.id.fragHostelDetail_tvOwnerName)
    TextView tvOwnerName;
    @BindView(R.id.fragHostelDetail_tvOwnerDate)
    TextView tvOwnerDate;
    @BindView(R.id.fragHostelDetail_tvAddressDetail)
    TextView tvAddressDetail;
    @BindView(R.id.fragHostelDetail_tvSquare)
    TextView tvSquare;
    @BindView(R.id.fragHostelDetail_tvPriceDetail)
    TextView tvPriceDetail;
    @BindView(R.id.fragHostelDetail_tvContact)
    TextView tvContact;
    @BindView(R.id.fragHostelDetail_tvDescription)
    TextView tvDescription;
    @BindView(R.id.fragHostelDetail_rvImages)
    RecyclerView rvImages;
    @BindView(R.id.fragHostelDetail_rvHostels)
    RecyclerView rvHostels;

    private Unbinder unbinder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hostel_detail, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.fragHostelDetail_imvFavorite, R.id.fragHostelDetail_imvShare, R.id.fragHostelDetail_tvAddressDetail, R.id.fragHostelDetail_tvContact})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.fragHostelDetail_imvFavorite:
                break;
            case R.id.fragHostelDetail_imvShare:
                break;
            case R.id.fragHostelDetail_tvAddressDetail:
                break;
            case R.id.fragHostelDetail_tvContact:
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

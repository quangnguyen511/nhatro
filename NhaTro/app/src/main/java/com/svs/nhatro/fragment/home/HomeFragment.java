package com.svs.nhatro.fragment.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.svs.nhatro.R;
import com.svs.nhatro.adapter.HostelAdapter;
import com.svs.nhatro.base.BaseFragment;
import com.svs.nhatro.interfaces.ItemListener;
import com.svs.nhatro.model.HostelModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements ItemListener {

    @BindView(R.id.fragHome_rvHostels)
    RecyclerView rvHostels;

    private Unbinder unbinder;
    private ArrayList<HostelModel> mHostels = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);
        initialize();
        return view;
    }

    private void initialize(){
        HostelModel mHostel = new HostelModel(0,"name",0,"2tr5","Au Co");
        mHostels.add(mHostel);
        mHostels.add(mHostel);
        mHostels.add(mHostel);
        mHostels.add(mHostel);
        mHostels.add(mHostel);

        HostelAdapter hostelAdapter = new HostelAdapter(mHostels);
        rvHostels.setLayoutManager(new LinearLayoutManager(getContext()));
        rvHostels.setAdapter(hostelAdapter);
        hostelAdapter.setListener(this);
    }

    @Override
    public void onItemClicked(int pos) {
        addFragment(new HostelDetailFragment(),true);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

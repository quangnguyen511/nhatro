package com.svs.nhatro.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.svs.nhatro.R;
import com.svs.nhatro.model.HostelModel;

import java.util.ArrayList;

import butterknife.ButterKnife;

/**
 * Created by DangQuang on 4/19/18.
 **/

public class HostelAdapter extends RecyclerView.Adapter<HostelAdapter.HostelHolder> {

    private ArrayList<HostelModel> mHostels = new ArrayList<>();

    public HostelAdapter(ArrayList<HostelModel> mHostels) {
        this.mHostels = mHostels;
    }

    @Override
    public HostelHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HostelHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hostel,parent,false));
    }

    @Override
    public void onBindViewHolder(HostelHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class HostelHolder extends RecyclerView.ViewHolder{
        HostelHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}

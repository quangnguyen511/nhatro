package com.svs.nhatro.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.svs.nhatro.R;
import com.svs.nhatro.interfaces.ItemListener;
import com.svs.nhatro.model.HostelModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by DangQuang on 4/19/18.
 **/

public class HostelAdapter extends RecyclerView.Adapter<HostelAdapter.HostelHolder> {

    private ArrayList<HostelModel> mHostels = new ArrayList<>();
    private ItemListener listener;

    public HostelAdapter(ArrayList<HostelModel> mHostels) {
        this.mHostels = mHostels;
    }

    public void setListener(ItemListener listener) {
        this.listener = listener;
    }

    @Override
    public HostelHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HostelHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hostel, parent, false));
    }

    @Override
    public void onBindViewHolder(HostelHolder holder, int position) {
        HostelModel mHostel = mHostels.get(position);
        holder.tvAddress.setText(mHostel.getArea());
        holder.tvPrice.setText(String.format(holder.tvPrice.getContext().getString(R.string.price), mHostel.getUnitPrice()));
//        holder.tvPhoneNumber.setText(mHostel.);
    }

    @Override
    public int getItemCount() {
        return mHostels != null ? mHostels.size() : 0;
    }

    class HostelHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.itemHostel_imvHostel)
        ImageView imvHostel;
        @BindView(R.id.itemHostel_tvAddress)
        TextView tvAddress;
        @BindView(R.id.itemHostel_tvPrice)
        TextView tvPrice;
        @BindView(R.id.itemHostel_tvPhoneNumber)
        TextView tvPhoneNumber;
        @BindView(R.id.itemHostel_rbRating)
        RatingBar rbRating;
        @BindView(R.id.itemHostel_tvRatingCount)
        TextView tvRatingCount;

        HostelHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            itemView.setOnClickListener(view -> listener.onItemClicked(getAdapterPosition()));
        }
    }
}

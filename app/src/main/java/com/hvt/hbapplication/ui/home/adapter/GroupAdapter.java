package com.hvt.hbapplication.ui.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.network.response.EthnicPreview;
import com.hvt.hbapplication.ui.home.adapter.viewholder.EthnicViewHolder;

import java.util.ArrayList;


public class GroupAdapter extends RecyclerView.Adapter<EthnicViewHolder> {

    public ArrayList<EthnicPreview> ethnicCommunities;

    public GroupAdapter(ArrayList<EthnicPreview> ethnicCommunities) {
        this.ethnicCommunities = ethnicCommunities;
    }

    @Override
    public EthnicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ethnic, parent, false);
        return new EthnicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EthnicViewHolder holder, int position) {
        holder.bindData(ethnicCommunities.get(position));
    }

    @Override
    public int getItemCount() {
        return ethnicCommunities == null ? 0 : ethnicCommunities.size();
    }
}

package com.hvt.hbapplication.ui.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.ui.home.adapter.viewholder.EthnicViewHolder;
import com.hvt.hbapplication.ui.model.EthnicCommunity;

import java.util.ArrayList;

/**
 * Created by Admin on 27-Jun-17.
 */

public class GroupAdapter extends RecyclerView.Adapter<EthnicViewHolder> {

    public ArrayList<EthnicCommunity> ethnicCommunities;

    public GroupAdapter(ArrayList<EthnicCommunity> ethnicCommunities) {
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

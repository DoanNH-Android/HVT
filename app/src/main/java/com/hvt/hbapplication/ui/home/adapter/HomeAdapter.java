package com.hvt.hbapplication.ui.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.ui.home.adapter.viewholder.GroupEthnicViewHolder;
import com.hvt.hbapplication.ui.home.adapter.viewholder.TopEthnicViewHolder;
import com.hvt.hbapplication.model.EthnicCommunity;
import com.hvt.hbapplication.model.GroupEthnicCommunity;

import java.util.ArrayList;

/**
 * Created by Admin on 27-Jun-17.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    enum ItemType {
        FIRST_PAGE,
        OTHERS
    }

    public ArrayList<GroupEthnicCommunity> groups;

    public ArrayList<EthnicCommunity> ethnicCommunities;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == ItemType.FIRST_PAGE.ordinal()) {

        }
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group, parent, false);
        return new GroupEthnicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == ItemType.FIRST_PAGE.ordinal()) {
            ((TopEthnicViewHolder) holder).bindData(ethnicCommunities);
        } else {
            ((GroupEthnicViewHolder) holder).bindData(groups.get(position - 1));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ItemType.FIRST_PAGE.ordinal();
        }
        return ItemType.OTHERS.ordinal();
    }

    @Override
    public int getItemCount() {
        return groups == null ? 1 : (groups.size() + 1);
    }
}

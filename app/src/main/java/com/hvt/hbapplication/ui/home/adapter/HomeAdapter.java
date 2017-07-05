package com.hvt.hbapplication.ui.home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.model.GroupEthnicCommunity;
import com.hvt.hbapplication.network.response.EthnicPreview;
import com.hvt.hbapplication.ui.home.adapter.viewholder.GroupEthnicViewHolder;
import com.hvt.hbapplication.ui.home.adapter.viewholder.TopEthnicViewHolder;

import java.util.ArrayList;


public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    enum ItemType {
        FIRST_PAGE,
        OTHERS
    }

    public ArrayList<GroupEthnicCommunity> groups = new ArrayList<>();

    public ArrayList<EthnicPreview> ethnicTop = new ArrayList<>();

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == ItemType.FIRST_PAGE.ordinal()) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_ethnic, parent, false);
            return new TopEthnicViewHolder(view);
        }
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group, parent, false);
        return new GroupEthnicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == ItemType.FIRST_PAGE.ordinal()) {
            ((TopEthnicViewHolder) holder).bindData(ethnicTop);
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
        if (ethnicTop == null) {
            return 0;
        } else {
            return groups == null ? 1 : (groups.size() + 1);
        }
    }
}

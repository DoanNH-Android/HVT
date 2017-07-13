package com.hvt.hbapplication.ui.search.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.model.EthnicCommunity;
import com.hvt.hbapplication.ui.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hado on 7/12/17.
 */

public class SearchAdapter extends BaseAdapter<ResultViewHolder> {

    ArrayList<EthnicCommunity> results = new ArrayList<>();

    @Override
    public ResultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result, parent, false);
        return new ResultViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(ResultViewHolder holder, int position) {
        holder.bindData(results.get(position));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public void setData(List<EthnicCommunity> data) {
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();
    }
}

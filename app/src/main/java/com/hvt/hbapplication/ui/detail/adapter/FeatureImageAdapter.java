package com.hvt.hbapplication.ui.detail.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.model.Image;
import com.hvt.hbapplication.ui.detail.adapter.viewholder.FeatureImageViewHolder;

import java.util.ArrayList;

/**
 * Created by Hado on 7/4/17.
 */

public class FeatureImageAdapter extends RecyclerView.Adapter<FeatureImageViewHolder> {

    public ArrayList<Image> images;

    @Override
    public FeatureImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_more_information, parent, false);
        return new FeatureImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeatureImageViewHolder holder, int position) {
        holder.bindData(images.get(position));
    }

    @Override
    public int getItemCount() {
        return images == null ? 0 : images.size();
    }
}

package com.hvt.hbapplication.ui.detail.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.model.FeatureTranslation;
import com.hvt.hbapplication.ui.detail.adapter.viewholder.FeatureViewHolder;

import java.util.ArrayList;

public class FeatureAdapter extends RecyclerView.Adapter<FeatureViewHolder> {

    public ArrayList<FeatureTranslation> featureTranslations = new ArrayList<>();

    @Override
    public FeatureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_more_information, parent, false);
        return new FeatureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FeatureViewHolder holder, int position) {
        holder.bindData(featureTranslations.get(position));
    }

    @Override
    public int getItemCount() {
        return featureTranslations == null ? 0 : featureTranslations.size();
    }
}

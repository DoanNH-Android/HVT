package com.hvt.hbapplication.ui.detail.adapter.viewholder;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.model.FeatureTranslation;
import com.hvt.hbapplication.ui.BaseViewHolder;
import com.hvt.hbapplication.ui.detail.adapter.FeatureImageAdapter;
import com.hvt.hbapplication.util.font.StringUtils;
import com.hvt.hbapplication.widget.SpacesItemDecoration;

import java.util.Collections;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hado on 7/4/17.
 */

public class FeatureViewHolder extends BaseViewHolder<FeatureTranslation> {

    @BindView(R.id.tv_feature_name)
    public TextView tvTitleName;

    @BindView(R.id.tv_description)
    public TextView tvDescription;

    @BindView(R.id.rv_image_feature)
    public RecyclerView rvImageFeature;

    public FeatureImageAdapter featureImageAdapter = new FeatureImageAdapter();

    public FeatureViewHolder(View itemView) {
        super(itemView);
        GridLayoutManager layoutManager = new GridLayoutManager(itemView.getContext(), 2, LinearLayoutManager.VERTICAL, false);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                int size = featureImageAdapter.images == null ? 0 : featureImageAdapter.images.size();
                if (size % 2 == 1 && position == size - 1) return 2;
                return 1;
            }
        });
        rvImageFeature.setLayoutManager(layoutManager);
        rvImageFeature.setAdapter(featureImageAdapter);
        rvImageFeature.addItemDecoration(new SpacesItemDecoration(itemView.getContext(), featureImageAdapter, 3, false));
    }

    @Override
    public void bindData(FeatureTranslation data) {
        StringUtils.setText(tvTitleName, data.getFeatureType());
        StringUtils.setText(tvDescription, data.getDescription());

        featureImageAdapter.images.clear();
        featureImageAdapter.images.addAll(data.getImages() == null ? Collections.emptyList() : data.getImages());
        featureImageAdapter.notifyDataSetChanged();
    }

    @Override
    public void bindView() {
        ButterKnife.bind(this, itemView);
    }
}

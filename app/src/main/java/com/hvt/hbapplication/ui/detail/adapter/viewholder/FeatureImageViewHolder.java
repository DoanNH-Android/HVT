package com.hvt.hbapplication.ui.detail.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hvt.hbapplication.R;
import com.hvt.hbapplication.model.Image;
import com.hvt.hbapplication.ui.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hado on 7/4/17.
 */

public class FeatureImageViewHolder extends BaseViewHolder<Image> {

    @BindView(R.id.iv_image)
    public ImageView ivImage;

    public FeatureImageViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(Image data) {
        Glide.with(itemView.getContext())
                .load(data.getImageUrl())
                .placeholder(R.drawable.error_holder)
                .error(R.drawable.error_holder).into(ivImage);
    }

    @Override
    public void bindView() {
        ButterKnife.bind(this, itemView);
    }
}

package com.hvt.hbapplication.ui.search.adapter;

import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.hvt.hbapplication.R;
import com.hvt.hbapplication.data.model.FolkBookmark;
import com.hvt.hbapplication.ui.BaseViewHolder;
import com.hvt.hbapplication.ui.OnClickItemListener;
import com.hvt.hbapplication.util.font.StringUtils;
import com.hvt.hbapplication.widget.CustomFontTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hado on 7/12/17.
 */

public class ResultViewHolder extends BaseViewHolder<FolkBookmark> {

    @BindView(R.id.iv_background)
    AppCompatImageView ivBackground;

    @BindView(R.id.tv_ethnic_name)
    CustomFontTextView tvFolkName;


    public ResultViewHolder(View itemView, OnClickItemListener listener) {
        super(itemView, listener);
    }

    @Override
    public void bindData(FolkBookmark data) {
        StringUtils.setText(tvFolkName, data.name);
        Glide.with(itemView.getContext()).load(data.backgroundUrl)
                .asBitmap()
                .centerCrop()
                .placeholder(R.drawable.error_holder)
                .error(R.drawable.error_holder)
                .into(new BitmapImageViewTarget(ivBackground) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(itemView.getContext().getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        ivBackground.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    @Override
    public void bindView() {
        ButterKnife.bind(this, itemView);
    }
}

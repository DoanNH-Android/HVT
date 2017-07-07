package com.hvt.hbapplication.ui.bookmark.adapter.viewholder;

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

public class BookmarkViewHolder extends BaseViewHolder<FolkBookmark> {

    @BindView(R.id.iv_background)
    AppCompatImageView ivBackground;

    @BindView(R.id.iv_bookmark)
    AppCompatImageView ivBookmark;

    @BindView(R.id.tv_ethnic_name)
    CustomFontTextView tvFolkName;

    OnClickItemListener starClickListener;

    public BookmarkViewHolder(View itemView, OnClickItemListener listener, OnClickItemListener starClickListener) {
        super(itemView, listener);
        this.starClickListener = starClickListener;
        ivBookmark.setOnClickListener(view -> {
            ivBookmark.setSelected(!ivBookmark.isSelected());
            if (BookmarkViewHolder.this.starClickListener != null) {
                BookmarkViewHolder.this.starClickListener.onItemClicked(getAdapterPosition());
            }
        });
    }

    @Override
    public void bindData(FolkBookmark data) {
        StringUtils.setText(tvFolkName, data.name);
        ivBookmark.setSelected(data.isSelected);
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

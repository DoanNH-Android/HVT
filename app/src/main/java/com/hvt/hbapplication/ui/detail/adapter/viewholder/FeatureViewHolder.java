package com.hvt.hbapplication.ui.detail.adapter.viewholder;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.model.FeatureTranslation;
import com.hvt.hbapplication.ui.BaseViewHolder;
import com.hvt.hbapplication.ui.detail.adapter.ImagePagerAdapter;
import com.hvt.hbapplication.util.font.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Hado on 7/4/17.
 */

public class FeatureViewHolder extends BaseViewHolder<FeatureTranslation> {

    @BindView(R.id.tv_feature_name)
    public TextView tvTitleName;

    @BindView(R.id.tv_description)
    public TextView tvDescription;

    @BindView(R.id.rv_image_feature)
    public ViewPager vpImages;

    @BindView(R.id.indicator)
    public CircleIndicator indicator;

    public ImagePagerAdapter adapter = new ImagePagerAdapter();

    public FeatureViewHolder(View itemView) {
        super(itemView);
        vpImages.setAdapter(adapter);
    }

    @Override
    public void bindData(FeatureTranslation data) {
        StringUtils.setText(tvTitleName, data.getFeatureType().toUpperCase());
        StringUtils.setText(tvDescription, data.getDescription());
        adapter.images.clear();
        adapter.images.addAll(data.getImages());
        adapter.notifyDataSetChanged();
        indicator.setViewPager(vpImages);
    }

    @Override
    public void bindView() {
        ButterKnife.bind(this, itemView);
    }
}

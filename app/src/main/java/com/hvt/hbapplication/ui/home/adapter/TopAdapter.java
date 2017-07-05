package com.hvt.hbapplication.ui.home.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.hvt.hbapplication.R;
import com.hvt.hbapplication.network.response.EthnicPreview;
import com.hvt.hbapplication.ui.detail.DetailActivity;

import java.util.ArrayList;


public class TopAdapter extends PagerAdapter {

    public ArrayList<EthnicPreview> ethnicCommunities = new ArrayList<>();

    @Override
    public int getCount() {
        return ethnicCommunities == null ? 0 : ethnicCommunities.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Context context = container.getContext();
        ImageView view = new ImageView(context);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view.setScaleType(ImageView.ScaleType.CENTER_CROP);
        Glide.with(context).load(ethnicCommunities.get(position).getBackgroundUrl())
                .placeholder(R.drawable.error_holder)
                .error(R.drawable.error_holder)
                .into(view);
        view.setOnClickListener(view1 -> DetailActivity.navigate(context, ethnicCommunities.get(position).getId()));
        return view;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        ((ViewPager) container).removeView((View) object);
    }
}

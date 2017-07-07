package com.hvt.hbapplication.ui.home.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
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

    private LayoutInflater layoutInflater;

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
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(context);
        }
        ImageView view = (ImageView) layoutInflater.inflate(R.layout.item_top_banner, container, false);
        Glide.with(context).load(ethnicCommunities.get(position).getBackgroundUrl())
                .placeholder(R.drawable.error_holder)
                .error(R.drawable.error_holder)
                .into(view);
        view.setOnClickListener(view1 -> DetailActivity.navigate(context, ethnicCommunities.get(position).getId()));
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((ImageView) object);
    }
}

package com.hvt.hbapplication.ui.home.adapter.viewholder;

import android.view.View;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.network.response.EthnicPreview;
import com.hvt.hbapplication.ui.BaseViewHolder;
import com.hvt.hbapplication.ui.home.adapter.TopAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.trinea.android.view.autoscrollviewpager.AutoScrollViewPager;
import me.relex.circleindicator.CircleIndicator;

public class TopEthnicViewHolder extends BaseViewHolder<ArrayList<EthnicPreview>> {

    @BindView(R.id.vp_top)
    public AutoScrollViewPager vpEthnic;

    @BindView(R.id.indicator)
    public CircleIndicator indicator;

    public TopAdapter topAdapter;


    public TopEthnicViewHolder(View itemView) {
        super(itemView);
        topAdapter = new TopAdapter();
        vpEthnic.setInterval(3000);
        vpEthnic.setAdapter(topAdapter);
    }

    @Override
    public void bindData(ArrayList<EthnicPreview> data) {
        topAdapter.ethnicCommunities.clear();
        topAdapter.ethnicCommunities.addAll(data);
        topAdapter.notifyDataSetChanged();
        indicator.setViewPager(vpEthnic);
        vpEthnic.startAutoScroll();
    }

    @Override
    public void bindView() {
        ButterKnife.bind(this, itemView);
    }
}

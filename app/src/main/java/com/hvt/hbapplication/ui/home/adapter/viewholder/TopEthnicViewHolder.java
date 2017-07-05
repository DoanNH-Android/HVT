package com.hvt.hbapplication.ui.home.adapter.viewholder;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.ui.BaseViewHolder;
import com.hvt.hbapplication.ui.home.adapter.TopAdapter;
import com.hvt.hbapplication.model.EthnicCommunity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

/**
 * Created by Admin on 27-Jun-17.
 */

public class TopEthnicViewHolder extends BaseViewHolder<ArrayList<EthnicCommunity>> {

    @BindView(R.id.vp_top)
    public ViewPager vpEthnic;

    @BindView(R.id.indicator)
    public CircleIndicator indicator;

    public TopAdapter topAdapter;


    public TopEthnicViewHolder(View itemView) {
        super(itemView);
        topAdapter = new TopAdapter();
        vpEthnic.setAdapter(topAdapter);
        indicator.setViewPager(vpEthnic);
    }

    @Override
    public void bindData(ArrayList<EthnicCommunity> data) {
        topAdapter.ethnicCommunities = data;
        topAdapter.notifyDataSetChanged();
    }

    @Override
    public void bindView() {
        ButterKnife.bind(this, itemView);
    }
}

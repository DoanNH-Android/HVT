package com.hvt.hbapplication.ui.home.adapter.viewholder;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.ui.BaseViewHolder;
import com.hvt.hbapplication.ui.home.adapter.GroupAdapter;
import com.hvt.hbapplication.model.GroupEthnicCommunity;
import com.hvt.hbapplication.util.font.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GroupEthnicViewHolder extends BaseViewHolder<GroupEthnicCommunity> {
    @BindView(R.id.tv_title_group)
    public TextView tvGroupName;

    @BindView(R.id.rv_ethnic)
    public RecyclerView rvEthnic;

    public GroupAdapter groupAdapter;

    public GroupEthnicViewHolder(View itemView) {
        super(itemView);
        groupAdapter = new GroupAdapter();
        rvEthnic.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        rvEthnic.setAdapter(groupAdapter);
    }

    @Override
    public void bindData(GroupEthnicCommunity data) {
        StringUtils.setText(tvGroupName, data.groupName);

        groupAdapter.ethnicCommunities.clear();
        groupAdapter.ethnicCommunities.addAll(data.ethnicCommunities);
        groupAdapter.notifyDataSetChanged();
    }

    @Override
    public void bindView() {
        ButterKnife.bind(this, itemView);
    }
}

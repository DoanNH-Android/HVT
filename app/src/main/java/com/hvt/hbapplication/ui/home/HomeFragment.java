package com.hvt.hbapplication.ui.home;


import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hvt.hbapplication.MyApplication;
import com.hvt.hbapplication.R;
import com.hvt.hbapplication.model.GroupEthnicCommunity;
import com.hvt.hbapplication.network.response.EthnicPreview;
import com.hvt.hbapplication.ui.BaseFragment;
import com.hvt.hbapplication.ui.home.adapter.HomeAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends BaseFragment implements HomeView {

    @BindView(R.id.rv_group)
    public RecyclerView rvGroups;

    public HomeAdapter homeAdapter;

    public HomePresenter presenter;

    public HomeFragment() {

    }


    @Override
    public void initView() {
        homeAdapter = new HomeAdapter();
        rvGroups.setLayoutManager(new LinearLayoutManager(getContext()));
        rvGroups.setAdapter(homeAdapter);
    }

    @Override
    public void initData() {
        presenter.loadHomeData();
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    public Unbinder bindingView(View view) {
        return ButterKnife.bind(this, view);
    }

    @Override
    public void displayTopView(List<EthnicPreview> data) {
        homeAdapter.ethnicTop.clear();
        homeAdapter.ethnicTop.addAll(data);
    }

    @Override
    public void displayGroupView(List<GroupEthnicCommunity> data) {
        homeAdapter.groups.clear();
        homeAdapter.groups.addAll(data);
        homeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (presenter == null) {
            presenter = new HomePresenter(MyApplication.getApplication().getApiClient());
        }
        presenter.onAttach(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (presenter != null) {
            presenter.onDetach();
        }
    }

    @Override
    public void onRefresh() {
        presenter.loadHomeData();
    }
}

package com.hvt.hbapplication.ui.home;


import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.ui.BaseFragment;
import com.hvt.hbapplication.ui.home.adapter.HomeAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.rv_group)
    public RecyclerView rvGroups;

    public HomeAdapter homeAdapter;

    public HomeFragment() {

    }


    @Override
    public void initView() {
        homeAdapter = new HomeAdapter();
        rvGroups.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_home;
    }

    @Override
    public Unbinder bindingView(View view) {
        return ButterKnife.bind(this, view);
    }

}

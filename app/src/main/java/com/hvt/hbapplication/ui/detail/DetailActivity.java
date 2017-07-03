package com.hvt.hbapplication.ui.detail;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.ui.BaseActivity;
import com.hvt.hbapplication.model.EthnicCommunity;

import butterknife.BindView;

public class DetailActivity extends BaseActivity implements DetailView {

    private static final String DATA_ETHNIC = "data_ethnic";
    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    @BindView(R.id.ivCover)
    public ImageView ivCover;

    @BindView(R.id.collapsingToolbarLayout)
    public CollapsingToolbarLayout collapsingToolbarLayout;

    DetailPresenter presenter;

    public EthnicCommunity ethnicData;

    public static void navigate(Activity activity, EthnicCommunity ethnicCommunity) {
        Intent intent = new Intent(activity, DetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(DATA_ETHNIC, ethnicCommunity);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    @Override
    public void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.TRANSPARENT);
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);
    }

    @Override
    public void initData() {
        ethnicData = getIntent().getExtras().getParcelable(DATA_ETHNIC);
        loadEthnicData(ethnicData);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_detail;
    }


    @Override
    public void loadEthnicData(EthnicCommunity ethnicCommunity) {
        //TODO: show info of ethnic

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter == null) {
            presenter = new DetailPresenter(null);
        }
        presenter.onAttach(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (presenter != null) {
            presenter.onDetach();
        }
    }

}

package com.hvt.hbapplication.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hvt.hbapplication.MyApplication;
import com.hvt.hbapplication.R;
import com.hvt.hbapplication.model.EthnicCommunity;
import com.hvt.hbapplication.model.FeatureTranslation;
import com.hvt.hbapplication.ui.BaseActivity;
import com.hvt.hbapplication.ui.detail.adapter.FeatureAdapter;
import com.hvt.hbapplication.util.font.StringUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class DetailActivity extends BaseActivity implements DetailView {

    private static final String DATA_ETHNIC = "data_ethnic";

    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    @BindView(R.id.ivCover)
    public ImageView ivCover;

    @BindView(R.id.collapsingToolbarLayout)
    public CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.tv_ethnic_name)
    public TextView tvFolkName;

    @BindView(R.id.tv_population)
    public TextView tvPopulation;

    @BindView(R.id.tv_resident_area)
    public TextView tvResidentArea;

    @BindView(R.id.tv_introduction)
    public TextView tvIntroduction;

    @BindView(R.id.fab_bookmark)
    public FloatingActionButton fabBookmark;

    @BindView(R.id.rv_more)
    public RecyclerView rvFeature;

    public FeatureAdapter featureAdapter;

    DetailPresenter presenter;

    public static void navigate(Context activity, int id) {
        Intent intent = new Intent(activity, DetailActivity.class);
        intent.putExtra(DATA_ETHNIC, id);
        activity.startActivity(intent);
    }

    @Override
    public void initView() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.TRANSPARENT);
        collapsingToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);

        featureAdapter = new FeatureAdapter();
        rvFeature.setLayoutManager(new LinearLayoutManager(this));
        rvFeature.setAdapter(featureAdapter);
    }

    @Override
    public void initData() {
        int idEthnic = getIntent().getIntExtra(DATA_ETHNIC, 1);
        presenter.loadEthnicDataByID(idEthnic);
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_detail;
    }


    @Override
    public void displayBasicEthnicData(EthnicCommunity ethnicCommunity) {
        StringUtils.setText(tvFolkName, ethnicCommunity.getFolkTranslation().getName());
        StringUtils.setText(tvPopulation, ethnicCommunity.getFolkTranslation().getPopulation());
        StringUtils.setText(tvResidentArea, ethnicCommunity.getFolkTranslation().getResidenceArea());
        StringUtils.setText(tvIntroduction, ethnicCommunity.getFolkTranslation().getIntroduction());

        Glide.with(this).load(ethnicCommunity.getBackgroundUrl())
                .placeholder(R.drawable.error_holder)
                .error(R.drawable.error_holder)
                .into(ivCover);

    }

    @Override
    public void displayFeatureData(List<FeatureTranslation> featureTranslations) {
        featureAdapter.featureTranslations.clear();
        featureAdapter.featureTranslations.addAll(featureTranslations);
        featureAdapter.notifyDataSetChanged();
    }

    @Override
    public void setStateBookmark(boolean selected) {
        fabBookmark.setSelected(selected);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home)
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }


    @OnClick(R.id.fab_bookmark)
    public void fabBookmarkClickListener() {
        if (fabBookmark.isSelected()) {
            presenter.unSaveEthnicData();
        } else {
            presenter.saveEthnicData();
        }
    }

    @Override
    public void onAttachView() {
        if (presenter == null) {
            presenter = new DetailPresenter(MyApplication.getApplication().getApiClient());
        }
        presenter.onAttach(this);
    }

    @Override
    public void onDetachView() {
        if (presenter != null) {
            presenter.onDetach();
        }
    }
}

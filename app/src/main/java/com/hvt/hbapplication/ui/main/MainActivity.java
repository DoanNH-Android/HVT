package com.hvt.hbapplication.ui.main;

import android.animation.ObjectAnimator;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.ui.BaseActivity;
import com.hvt.hbapplication.ui.main.adapter.PageAdapter;
import com.hvt.hbapplication.ui.search.SearchFragment;
import com.hvt.hbapplication.widget.SlideDisabledViewPager;
import com.roughike.bottombar.BottomBar;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import io.reactivex.subjects.PublishSubject;

public class MainActivity extends BaseActivity implements SearchView.OnQueryTextListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;

    @BindView(R.id.view_pager)
    SlideDisabledViewPager viewPager;

    @BindView(R.id.bottom_bar)
    BottomBar bottomBar;

    @BindView(R.id.searchView)
    SearchView searchView;

    PublishSubject<String> searchObservable = PublishSubject.create();

    PageAdapter adapter = new PageAdapter(getSupportFragmentManager());

    @Override
    public void initView() {
        setSupportActionBar(toolbar);
        toolbar.setTitle(getString(R.string.tab_home));

        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(adapter);
        bottomBar.setOnTabSelectListener(this::onTabReSelected);
        searchView.setOnQueryTextListener(this);
    }

    @Override
    public void initData() {
        searchObservable.debounce(300, TimeUnit.MILLISECONDS).distinctUntilChanged().subscribe(textQuery -> {
            Log.d("searchObservable", textQuery);
            ((SearchFragment) adapter.getItem(1)).queryFolks(textQuery);
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    public void onTabReSelected(int tabId) {
        switch (tabId) {
            case R.id.tab_home:
                changeTab(0);
                toolbar.setTitle(getString(R.string.tab_home));
                changeVisibilitySearchView(false);
                break;
            case R.id.tab_search:
                changeTab(1);
                toolbar.setTitle(getString(R.string.tab_search));
                changeVisibilitySearchView(true);
                break;
            case R.id.tab_bookmark:
                changeTab(2);
                toolbar.setTitle(getString(R.string.tab_bookmark));
                changeVisibilitySearchView(false);
                break;
            case R.id.tab_settings:
                changeTab(3);
                toolbar.setTitle(getString(R.string.tab_setting));
                changeVisibilitySearchView(false);
                break;
        }
    }

    private void changeVisibilitySearchView(boolean isVisibility) {
        if (isVisibility) {
            searchView.setVisibility(View.VISIBLE);
        } else {
            searchView.setVisibility(View.GONE);
        }
    }

    private void changeTab(int position) {
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(viewPager, View.ALPHA, 0, 1);
        alphaAnimation.setDuration(200);
        alphaAnimation.start();
        viewPager.setCurrentItem(position, false);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        searchObservable.onNext(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        searchObservable.onNext(newText);
        return true;
    }
}

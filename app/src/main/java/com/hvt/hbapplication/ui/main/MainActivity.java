package com.hvt.hbapplication.ui.main;

import android.animation.ObjectAnimator;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.ui.BaseActivity;
import com.hvt.hbapplication.ui.main.adapter.PageAdapter;
import com.hvt.hbapplication.widget.SlideDisabledViewPager;
import com.roughike.bottombar.BottomBar;

import butterknife.BindView;

public class MainActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.app_bar_layout)
    AppBarLayout appBarLayout;

    @BindView(R.id.view_pager)
    SlideDisabledViewPager viewPager;

    @BindView(R.id.bottom_bar)
    BottomBar bottomBar;


    @Override
    public void initView() {
        setSupportActionBar(toolbar);

        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(adapter);
        bottomBar.setOnTabSelectListener(this::onTabReSelected);
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    public void onTabReSelected(int tabId) {
        switch (tabId) {
            case R.id.tab_home:
                changeTab(0);
                break;
            case R.id.tab_search:
                changeTab(1);
                break;
            case R.id.tab_bookmark:
                changeTab(2);
                break;
            case R.id.tab_settings:
                changeTab(3);
                break;
        }
    }

    private void changeTab(int position) {
        ObjectAnimator alphaAnimation = ObjectAnimator.ofFloat(viewPager, View.ALPHA, 0, 1);
        alphaAnimation.setDuration(200);
        alphaAnimation.start();
        viewPager.setCurrentItem(position, false);

    }
}

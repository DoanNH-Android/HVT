package com.hvt.hbapplication.ui.main;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.ui.BaseActivity;
import com.roughike.bottombar.BottomBar;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.bottomBar)
    BottomBar bottomBar;


    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }
}

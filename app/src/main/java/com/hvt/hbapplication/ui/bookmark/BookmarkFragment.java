package com.hvt.hbapplication.ui.bookmark;


import android.view.View;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.ui.BaseFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BookmarkFragment extends BaseFragment {


    public BookmarkFragment() {
        // Required empty public constructor
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_bookmark;
    }

    @Override
    public Unbinder bindingView(View view) {
        return ButterKnife.bind(this, view);
    }

}

package com.hvt.hbapplication.ui.home;


import android.support.v4.app.Fragment;
import android.view.View;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.ui.BaseFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {


    public HomeFragment() {

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

package com.hvt.hbapplication.ui.search;


import android.support.v4.app.Fragment;
import android.view.View;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.ui.BaseFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends BaseFragment {


    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_search;
    }

    @Override
    public Unbinder bindingView(View view) {
        return ButterKnife.bind(this, view);
    }

}

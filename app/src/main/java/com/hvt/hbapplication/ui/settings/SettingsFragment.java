package com.hvt.hbapplication.ui.settings;


import android.view.View;
import android.widget.TextView;

import com.aigestudio.wheelpicker.WheelPicker;
import com.hvt.hbapplication.R;
import com.hvt.hbapplication.ui.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class SettingsFragment extends BaseFragment {

    @BindView(R.id.tv_current_language)
    public TextView tvCurrentLanguage;

    @BindView(R.id.wheel_language)
    public WheelPicker wheelLanguage;


    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {
        List<String> languages = new ArrayList<>();
        languages.add(getString(R.string.settings_vietnamese));
        languages.add(getString(R.string.settings_english));

        wheelLanguage.setData(languages);
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_settings;
    }

    @Override
    public Unbinder bindingView(View view) {
        return ButterKnife.bind(this, view);
    }

}

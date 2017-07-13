package com.hvt.hbapplication.ui.settings;


import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.aigestudio.wheelpicker.WheelPicker;
import com.hvt.hbapplication.Constant;
import com.hvt.hbapplication.MyApplication;
import com.hvt.hbapplication.R;
import com.hvt.hbapplication.ui.BaseFragment;
import com.hvt.hbapplication.ui.main.MainActivity;
import com.hvt.hbapplication.util.LocaleHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.subjects.PublishSubject;


public class SettingsFragment extends BaseFragment implements SettingsView {

    @BindView(R.id.tv_current_language)
    public TextView tvCurrentLanguage;

    @BindView(R.id.btn_change_language)
    public Button btnChangeLanguage;

    @BindView(R.id.wheel_language)
    public WheelPicker wheelLanguage;

    public SettingsPresenter presenter;

    PublishSubject<String> observeLanguageChange;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public void initView() {
        updateViewLanguage(MyApplication.getApplication().sharedPref.getString(Constant.LANG, Constant.EN));
    }

    @Override
    public void initData() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_settings;
    }

    @Override
    public Unbinder bindingView(View view) {
        return ButterKnife.bind(this, view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (presenter == null) {
            presenter = new SettingsPresenter(MyApplication.getApplication().getApiClient());
        }
        presenter.onAttach(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (presenter != null) {
            presenter.onDetach();
        }
    }

    @OnClick(R.id.btn_change_language)
    public void buttonChangeLanguageOnClicked() {
        String languageSelected;
        if (wheelLanguage.getCurrentItemPosition() == 1) {
            languageSelected = Constant.VI;
        } else {
            languageSelected = Constant.EN;
        }

        presenter.changeLanguage(languageSelected);
        ((MainActivity) getActivity()).updateViewLanguage(languageSelected);
    }

    @Override
    public void updateViewLanguage(String newLang) {
        Context context = LocaleHelper.setLocale(getContext(), newLang);
        Resources resources = context.getResources();

        tvCurrentLanguage.setText(resources.getString(R.string.settings_choose_language));
        btnChangeLanguage.setText(resources.getString(R.string.settings_button_change_language));
        List<String> languages = new ArrayList<>();
        languages.add(resources.getString(R.string.settings_english));
        languages.add(resources.getString(R.string.settings_vietnamese));

        wheelLanguage.setData(languages);
        wheelLanguage.setSelectedItemPosition(newLang.equalsIgnoreCase(Constant.VI) ? 1 : 0);
    }

    @Override
    public void saveLanguage(String newLang) {
        MyApplication.getApplication().sharedPref.edit().putString(Constant.LANG, newLang).commit();
    }
}

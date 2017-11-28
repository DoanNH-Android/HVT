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

    @OnClick(R.id.btn_change_language)
    public void buttonChangeLanguageOnClicked() {
        String languageSelected = Constant.EN;
        int currentPosition = wheelLanguage.getCurrentItemPosition();
        switch (currentPosition) {
            case 0: {
                languageSelected = Constant.EN;
                break;
            }
            case 1: {
                languageSelected = Constant.VI;
                break;
            }
            case 2: {
                languageSelected = Constant.KO;
                break;
            }
            case 3: {
                languageSelected = Constant.RU;
                break;
            }
            case 4: {
                languageSelected = Constant.ZH;
                break;
            }
            case 5: {
                languageSelected = Constant.FR;
                break;
            }
        }
        presenter.changeLanguage(languageSelected);
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
        languages.add(resources.getString(R.string.settings_korean));
        languages.add(resources.getString(R.string.settings_russian));
        languages.add(resources.getString(R.string.settings_chinese));
        languages.add(resources.getString(R.string.settings_france));

        wheelLanguage.setData(languages);

        int selectedPosition = 0;

        if (newLang.equalsIgnoreCase(Constant.EN)) {
            selectedPosition = 0;
        } else if (newLang.equalsIgnoreCase(Constant.VI)) {
            selectedPosition = 1;
        } else if (newLang.equalsIgnoreCase(Constant.KO)) {
            selectedPosition = 2;
        } else if (newLang.equalsIgnoreCase(Constant.RU)) {
            selectedPosition = 3;
        } else if (newLang.equalsIgnoreCase(Constant.ZH)) {
            selectedPosition = 4;
        } else if (newLang.equalsIgnoreCase(Constant.FR)) {
            selectedPosition = 5;
        }
        wheelLanguage.setSelectedItemPosition(selectedPosition);
    }

    @Override
    public void saveLanguage(String newLang) {
        MyApplication.getApplication().sharedPref.edit().putString(Constant.LANG, newLang).apply();
    }

    @Override
    public void onAttachView() {
        if (presenter == null) {
            presenter = new SettingsPresenter(MyApplication.getApplication().getApiClient());
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

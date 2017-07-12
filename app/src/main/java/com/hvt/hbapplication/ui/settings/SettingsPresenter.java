package com.hvt.hbapplication.ui.settings;

import com.hvt.hbapplication.network.ApiClient;
import com.hvt.hbapplication.ui.BasePresenter;

public class SettingsPresenter extends BasePresenter<SettingsView> {

    public SettingsPresenter(ApiClient apiClient) {
        super(apiClient);
    }

    public void changeLanguage(String language) {
        getView().saveLanguage(language);
        getView().updateViewLanguage(language);
    }
}

package com.hvt.hbapplication.ui.settings;

import com.hvt.hbapplication.ui.BaseView;

public interface SettingsView extends BaseView {
    void updateViewLanguage(String newLang);

    void saveLanguage(String newLang);
}

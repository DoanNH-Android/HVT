package com.hvt.hbapplication.ui;

public interface BaseView {
    void showLoading();

    void hideLoading();

    void showError(String message);

    void hideKeyboard();
}

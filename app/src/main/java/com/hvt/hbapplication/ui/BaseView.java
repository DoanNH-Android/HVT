package com.hvt.hbapplication.ui;

public interface BaseView {
    void showLoading();

    void hideLoading();

    void showError(String message);

    void showError(int message);

    void showToast(String message);

    void showToast(int message);

    void hideKeyboard();

    void onAttachView();

    void onDetachView();
}

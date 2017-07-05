package com.hvt.hbapplication.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment implements BaseView {

    private Unbinder mUnBinder;

    protected BaseActivity parentActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutID(), container, false);
        mUnBinder = bindingView(view);
        initView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            parentActivity = (BaseActivity) context;
        }
    }

    public abstract void initView();

    public abstract void initData();

    public abstract int getLayoutID();

    public abstract Unbinder bindingView(View view);


    @Override
    public void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    @Override
    public void showLoading() {
        parentActivity.showLoading();
    }

    @Override
    public void hideLoading() {
        parentActivity.hideLoading();
    }

    @Override
    public void showError(String message) {
        parentActivity.showError(message);
    }

    @Override
    public void showError(int message) {
        parentActivity.showError(message);
    }

    @Override
    public void hideKeyboard() {
        parentActivity.hideKeyboard();
    }
}

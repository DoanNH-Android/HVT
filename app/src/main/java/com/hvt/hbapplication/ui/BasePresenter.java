package com.hvt.hbapplication.ui;


import com.hvt.hbapplication.data.DataManager;
import com.hvt.hbapplication.network.ApiClient;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<V extends BaseView> {

    protected DataManager dataManager;

    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BasePresenter(ApiClient apiClient) {
        dataManager = new DataManager(apiClient);
    }

    private V baseView;

    public void onAttach(V view) {
        this.baseView = view;
    }

    public void onDetach() {
        compositeDisposable.clear();
        baseView = null;
    }

    public V getView() {
        return baseView;
    }
}

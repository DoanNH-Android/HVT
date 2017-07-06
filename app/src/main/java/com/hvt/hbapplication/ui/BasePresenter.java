package com.hvt.hbapplication.ui;


import com.hvt.hbapplication.data.DataManager;
import com.hvt.hbapplication.network.ApiClient;

public abstract class BasePresenter<V extends BaseView> {

    protected DataManager dataManager;

    public BasePresenter(ApiClient apiClient) {
        dataManager = new DataManager(apiClient);
    }

    private V baseView;

    public void onAttach(V view) {
        this.baseView = view;
    }

    public void onDetach() {
        baseView = null;
    }

    public V getView() {
        return baseView;
    }
}

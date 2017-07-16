package com.hvt.hbapplication.ui.home;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.network.ApiClient;
import com.hvt.hbapplication.ui.BasePresenter;

import java.util.Collections;

import io.reactivex.disposables.Disposable;

public class HomePresenter extends BasePresenter<HomeView> {

    public HomePresenter(ApiClient apiClient) {
        super(apiClient);
    }

    public void loadHomeData() {
        getView().showLoading();
        Disposable disposable = dataManager.getHome()
                .subscribe(homeResponse -> {
            getView().displayTopView(homeResponse.getTop() == null ? Collections.emptyList() : homeResponse.getTop());
            getView().displayGroupView(homeResponse.getGroups() == null ? Collections.emptyList() : homeResponse.getGroups());
            getView().hideLoading();
        }, throwable -> {
            getView().showError(R.string.error_request);
            getView().hideLoading();
        });
        compositeDisposable.add(disposable);
    }
}

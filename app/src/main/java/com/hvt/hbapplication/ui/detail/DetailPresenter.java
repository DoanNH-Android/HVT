package com.hvt.hbapplication.ui.detail;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.network.ApiClient;
import com.hvt.hbapplication.ui.BasePresenter;

public class DetailPresenter extends BasePresenter<DetailView> {
    public DetailPresenter(ApiClient apiClient) {
        super(apiClient);
    }

    public void loadEthnicDataByID(int id) {
        getView().showLoading();
        dataNetworkManager.getEthnicCommunityData(id).subscribe(ethnicCommunity -> {
            getView().displayBasicEthnicData(ethnicCommunity);
            getView().displayFeatureData(ethnicCommunity.getFolkTranslation().getFeatureTranslations());
            getView().hideLoading();
        }, throwable -> {
            getView().showError(R.string.error_request);
            getView().hideLoading();
        });
    }
}

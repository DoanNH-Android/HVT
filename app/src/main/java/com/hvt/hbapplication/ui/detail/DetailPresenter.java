package com.hvt.hbapplication.ui.detail;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.model.EthnicCommunity;
import com.hvt.hbapplication.network.ApiClient;
import com.hvt.hbapplication.ui.BasePresenter;

public class DetailPresenter extends BasePresenter<DetailView> {
    public DetailPresenter(ApiClient apiClient) {
        super(apiClient);
    }

    private EthnicCommunity ethnicCommunity;

    public void loadEthnicDataByID(int id) {
        getView().showLoading();
        dataManager.getEthnicCommunityData(id).subscribe(pair -> {
            boolean folkSaved = pair.second;
            getView().setStateBookmark(folkSaved);

            ethnicCommunity = pair.first;
            getView().displayBasicEthnicData(ethnicCommunity);
            getView().displayFeatureData(ethnicCommunity.getFolkTranslation().getFeatureTranslations());
            getView().hideLoading();
        }, throwable -> {
            getView().showError(R.string.error_request);
            getView().hideLoading();
        });
    }

    public void saveEthnicData() {
        dataManager.bookmarkFolk(ethnicCommunity).subscribe(longResult -> {
            if (longResult > 0) {
                getView().showToast(R.string.detail_save_success);
                getView().setStateBookmark(true);
            } else {
                getView().showToast(R.string.detail_save_failure);
            }
        }, throwable -> getView().showToast(R.string.detail_save_failure));
    }

    public void unSaveEthnicData() {
        dataManager.unBookmarkFolk(ethnicCommunity.getId()).subscribe(longResult -> {
            if (longResult > 0) {
                getView().showToast(R.string.detail_unsave_success);
                getView().setStateBookmark(false);
            } else {
                getView().showToast(R.string.detail_unsave_failure);
            }
        }, throwable -> getView().showToast(R.string.detail_unsave_failure));
    }
}

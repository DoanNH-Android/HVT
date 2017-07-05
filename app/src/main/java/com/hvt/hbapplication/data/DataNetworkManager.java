package com.hvt.hbapplication.data;

import com.hvt.hbapplication.model.EthnicCommunity;
import com.hvt.hbapplication.network.ApiClient;
import com.hvt.hbapplication.network.response.HomeResponse;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DataNetworkManager {

    private ApiClient apiClient;

    public DataNetworkManager(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Single<HomeResponse> getHome() {
        return apiClient.getHome().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Single<EthnicCommunity> getEthnicCommunityData(int id) {
        String currentLocale = ""; //TODO: check current locale, add tab select language and save language to shared preference

        return apiClient.getEthnicCommunityData(id, currentLocale).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}

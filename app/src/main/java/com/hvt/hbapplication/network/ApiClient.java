package com.hvt.hbapplication.network;

import com.hvt.hbapplication.model.EthnicCommunity;
import com.hvt.hbapplication.network.response.HomeResponse;

import io.reactivex.Single;

public interface ApiClient {
    Single<HomeResponse> getHome();

    Single<EthnicCommunity> getEthnicCommunityData(int id);
}

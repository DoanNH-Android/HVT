package com.hvt.hbapplication.network;

import com.hvt.hbapplication.model.EthnicCommunity;
import com.hvt.hbapplication.network.response.HomeResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiClient {

    @GET("/...")
    Single<HomeResponse> getHome();

    @GET("/m_folks/{id}")
    Single<EthnicCommunity> getEthnicCommunityData(@Path("id") int id, @Query("locale") String language);
}

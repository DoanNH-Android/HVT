package com.hvt.hbapplication.network;

import com.hvt.hbapplication.data.model.FolkBookmark;
import com.hvt.hbapplication.model.EthnicCommunity;
import com.hvt.hbapplication.network.response.HomeResponse;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiClient {

    @GET("m_folks")
    Single<HomeResponse> getHome(@Query("locale") String language);

    @GET("m_folks/{id}")
    Single<EthnicCommunity> getEthnicCommunityData(@Path("id") int id, @Query("locale") String language);

    @GET("m_folks")
    Observable<List<FolkBookmark>> queryFolks(@Query("q[name_cont]") String textQuery, @Query("locale") String locale);
}

package com.hvt.hbapplication.data;

import android.support.v4.util.Pair;

import com.activeandroid.query.Select;
import com.hvt.hbapplication.Constant;
import com.hvt.hbapplication.model.EthnicCommunity;
import com.hvt.hbapplication.network.ApiClient;
import com.hvt.hbapplication.network.response.HomeResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DataManager {

    private ApiClient apiClient;

    public DataManager(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public Single<HomeResponse> getHome() {
        return apiClient.getHome().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Pair<EthnicCommunity, Boolean>> getEthnicCommunityData(int id) {
        String currentLocale = Constant.EN; //TODO: check current locale, add tab select language and save language to shared preference

        return apiClient.getEthnicCommunityData(id, currentLocale)
                .map(ethnicCommunity -> new Pair<>(ethnicCommunity, checkFolkSaved(ethnicCommunity)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Long> bookmarkFolk(EthnicCommunity data) {
        return Observable.defer(() -> Observable.just(saveFolk(data))).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Long> unBookmarkFolk(EthnicCommunity data) {
        return Observable.defer(() -> Observable.just(unSaveFolk(data))).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    private Long unSaveFolk(EthnicCommunity data) {
        if (data == null) return Long.valueOf(-1);

        FolkBookmark folkSaved = new Select().from(FolkBookmark.class).where("id_folk = ?", data.getId()).executeSingle();

        if (folkSaved != null) {
            folkSaved.delete();
            return Long.valueOf(1);
        }

        return Long.valueOf(-1);
    }

    private Long saveFolk(EthnicCommunity data) {
        if (data == null) return Long.valueOf(-1);

        int id = data.getId();
        String backgroundUrl = data.getBackgroundUrl();
        String name = data.getFolkTranslation().getName();
        FolkBookmark folkData = new FolkBookmark(id, backgroundUrl, name);
        return folkData.save();
    }

    private boolean checkFolkSaved(EthnicCommunity data) {
        FolkBookmark folkSaved = new Select().from(FolkBookmark.class).where("id_folk = ?", data.getId()).executeSingle();
        if (folkSaved != null) return true;

        return false;
    }
}

package com.hvt.hbapplication.data;

import android.support.v4.util.Pair;

import com.activeandroid.query.Select;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hvt.hbapplication.Constant;
import com.hvt.hbapplication.MyApplication;
import com.hvt.hbapplication.data.model.FolkBookmark;
import com.hvt.hbapplication.model.EthnicCommunity;
import com.hvt.hbapplication.model.FolkPreview;
import com.hvt.hbapplication.network.ApiClient;
import com.hvt.hbapplication.network.response.HomeResponse;
import com.hvt.hbapplication.util.NetworkUtils;

import java.util.ArrayList;
import java.util.List;

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
        String currentLocale = MyApplication.getApplication().sharedPref.getString(Constant.LANG, Constant.EN);
        return apiClient.getHome(currentLocale)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Single<Pair<EthnicCommunity, Boolean>> getEthnicCommunityData(int id) {
        String currentLocale = MyApplication.getApplication().sharedPref.getString(Constant.LANG, Constant.EN);

        if (NetworkUtils.isNetworkAvailable(MyApplication.getApplication())) {
            return apiClient.getEthnicCommunityData(id, currentLocale)
                    .map(ethnicCommunity -> new Pair<>(ethnicCommunity, checkFolkSaved(ethnicCommunity)))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());
        }

        return Single.fromCallable(() -> getOfflineData(id, currentLocale))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<FolkPreview>> queryFolks(String query) {
        String currentLocale = MyApplication.getApplication().sharedPref.getString(Constant.LANG, Constant.EN);
        return apiClient.queryFolks(query, currentLocale)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Long> bookmarkFolk(EthnicCommunity data) {
        return Observable.fromCallable(() -> saveFolk(data))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Long> bookmarkFolk(int id, String url, String name) {
        return Observable.fromCallable(() -> saveFolk(id, url, name))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    public Observable<Long> unBookmarkFolk(int id) {
        return Observable.defer(() -> Observable.just(unSaveFolk(id)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<List<FolkBookmark>> getFolksBookmarked() {
        return Observable.defer(() -> Observable.just(loadFolksBookmarkedFromDB()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private List<FolkBookmark> loadFolksBookmarkedFromDB() {
        return new Select().from(FolkBookmark.class).execute();
    }


    private Long unSaveFolk(int id) {
        FolkBookmark folkSaved = new Select().from(FolkBookmark.class).where("id_folk = ?", id).executeSingle();

        if (folkSaved != null) {
            folkSaved.delete();
            return 1L;
        }

        return 1L;
    }

    private Long saveFolk(EthnicCommunity data) {
        if (data == null) return -1L;

        String currentLocale = MyApplication.getApplication().sharedPref.getString(Constant.LANG, Constant.EN);

        saveOfflineData(data, currentLocale);

        if (currentLocale.equals(Constant.EN)) {
            apiClient.getEthnicCommunityData(data.getId(), Constant.VI)
                    .observeOn(Schedulers.trampoline())
                    .subscribe(ethnicCommunity -> saveOfflineData(ethnicCommunity, Constant.VI));
        } else {
            apiClient.getEthnicCommunityData(data.getId(), Constant.EN)
                    .observeOn(Schedulers.trampoline())
                    .subscribe(ethnicCommunity -> saveOfflineData(ethnicCommunity, Constant.EN));
        }


        int id = data.getId();
        String backgroundUrl = data.getBackgroundUrl();
        String name = data.getFolkTranslation().getName();
        FolkBookmark folkData = new FolkBookmark(id, backgroundUrl, name);
        return folkData.save();
    }

    private Long saveFolk(int id, String background, String name) {
        FolkBookmark folkData = new FolkBookmark(id, background, name);
        return folkData.save();
    }

    private boolean checkFolkSaved(EthnicCommunity data) {
        FolkBookmark folkSaved = new Select().from(FolkBookmark.class).where("id_folk = ?", data.getId()).executeSingle();
        if (folkSaved != null) return true;

        return false;
    }

    private Pair<EthnicCommunity, Boolean> getOfflineData(int id, String currentLocale) {
        ArrayList<EthnicCommunity> dataStored = getOfflineData(currentLocale);
        for (EthnicCommunity ethnicCommunity : dataStored) {
            if (ethnicCommunity.getId() == id) {
                return new Pair<>(ethnicCommunity, true);
            }
        }
        return new Pair<>(null, false);
    }

    private ArrayList<EthnicCommunity> getOfflineData(String locale) {
        String data = MyApplication.getApplication().sharedPref.getString(locale.equals(Constant.EN) ? Constant.DATA_ETHNIC_EN : Constant.DATA_ETHNIC_VI, "[]");
        return new Gson().fromJson(data, new TypeToken<ArrayList<EthnicCommunity>>() {
        }.getType());
    }

    private void saveOfflineData(EthnicCommunity newData, String currentLocale) {
        ArrayList<EthnicCommunity> dataStored = getOfflineData(currentLocale);
        for (EthnicCommunity ethnicCommunity : dataStored) {
            if (ethnicCommunity.getId().equals(newData.getId())) {
                return;
            }
        }
        dataStored.add(newData);
        String data = new Gson().toJson(dataStored);
        MyApplication.getApplication().sharedPref.edit().putString(currentLocale.equals(Constant.EN) ? Constant.DATA_ETHNIC_EN : Constant.DATA_ETHNIC_VI, data).apply();
    }


}

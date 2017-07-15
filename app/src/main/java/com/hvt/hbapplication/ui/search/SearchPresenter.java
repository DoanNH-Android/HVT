package com.hvt.hbapplication.ui.search;

import com.hvt.hbapplication.model.FolkPreview;
import com.hvt.hbapplication.network.ApiClient;
import com.hvt.hbapplication.ui.BasePresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchPresenter extends BasePresenter<SearchView> {

    List<FolkPreview> results = new ArrayList<>();

    public SearchPresenter(ApiClient apiClient) {
        super(apiClient);
    }

    public void queryFolksByName(String textQuery) {
        if (textQuery.isEmpty()) {
            getView().displayEmptyData(true);
            getView().displayFolksResult(Collections.emptyList());
            return;
        }
        dataManager.queryFolks(textQuery).subscribe(results -> {
            this.results = results;
            getView().displayEmptyData(results == null || results.isEmpty());
            getView().displayFolksResult(results);
        });
    }

    public void prepareForNavigateToDetailFolk(int position) {
        if (results != null && position < results.size()) {
            getView().navigateToDetailFolkByID(results.get(position).idFolk);
        }
    }

}

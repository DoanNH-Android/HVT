package com.hvt.hbapplication.ui.search;

import com.hvt.hbapplication.model.EthnicCommunity;
import com.hvt.hbapplication.ui.BaseView;

import java.util.List;


public interface SearchView extends BaseView {
    void displayFolksResult(List<EthnicCommunity> folks);

    void displayEmptyData(boolean show);

    void navigateToDetailFolkByID(int id);
}

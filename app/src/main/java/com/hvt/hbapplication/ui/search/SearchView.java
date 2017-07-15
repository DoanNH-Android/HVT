package com.hvt.hbapplication.ui.search;

import com.hvt.hbapplication.data.model.FolkBookmark;
import com.hvt.hbapplication.ui.BaseView;

import java.util.List;


public interface SearchView extends BaseView {
    void displayFolksResult(List<FolkBookmark> folks);

    void displayEmptyData(boolean show);

    void navigateToDetailFolkByID(int id);
}

package com.hvt.hbapplication.ui.search;

import com.hvt.hbapplication.model.FolkPreview;
import com.hvt.hbapplication.ui.BaseView;

import java.util.List;


public interface SearchView extends BaseView {
    void displayFolksResult(List<FolkPreview> folks);

    void displayEmptyData(boolean show);

    void navigateToDetailFolkByID(int id);
}

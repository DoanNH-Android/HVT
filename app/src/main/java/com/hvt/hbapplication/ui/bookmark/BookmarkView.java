package com.hvt.hbapplication.ui.bookmark;

import com.hvt.hbapplication.data.model.FolkBookmark;
import com.hvt.hbapplication.ui.BaseView;

import java.util.List;


public interface BookmarkView extends BaseView {
    void displayFolksBookmarked(List<FolkBookmark> folkBookmarks);

    void navigateToDetailFolkByID(int id);
}

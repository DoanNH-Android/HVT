package com.hvt.hbapplication.ui.bookmark;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.data.model.FolkBookmark;
import com.hvt.hbapplication.network.ApiClient;
import com.hvt.hbapplication.ui.BasePresenter;

import java.util.Collections;
import java.util.List;

public class BookmarkPresenter extends BasePresenter<BookmarkView> {

    private List<FolkBookmark> folksBookmarked;

    public BookmarkPresenter(ApiClient apiClient) {
        super(apiClient);
    }

    public void loadFolksBookmarked() {
        dataManager.getFolksBookmarked().subscribe(folkBookmarks -> {
            folksBookmarked = folkBookmarks;
            getView().displayFolksBookmarked(folkBookmarks == null ? Collections.emptyList() : folkBookmarks);
        }, throwable -> getView().showError(R.string.bookmark_load_error));
    }

    public void prepareForNavigateToDetailFolk(int position) {
        if (folksBookmarked != null && position < folksBookmarked.size()) {
            getView().navigateToDetailFolkByID(folksBookmarked.get(position).idFolk);
        }
    }

    public void updateFolkBookmarkSaveChange(int position) {
        if (folksBookmarked != null && position < folksBookmarked.size()) {
            FolkBookmark folkBookmarkChange = folksBookmarked.get(position);
            boolean oldState = folkBookmarkChange.isSelected;
            boolean newState = !oldState;
            folkBookmarkChange.isSelected = newState;

            dataManager.unBookmarkFolk(folkBookmarkChange.idFolk).subscribe(result -> {
                //do nothing
            }, throwable -> {
                if (newState) {
                    getView().showError(R.string.detail_save_failure);
                } else {
                    getView().showError(R.string.detail_unsave_failure);
                }
                folkBookmarkChange.isSelected = oldState;
                getView().rollbackItemError(position);
            });
        }
    }
}

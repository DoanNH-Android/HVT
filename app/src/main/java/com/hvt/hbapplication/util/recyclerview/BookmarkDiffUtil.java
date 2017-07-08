package com.hvt.hbapplication.util.recyclerview;


import android.support.v7.util.DiffUtil;

import com.hvt.hbapplication.data.model.FolkBookmark;

import java.util.List;

public class BookmarkDiffUtil extends DiffUtil.Callback {

    private List<FolkBookmark> oldFolks;
    private List<FolkBookmark> newFolks;

    public BookmarkDiffUtil(List<FolkBookmark> oldFolks, List<FolkBookmark> newFolks) {
        this.oldFolks = oldFolks;
        this.newFolks = newFolks;
    }

    @Override
    public int getOldListSize() {
        return oldFolks.size();
    }

    @Override
    public int getNewListSize() {
        return newFolks.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return oldFolks.get(oldItemPosition).idFolk == newFolks.get(newItemPosition).idFolk;
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        FolkBookmark oldBookmark = oldFolks.get(oldItemPosition);
        FolkBookmark newBookmark = newFolks.get(newItemPosition);

        boolean isNameEqual = (oldBookmark.name == null && newBookmark.name == null) || oldBookmark.name.equals(newBookmark.name);
        boolean isUrlEqual = (oldBookmark.backgroundUrl == null && newBookmark.backgroundUrl == null) || oldBookmark.backgroundUrl.equals(newBookmark.backgroundUrl);
        boolean isSelectedEqual = oldBookmark.isSelected == newBookmark.isSelected;

        return isNameEqual
                && isUrlEqual
                && isSelectedEqual;
    }
}

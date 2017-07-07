package com.hvt.hbapplication.ui.bookmark.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.data.model.FolkBookmark;
import com.hvt.hbapplication.ui.bookmark.BaseAdapter;
import com.hvt.hbapplication.ui.bookmark.adapter.viewholder.BookmarkViewHolder;

import java.util.ArrayList;
import java.util.List;


public class BookmarkAdapter extends BaseAdapter<BookmarkViewHolder> {

    private ArrayList<FolkBookmark> folksSaved = new ArrayList<>();

    @Override
    public BookmarkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bookmark, parent, false);
        return new BookmarkViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(BookmarkViewHolder holder, int position) {
        holder.bindData(folksSaved.get(position));
    }

    @Override
    public int getItemCount() {
        return folksSaved.size();
    }

    public void setData(List<FolkBookmark> data) {
        folksSaved.clear();
        folksSaved.addAll(data);
        notifyDataSetChanged();
    }
}

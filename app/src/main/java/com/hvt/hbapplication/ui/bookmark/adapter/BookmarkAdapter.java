package com.hvt.hbapplication.ui.bookmark.adapter;

import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.data.model.FolkBookmark;
import com.hvt.hbapplication.ui.BaseAdapter;
import com.hvt.hbapplication.ui.OnClickItemListener;
import com.hvt.hbapplication.ui.bookmark.adapter.viewholder.BookmarkViewHolder;
import com.hvt.hbapplication.util.recyclerview.BookmarkDiffUtil;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


public class BookmarkAdapter extends BaseAdapter<BookmarkViewHolder> {

    private ArrayList<FolkBookmark> folksSaved = new ArrayList<>();

    private OnClickItemListener starListener;

    @Override
    public BookmarkViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bookmark, parent, false);
        return new BookmarkViewHolder(itemView, listener, starListener);
    }

    @Override
    public void onBindViewHolder(BookmarkViewHolder holder, int position) {
        holder.bindData(folksSaved.get(position));
    }

    @Override
    public int getItemCount() {
        return folksSaved.size();
    }

    public void setBookmarkChangeListener(OnClickItemListener starListener) {
        this.starListener = starListener;
    }

    public void setData(List<FolkBookmark> data) {
        Single.fromCallable(() -> DiffUtil.calculateDiff(new BookmarkDiffUtil(folksSaved, data)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(diffResult -> {
                    folksSaved.clear();
                    folksSaved.addAll(data);
                    diffResult.dispatchUpdatesTo(BookmarkAdapter.this);
                });
    }
}

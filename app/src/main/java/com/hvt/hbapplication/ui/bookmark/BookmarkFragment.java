package com.hvt.hbapplication.ui.bookmark;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.hvt.hbapplication.MyApplication;
import com.hvt.hbapplication.R;
import com.hvt.hbapplication.data.model.FolkBookmark;
import com.hvt.hbapplication.ui.BaseFragment;
import com.hvt.hbapplication.ui.OnClickItemListener;
import com.hvt.hbapplication.ui.bookmark.adapter.BookmarkAdapter;
import com.hvt.hbapplication.ui.detail.DetailActivity;
import com.hvt.hbapplication.ui.main.MainActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class BookmarkFragment extends BaseFragment implements BookmarkView, OnClickItemListener {

    @BindView(R.id.rv_bookmark)
    public RecyclerView rvBookmark;

    @BindView(R.id.layout_empty)
    public LinearLayout layoutEmpty;

    BookmarkPresenter presenter;

    BookmarkAdapter adapter = new BookmarkAdapter();

    public BookmarkFragment() {

    }

    @Override
    public void initView() {
        adapter.setItemClickListener(this);
        adapter.setBookmarkChangeListener(position -> presenter.updateFolkBookmarkSaveChange(position));
        rvBookmark.setLayoutManager(new LinearLayoutManager(getContext()));
        rvBookmark.setAdapter(adapter);
    }

    @Override
    public void initData() {
        presenter.loadFolksBookmarked();
    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_bookmark;
    }

    @Override
    public Unbinder bindingView(View view) {
        return ButterKnife.bind(this, view);
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            presenter.loadFolksBookmarked();
        }
    }

    @Override
    public void displayFolksBookmarked(List<FolkBookmark> folkBookmarks) {
        adapter.setData(folkBookmarks);
    }

    @Override
    public void navigateToDetailFolkByID(int id) {
        DetailActivity.navigate(getContext(), id);
    }

    @Override
    public void rollbackItemError(int position) {
        adapter.notifyItemChanged(position);
    }

    @Override
    public void showEmptyText(boolean show) {
        layoutEmpty.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }

    @OnClick(R.id.btn_explore)
    public void clickExplore() {
        ((MainActivity) getActivity()).moveToHome();
    }

    @Override
    public void onItemClicked(int position) {
        presenter.prepareForNavigateToDetailFolk(position);
    }

    @Override
    public void onAttachView() {
        if (presenter == null) {
            presenter = new BookmarkPresenter(MyApplication.getApplication().getApiClient());
        }
        presenter.onAttach(this);
    }

    @Override
    public void onDetachView() {
        if (presenter != null) {
            presenter.onDetach();
        }
    }
}

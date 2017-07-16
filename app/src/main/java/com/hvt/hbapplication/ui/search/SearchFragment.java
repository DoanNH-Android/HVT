package com.hvt.hbapplication.ui.search;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.hvt.hbapplication.MyApplication;
import com.hvt.hbapplication.R;
import com.hvt.hbapplication.model.FolkPreview;
import com.hvt.hbapplication.ui.BaseFragment;
import com.hvt.hbapplication.ui.OnClickItemListener;
import com.hvt.hbapplication.ui.detail.DetailActivity;
import com.hvt.hbapplication.ui.search.adapter.SearchAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class SearchFragment extends BaseFragment implements SearchView, OnClickItemListener {

    @BindView(R.id.rv_result)
    public RecyclerView rvResult;

    @BindView(R.id.tv_empty_data)
    public TextView tvEmptyData;

    SearchAdapter adapter = new SearchAdapter();

    SearchPresenter presenter;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void initView() {
        adapter.setItemClickListener(this);
        rvResult.setLayoutManager(new LinearLayoutManager(getContext()));
        rvResult.setAdapter(adapter);
    }

    @Override
    public void initData() {

    }

    public void queryFolks(String query) {
        if (presenter != null) {
            presenter.queryFolksByName(query);
        }

    }

    @Override
    public int getLayoutID() {
        return R.layout.fragment_search;
    }

    @Override
    public Unbinder bindingView(View view) {
        return ButterKnife.bind(this, view);
    }

    @Override
    public void displayFolksResult(List<FolkPreview> folks) {
        adapter.setData(folks);
    }

    @Override
    public void displayEmptyData(boolean show) {
        tvEmptyData.setVisibility(show ? View.VISIBLE : View.INVISIBLE);
    }

    @Override
    public void navigateToDetailFolkByID(int id) {
        DetailActivity.navigate(getContext(), id);
    }

    @Override
    public void onItemClicked(int position) {
        presenter.prepareForNavigateToDetailFolk(position);
    }

    @Override
    public void onAttachView() {
        if (presenter == null) {
            presenter = new SearchPresenter(MyApplication.getApplication().getApiClient());
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

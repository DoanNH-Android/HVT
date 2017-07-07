package com.hvt.hbapplication.ui.bookmark;

import android.support.v7.widget.RecyclerView;

import com.hvt.hbapplication.ui.BaseViewHolder;
import com.hvt.hbapplication.ui.OnClickItemListener;

/**
 * Created by Hado on 7/7/17.
 */

public abstract class BaseAdapter<VH extends BaseViewHolder<?>> extends RecyclerView.Adapter<VH> {
    protected OnClickItemListener listener;

    public BaseAdapter() {

    }

    public BaseAdapter(OnClickItemListener listener) {
        this.listener = listener;
    }

    public void setListener(OnClickItemListener listener) {
        this.listener = listener;
    }
}

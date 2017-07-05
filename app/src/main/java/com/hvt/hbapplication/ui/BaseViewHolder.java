package com.hvt.hbapplication.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
        bindView();
    }

    public abstract void bindData(T data);

    public abstract void bindView();
}

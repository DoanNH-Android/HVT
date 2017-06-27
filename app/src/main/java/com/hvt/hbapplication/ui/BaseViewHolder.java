package com.hvt.hbapplication.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Admin on 27-Jun-17.
 */

public abstract class BaseViewHolder<T> extends RecyclerView.ViewHolder {

    public BaseViewHolder(View itemView) {
        super(itemView);
        bindView();
    }

    public abstract void bindData(T data);

    public abstract void bindView();
}

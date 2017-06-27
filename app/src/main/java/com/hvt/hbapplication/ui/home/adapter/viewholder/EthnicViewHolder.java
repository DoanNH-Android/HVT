package com.hvt.hbapplication.ui.home.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hvt.hbapplication.R;
import com.hvt.hbapplication.ui.BaseViewHolder;
import com.hvt.hbapplication.ui.model.EthnicCommunity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 27-Jun-17.
 */

public class EthnicViewHolder extends BaseViewHolder<EthnicCommunity> {

    @BindView(R.id.tv_title_name)
    public TextView tvEthnicName;

    @BindView(R.id.iv_flag)
    public ImageView ivEthnic;

    public EthnicViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(EthnicCommunity data) {

    }

    @Override
    public void bindView() {
        ButterKnife.bind(this, itemView);
    }
}

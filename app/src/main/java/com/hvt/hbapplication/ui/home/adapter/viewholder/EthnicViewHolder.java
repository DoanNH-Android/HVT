package com.hvt.hbapplication.ui.home.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hvt.hbapplication.R;
import com.hvt.hbapplication.network.response.EthnicPreview;
import com.hvt.hbapplication.ui.BaseViewHolder;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EthnicViewHolder extends BaseViewHolder<EthnicPreview> {

    @BindView(R.id.tv_title_name)
    public TextView tvEthnicName;

    @BindView(R.id.iv_flag)
    public ImageView ivEthnic;

    public EthnicViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void bindData(EthnicPreview data) {
        tvEthnicName.setText(data.getName() == null ? "" : data.getName());
        Glide.with(itemView.getContext()).load(data.getBackgroundUrl()).into(ivEthnic);
    }

    @Override
    public void bindView() {
        ButterKnife.bind(this, itemView);
    }
}

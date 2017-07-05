package com.hvt.hbapplication.ui.home.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hvt.hbapplication.R;
import com.hvt.hbapplication.network.response.EthnicPreview;
import com.hvt.hbapplication.ui.BaseViewHolder;
import com.hvt.hbapplication.ui.detail.DetailActivity;
import com.hvt.hbapplication.util.font.StringUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EthnicViewHolder extends BaseViewHolder<EthnicPreview> {

    @BindView(R.id.tv_title_name)
    public TextView tvEthnicName;

    @BindView(R.id.iv_flag)
    public ImageView ivEthnic;

    int idEthnic = 1;

    public EthnicViewHolder(View itemView) {
        super(itemView);
        this.itemView.setOnClickListener(view -> DetailActivity.navigate(EthnicViewHolder.this.itemView.getContext(), idEthnic));
    }

    @Override
    public void bindData(EthnicPreview data) {
        idEthnic = data.getId();
        StringUtils.setText(tvEthnicName, data.getName());
        Glide.with(itemView.getContext()).load(data.getBackgroundUrl())
                .placeholder(R.drawable.error_holder)
                .error(R.drawable.error_holder)
                .into(ivEthnic);
    }

    @Override
    public void bindView() {
        ButterKnife.bind(this, itemView);
    }
}

package com.hvt.hbapplication.ui.home;

import com.hvt.hbapplication.model.GroupEthnicCommunity;
import com.hvt.hbapplication.network.response.EthnicPreview;
import com.hvt.hbapplication.ui.BaseView;

import java.util.List;

public interface HomeView extends BaseView {
    void displayTopView(List<EthnicPreview> data);

    void displayGroupView(List<GroupEthnicCommunity> data);
}

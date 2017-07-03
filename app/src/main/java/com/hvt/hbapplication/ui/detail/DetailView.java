package com.hvt.hbapplication.ui.detail;

import com.hvt.hbapplication.ui.BaseView;
import com.hvt.hbapplication.model.EthnicCommunity;

/**
 * Created by Admin on 27-Jun-17.
 */

public interface DetailView extends BaseView {
    void loadEthnicData(EthnicCommunity ethnicCommunity);
}

package com.hvt.hbapplication.ui.detail;

import com.hvt.hbapplication.model.FeatureTranslation;
import com.hvt.hbapplication.ui.BaseView;
import com.hvt.hbapplication.model.EthnicCommunity;

import java.util.List;


public interface DetailView extends BaseView {
    void displayBasicEthnicData(EthnicCommunity ethnicCommunity);

    void displayFeatureData(List<FeatureTranslation> featureTranslations);

    void setStateBookmark(boolean selected);
}

package com.hvt.hbapplication.ui.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 27-Jun-17.
 */

public class EthnicCommunity implements Parcelable {

    protected EthnicCommunity(Parcel in) {
    }

    public static final Creator<EthnicCommunity> CREATOR = new Creator<EthnicCommunity>() {
        @Override
        public EthnicCommunity createFromParcel(Parcel in) {
            return new EthnicCommunity(in);
        }

        @Override
        public EthnicCommunity[] newArray(int size) {
            return new EthnicCommunity[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}

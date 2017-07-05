package com.hvt.hbapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.hvt.hbapplication.network.response.EthnicPreview;

import java.util.ArrayList;

public class GroupEthnicCommunity implements Parcelable {
    @SerializedName("group_name")
    public String groupName;

    @SerializedName("")
    public ArrayList<EthnicPreview> ethnicCommunities;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.groupName);
        dest.writeTypedList(this.ethnicCommunities);
    }

    public GroupEthnicCommunity() {
    }

    protected GroupEthnicCommunity(Parcel in) {
        this.groupName = in.readString();
        this.ethnicCommunities = in.createTypedArrayList(EthnicPreview.CREATOR);
    }

    public static final Parcelable.Creator<GroupEthnicCommunity> CREATOR = new Parcelable.Creator<GroupEthnicCommunity>() {
        @Override
        public GroupEthnicCommunity createFromParcel(Parcel source) {
            return new GroupEthnicCommunity(source);
        }

        @Override
        public GroupEthnicCommunity[] newArray(int size) {
            return new GroupEthnicCommunity[size];
        }
    };
}

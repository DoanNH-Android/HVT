package com.hvt.hbapplication.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;
import com.hvt.hbapplication.model.GroupEthnicCommunity;

import java.util.ArrayList;
import java.util.List;

public class HomeResponse implements Parcelable {

    @SerializedName("top")
    private List<EthnicPreview> top;

    @SerializedName("groups")
    private List<GroupEthnicCommunity> groups;


    public List<EthnicPreview> getTop() {
        return top;
    }

    public void setTop(List<EthnicPreview> top) {
        this.top = top;
    }

    public List<GroupEthnicCommunity> getGroups() {
        return groups;
    }

    public void setGroups(List<GroupEthnicCommunity> groups) {
        this.groups = groups;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.top);
        dest.writeList(this.groups);
    }

    public HomeResponse() {
    }

    protected HomeResponse(Parcel in) {
        this.top = in.createTypedArrayList(EthnicPreview.CREATOR);
        this.groups = new ArrayList<GroupEthnicCommunity>();
        in.readList(this.groups, GroupEthnicCommunity.class.getClassLoader());
    }

    public static final Creator<HomeResponse> CREATOR = new Creator<HomeResponse>() {
        @Override
        public HomeResponse createFromParcel(Parcel source) {
            return new HomeResponse(source);
        }

        @Override
        public HomeResponse[] newArray(int size) {
            return new HomeResponse[size];
        }
    };
}

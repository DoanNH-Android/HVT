package com.hvt.hbapplication.network.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class EthnicPreview implements Parcelable {

    @SerializedName("id")
    private Integer id;

    @SerializedName("background_url")
    private String backgroundUrl;

    @SerializedName("name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.backgroundUrl);
        dest.writeString(this.name);
    }

    public EthnicPreview() {
    }

    protected EthnicPreview(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.backgroundUrl = in.readString();
        this.name = in.readString();
    }

    public static final Parcelable.Creator<EthnicPreview> CREATOR = new Parcelable.Creator<EthnicPreview>() {
        @Override
        public EthnicPreview createFromParcel(Parcel source) {
            return new EthnicPreview(source);
        }

        @Override
        public EthnicPreview[] newArray(int size) {
            return new EthnicPreview[size];
        }
    };
}

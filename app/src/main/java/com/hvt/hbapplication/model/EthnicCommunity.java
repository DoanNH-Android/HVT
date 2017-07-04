package com.hvt.hbapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Admin on 27-Jun-17.
 */

public class EthnicCommunity implements Parcelable {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("teaser_url")
    @Expose
    private String teaserUrl;
    @SerializedName("background_url")
    @Expose
    private String backgroundUrl;
    @SerializedName("folk_translation")
    @Expose
    private FolkTranslation folkTranslation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeaserUrl() {
        return teaserUrl;
    }

    public void setTeaserUrl(String teaserUrl) {
        this.teaserUrl = teaserUrl;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }

    public FolkTranslation getFolkTranslation() {
        return folkTranslation;
    }

    public void setFolkTranslation(FolkTranslation folkTranslation) {
        this.folkTranslation = folkTranslation;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.teaserUrl);
        dest.writeString(this.backgroundUrl);
        dest.writeParcelable(this.folkTranslation, flags);
    }

    public EthnicCommunity() {
    }

    protected EthnicCommunity(Parcel in) {
        this.id = (Integer) in.readValue(Integer.class.getClassLoader());
        this.teaserUrl = in.readString();
        this.backgroundUrl = in.readString();
        this.folkTranslation = in.readParcelable(FolkTranslation.class.getClassLoader());
    }

    public static final Creator<EthnicCommunity> CREATOR = new Creator<EthnicCommunity>() {
        @Override
        public EthnicCommunity createFromParcel(Parcel source) {
            return new EthnicCommunity(source);
        }

        @Override
        public EthnicCommunity[] newArray(int size) {
            return new EthnicCommunity[size];
        }
    };
}

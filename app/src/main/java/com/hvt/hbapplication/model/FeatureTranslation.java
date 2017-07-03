package com.hvt.hbapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Admin on 03-Jul-17.
 */

public class FeatureTranslation implements Parcelable {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("feature_type")
    @Expose
    private String featureType;
    @SerializedName("images")
    @Expose
    private List<Image> images = null;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFeatureType() {
        return featureType;
    }

    public void setFeatureType(String featureType) {
        this.featureType = featureType;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.description);
        dest.writeString(this.featureType);
        dest.writeTypedList(this.images);
    }

    public FeatureTranslation() {
    }

    protected FeatureTranslation(Parcel in) {
        this.description = in.readString();
        this.featureType = in.readString();
        this.images = in.createTypedArrayList(Image.CREATOR);
    }

    public static final Creator<FeatureTranslation> CREATOR = new Creator<FeatureTranslation>() {
        @Override
        public FeatureTranslation createFromParcel(Parcel source) {
            return new FeatureTranslation(source);
        }

        @Override
        public FeatureTranslation[] newArray(int size) {
            return new FeatureTranslation[size];
        }
    };
}

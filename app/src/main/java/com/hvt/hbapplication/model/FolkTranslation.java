package com.hvt.hbapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Hado on 7/4/17.
 */

class FolkTranslation implements Parcelable {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("introduction")
    @Expose
    private String introduction;
    @SerializedName("population")
    @Expose
    private String population;
    @SerializedName("residence_area")
    @Expose
    private String residenceArea;
    @SerializedName("community_organization")
    @Expose
    private String communityOrganization;
    @SerializedName("feature_translations")
    @Expose
    private List<FeatureTranslation> featureTranslations = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getResidenceArea() {
        return residenceArea;
    }

    public void setResidenceArea(String residenceArea) {
        this.residenceArea = residenceArea;
    }

    public String getCommunityOrganization() {
        return communityOrganization;
    }

    public void setCommunityOrganization(String communityOrganization) {
        this.communityOrganization = communityOrganization;
    }

    public List<FeatureTranslation> getFeatureTranslations() {
        return featureTranslations;
    }

    public void setFeatureTranslations(List<FeatureTranslation> featureTranslations) {
        this.featureTranslations = featureTranslations;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.introduction);
        dest.writeString(this.population);
        dest.writeString(this.residenceArea);
        dest.writeString(this.communityOrganization);
        dest.writeTypedList(this.featureTranslations);
    }

    public FolkTranslation() {
    }

    protected FolkTranslation(Parcel in) {
        this.name = in.readString();
        this.introduction = in.readString();
        this.population = in.readString();
        this.residenceArea = in.readString();
        this.communityOrganization = in.readString();
        this.featureTranslations = in.createTypedArrayList(FeatureTranslation.CREATOR);
    }

    public static final Creator<FolkTranslation> CREATOR = new Creator<FolkTranslation>() {
        @Override
        public FolkTranslation createFromParcel(Parcel source) {
            return new FolkTranslation(source);
        }

        @Override
        public FolkTranslation[] newArray(int size) {
            return new FolkTranslation[size];
        }
    };
}

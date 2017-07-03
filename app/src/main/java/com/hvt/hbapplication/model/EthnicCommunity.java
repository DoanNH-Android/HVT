package com.hvt.hbapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 27-Jun-17.
 */

public class EthnicCommunity implements Parcelable {

    @SerializedName("teaser_url")
    @Expose
    private String teaserUrl;
    @SerializedName("background_url")
    @Expose
    private String backgroundUrl;
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
        dest.writeString(this.teaserUrl);
        dest.writeString(this.backgroundUrl);
        dest.writeString(this.name);
        dest.writeString(this.introduction);
        dest.writeString(this.population);
        dest.writeString(this.residenceArea);
        dest.writeString(this.communityOrganization);
        dest.writeList(this.featureTranslations);
    }

    public EthnicCommunity() {
    }

    protected EthnicCommunity(Parcel in) {
        this.teaserUrl = in.readString();
        this.backgroundUrl = in.readString();
        this.name = in.readString();
        this.introduction = in.readString();
        this.population = in.readString();
        this.residenceArea = in.readString();
        this.communityOrganization = in.readString();
        this.featureTranslations = new ArrayList<FeatureTranslation>();
        in.readList(this.featureTranslations, FeatureTranslation.class.getClassLoader());
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

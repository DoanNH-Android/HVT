package com.hvt.hbapplication.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Hado on 7/6/17.
 */

@Table(name = "FolkBookmark")
public class FolkBookmark extends Model implements Parcelable {
    public FolkBookmark() {
    }

    public FolkBookmark(@NonNull int idFolk, @NonNull String backgroundUrl, String name) {
        this.idFolk = idFolk;
        this.backgroundUrl = backgroundUrl;
        this.name = name == null ? "" : name;
    }

    @Column(name = "id_folk")
    @SerializedName("id")
    @Expose
    public int idFolk;

    @Column(name = "background_url")
    @SerializedName("background_url")
    @Expose
    public String backgroundUrl;

    @Column(name = "name")
    @SerializedName("name")
    @Expose
    public String name;

    public boolean isSelected = true;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.idFolk);
        dest.writeString(this.backgroundUrl);
        dest.writeString(this.name);
        dest.writeByte(this.isSelected ? (byte) 1 : (byte) 0);
    }

    protected FolkBookmark(Parcel in) {
        this.idFolk = in.readInt();
        this.backgroundUrl = in.readString();
        this.name = in.readString();
        this.isSelected = in.readByte() != 0;
    }

    public static final Creator<FolkBookmark> CREATOR = new Creator<FolkBookmark>() {
        @Override
        public FolkBookmark createFromParcel(Parcel source) {
            return new FolkBookmark(source);
        }

        @Override
        public FolkBookmark[] newArray(int size) {
            return new FolkBookmark[size];
        }
    };
}

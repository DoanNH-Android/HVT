package com.hvt.hbapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Hado on 7/15/17.
 */

public class FolkPreview {
    @SerializedName("id")
    @Expose
    public int idFolk;

    @SerializedName("background_url")
    @Expose
    public String backgroundUrl;

    @SerializedName("name")
    @Expose
    public String name;
}

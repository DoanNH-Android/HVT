package com.hvt.hbapplication.data;

import android.support.annotation.NonNull;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by Hado on 7/6/17.
 */

@Table(name = "FolkBookmark")
public class FolkBookmark extends Model {
    public FolkBookmark() {
    }

    public FolkBookmark(@NonNull int id, @NonNull String backgroundUrl, String name) {
        this.id = id;
        this.backgroundUrl = backgroundUrl;
        this.name = name == null ? "" : name;
    }

    @Column(name = "id_folk")
    public int id;

    @Column(name = "background_url")
    public String backgroundUrl;

    @Column(name = "name")
    public String name;
}

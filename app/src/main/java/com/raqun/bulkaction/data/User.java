package com.raqun.bulkaction.data;

import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * Created by tyln on 24/04/2017.
 */

public final class User {
    @NonNull
    private final String token;

    @SerializedName("id")
    private String id;

    @SerializedName("username")
    private String userName;

    @SerializedName("full_name")
    private String fullName;

    @SerializedName("profile_picture")
    private String profilePictureUrl;

    @SerializedName("bio")
    private String bio;

    @SerializedName("website")
    private String webSite;

    @SerializedName("counts")
    private Counts counts;

    public User(@NonNull String token) {
        this.token = token;
    }

    @NonNull
    public String getToken() {
        return token;
    }

    public String getUserName() {
        return userName;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public String getBio() {
        return bio;
    }

    public String getWebSite() {
        return webSite;
    }

    public Counts getCounts() {
        return counts;
    }
}

package com.raqun.bulkaction.data;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

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
}

package com.raqun.bulkaction.data;

import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

/**
 * Created by tyln on 24/04/2017.
 */

public final class User {
    @NonNull
    private final String token;

    public User(@NonNull String token) {
        this.token = token;
    }

    @NonNull
    public String getToken() {
        return token;
    }
}

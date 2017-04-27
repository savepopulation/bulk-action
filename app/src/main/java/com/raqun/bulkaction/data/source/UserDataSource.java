package com.raqun.bulkaction.data.source;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.data.User;

import io.reactivex.Observable;

/**
 * Created by tyln on 24/04/2017.
 */

public interface UserDataSource {
    void saveUser(@NonNull User user);

    Observable<User> getUser(@NonNull String token);
}

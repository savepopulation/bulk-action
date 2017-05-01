package com.raqun.bulkaction.data.source;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.data.User;

import io.reactivex.Observable;
import io.reactivex.Single;

/**
 * Created by tyln on 24/04/2017.
 */

public interface UserDataSource {
    User initUser();

    void saveUser(@NonNull User user);

    Single<User> getUser();
}

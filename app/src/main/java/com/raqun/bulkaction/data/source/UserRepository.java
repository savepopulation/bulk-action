package com.raqun.bulkaction.data.source;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.raqun.bulkaction.data.User;
import com.raqun.bulkaction.data.source.UserDataSource;
import com.raqun.bulkaction.data.source.local.UserLocalDataSource;
import com.raqun.bulkaction.data.source.remote.UserRemoteDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by tyln on 24/04/2017.
 */

@Singleton
public final class UserRepository implements UserDataSource {
    @NonNull
    private final UserLocalDataSource mUserLocalDataSource;

    @NonNull
    private final UserRemoteDataSource mUserRemoteDataSource;

    @Nullable
    private User mCurrentUser;

    @Inject
    UserRepository(@NonNull @Local UserLocalDataSource userLocalDataSource,
                   @NonNull @Remote UserRemoteDataSource userRemoteDataSource) {
        this.mUserLocalDataSource = userLocalDataSource;
        this.mUserRemoteDataSource = userRemoteDataSource;
    }

    @Override
    public void saveUser(@NonNull User user) {
        if (user == null) {
            return;
        }

        this.mCurrentUser = user;
        mUserLocalDataSource.saveUser(user);
    }

    public void login(@NonNull User user) {
        saveUser(user);
    }

    public void setCurrentUser(@NonNull User user) {
        this.mCurrentUser = user;
    }

    public void clearCurrentUserCache() {
        this.mCurrentUser = null;
    }
}

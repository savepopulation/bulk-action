package com.raqun.bulkaction.data.source.remote;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.raqun.bulkaction.data.User;
import com.raqun.bulkaction.data.api.BulkActionServices;
import com.raqun.bulkaction.data.source.UserDataSource;
import com.raqun.bulkaction.data.bean.UserResponseBean;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.functions.Function;

/**
 * Created by tyln on 24/04/2017.
 */
@Singleton
public final class UserRemoteDataSource implements UserDataSource {
    @NonNull
    private final BulkActionServices mBulkActionServices;

    @Inject
    public UserRemoteDataSource(@NonNull BulkActionServices bulkActionServices) {
        this.mBulkActionServices = bulkActionServices;
    }

    @Override
    @Nullable
    public User initUser() {
        return null;
    }

    @Override
    public void saveUser(@NonNull User user) {
        // Empty method
    }

    @Override
    public Single<User> getUser() {
        return mBulkActionServices.getUser().map(UserResponseBean::getUser);
    }
}

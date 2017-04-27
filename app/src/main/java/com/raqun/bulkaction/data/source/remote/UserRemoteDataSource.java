package com.raqun.bulkaction.data.source.remote;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.data.User;
import com.raqun.bulkaction.data.api.BulkActionServices;
import com.raqun.bulkaction.data.source.UserDataSource;
import com.raqun.bulkaction.data.bean.UserWrapper;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
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
    public void saveUser(@NonNull User user) {

    }

    @Override
    public Observable<User> getUser(@NonNull String token) {
        return mBulkActionServices.getUser(token)
                .map(new Function<UserWrapper, User>() {
                    @Override
                    public User apply(UserWrapper userWrapper) throws Exception {
                        return userWrapper.user;
                    }
                });
    }
}

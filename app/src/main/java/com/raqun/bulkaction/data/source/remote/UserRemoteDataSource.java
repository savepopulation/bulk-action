package com.raqun.bulkaction.data.source.remote;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.data.User;
import com.raqun.bulkaction.data.api.BulkActionServices;
import com.raqun.bulkaction.data.source.UserDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

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
}

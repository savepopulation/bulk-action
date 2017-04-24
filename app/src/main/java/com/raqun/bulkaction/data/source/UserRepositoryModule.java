package com.raqun.bulkaction.data.source;

import android.content.Context;
import android.support.annotation.NonNull;

import com.raqun.bulkaction.data.api.BulkActionServices;
import com.raqun.bulkaction.data.source.local.UserLocalDataSource;
import com.raqun.bulkaction.data.source.remote.UserRemoteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tyln on 24/04/2017.
 */

@Module
public class UserRepositoryModule {
    public UserRepositoryModule() {
        // Empty public constructor
    }

    @Singleton
    @Provides
    @Local
    @NonNull
    UserLocalDataSource provideUserLocalDataSource(@NonNull Context context) {
        return new UserLocalDataSource(context);
    }

    @Singleton
    @Provides
    @Remote
    UserRemoteDataSource provideUserRemoteDataSource(@NonNull BulkActionServices bulkActionServices) {
        return new UserRemoteDataSource(bulkActionServices);
    }
}

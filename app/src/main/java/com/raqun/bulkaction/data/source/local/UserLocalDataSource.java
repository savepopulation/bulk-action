package com.raqun.bulkaction.data.source.local;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;

import com.raqun.bulkaction.data.User;
import com.raqun.bulkaction.data.source.UserDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


/**
 * Created by tyln on 24/04/2017.
 */

@Singleton
public class UserLocalDataSource implements UserDataSource {
    @NonNull
    private final Context mApplicationContext;

    @Inject
    public UserLocalDataSource(@NonNull Context context) {
        this.mApplicationContext = context;
    }

    @WorkerThread
    @Override
    public void saveUser(@NonNull User user) {
        // Empty method
    }

    @Override
    public Observable<User> getUser(@NonNull String token) {
        return null;
    }
}

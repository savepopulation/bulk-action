package com.raqun.bulkaction.data.source.local;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.annotation.WorkerThread;

import com.google.gson.Gson;
import com.raqun.bulkaction.data.User;
import com.raqun.bulkaction.data.source.UserDataSource;
import com.raqun.bulkaction.util.SharedPrefUtil;
import com.raqun.bulkaction.util.ValidationUtil;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;


/**
 * Created by tyln on 24/04/2017.
 */

@Singleton
public class UserLocalDataSource implements UserDataSource {
    private static final String PREF_KEY_USER = "user";

    @NonNull
    private final Context mApplicationContext;

    @Inject
    public UserLocalDataSource(@NonNull Context context) {
        this.mApplicationContext = context;
    }

    @Override
    @Nullable
    public User initUser() {
        final String userJson = SharedPrefUtil.get(mApplicationContext, PREF_KEY_USER, null);
        User user = null;
        if (!ValidationUtil.isNullOrEmpty(userJson)) {
            user = new Gson().fromJson(userJson, User.class);
        }
        return user;
    }

    @WorkerThread
    @Override
    public void saveUser(@NonNull User user) {
        SharedPrefUtil.put(mApplicationContext, PREF_KEY_USER, new Gson().toJson(user));
    }

    @Override
    public Single<User> getUser() {
        return Single.create(e -> {
            e.onSuccess(initUser());
        });
    }
}

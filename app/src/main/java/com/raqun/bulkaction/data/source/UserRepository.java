package com.raqun.bulkaction.data.source;

import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.raqun.bulkaction.data.User;
import com.raqun.bulkaction.data.source.UserDataSource;
import com.raqun.bulkaction.data.source.local.UserLocalDataSource;
import com.raqun.bulkaction.data.source.remote.UserRemoteDataSource;

import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.SubscriberCompletableObserver;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;


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
    private static volatile User mCurrentUser;

    @Inject
    UserRepository(@NonNull @Local UserLocalDataSource userLocalDataSource,
                   @NonNull @Remote UserRemoteDataSource userRemoteDataSource) {
        this.mUserLocalDataSource = userLocalDataSource;
        this.mUserRemoteDataSource = userRemoteDataSource;
        mCurrentUser = initUser();
    }

    @Override
    public void saveUser(@NonNull User user) {
        if (user == null) {
            return;
        }

        mCurrentUser = user;
        mUserLocalDataSource.saveUser(user);
    }

    @Override
    public Single<User> getUser() {
        return mUserRemoteDataSource.getUser();
    }

    public void login(@NonNull User user) {
        saveUser(user);
    }

    @Nullable
    public static User getCurrentUser() {
        return mCurrentUser;
    }

    @Override
    @Nullable
    public User initUser() {
        return mUserLocalDataSource.initUser();
    }
}

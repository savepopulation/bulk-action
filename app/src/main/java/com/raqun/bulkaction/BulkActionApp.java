package com.raqun.bulkaction;

import android.app.Application;
import android.support.annotation.NonNull;

import com.raqun.bulkaction.data.BulkAction;
import com.raqun.bulkaction.data.api.ApiModule;
import com.raqun.bulkaction.data.factory.BulkActionFactory;
import com.raqun.bulkaction.data.source.DaggerUserRepositoryComponent;
import com.raqun.bulkaction.data.source.UserRepository;
import com.raqun.bulkaction.data.source.UserRepositoryComponent;
import com.raqun.bulkaction.data.source.UserRepositoryModule;
import com.squareup.leakcanary.LeakCanary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyln on 15/04/2017.
 */

public final class BulkActionApp extends Application {
    @NonNull
    private UserRepositoryComponent mUserRepositoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        init();
    }

    private void init() {
        mUserRepositoryComponent = DaggerUserRepositoryComponent.builder()
                .applicationModule(new ApplicationModule(getApplicationContext()))
                .userRepositoryModule(new UserRepositoryModule())
                .apiModule(new ApiModule())
                .build();
    }

    @NonNull
    public UserRepositoryComponent getUserRepositoryComponent() {
        return this.mUserRepositoryComponent;
    }
}

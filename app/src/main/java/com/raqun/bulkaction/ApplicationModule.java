package com.raqun.bulkaction;

import android.content.Context;
import android.support.annotation.NonNull;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tyln on 15/04/2017.
 */

@Module
public final class ApplicationModule {
    @NonNull
    private final Context mContext;

    ApplicationModule(@NonNull Context context) {
        this.mContext = context;
    }

    @Provides
    @NonNull
    Context provideContext() {
        return this.mContext;
    }
}
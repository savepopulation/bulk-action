package com.raqun.bulkaction;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by tyln on 15/04/2017.
 */

public final class BulkActionApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}

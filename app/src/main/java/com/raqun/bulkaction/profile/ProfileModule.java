package com.raqun.bulkaction.profile;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tyln on 21/05/2017.
 */

@Module
class ProfileModule {

    @Nullable
    private ProfileNavigator mProfileNavigator;

    ProfileModule(@Nullable ProfileNavigator profileNavigator) {
        this.mProfileNavigator = profileNavigator;
    }

    @Nullable
    @Provides
    ProfileNavigator provideProfileNavigator() {
        return this.mProfileNavigator;
    }
}

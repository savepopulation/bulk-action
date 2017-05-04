package com.raqun.bulkaction.profile;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.data.BulkAction;
import com.raqun.bulkaction.util.FragmentScoped;

import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by tyln on 04/05/2017.
 */

@Module
final class ProfileModule {
    @NonNull
    private final List<BulkAction> mBulkActions;

    ProfileModule(@NonNull List<BulkAction> bulkActions) {
        this.mBulkActions = bulkActions;
    }

    @NonNull
    @Provides
    List<BulkAction> provideBulkActions() {
        return this.mBulkActions;
    }
}

package com.raqun.bulkaction.actions;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.data.source.UserRepositoryComponent;
import com.raqun.bulkaction.util.ActivityScoped;

import dagger.Component;

/**
 * Created by tyln on 28/04/2017.
 */

@Component(dependencies = UserRepositoryComponent.class)
@ActivityScoped
interface ActionsComponent {
    void inject(@NonNull ActionsActivity activity);
}

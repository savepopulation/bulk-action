package com.raqun.bulkaction.profile;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.data.source.UserRepositoryComponent;
import com.raqun.bulkaction.util.ActivityScoped;

import dagger.Component;

/**
 * Created by tyln on 28/04/2017.
 */

@Component(dependencies = UserRepositoryComponent.class, modules = ProfileModule.class)
@ActivityScoped
interface ProfileComponent {
    void inject(@NonNull ProfileActivity activity);
}

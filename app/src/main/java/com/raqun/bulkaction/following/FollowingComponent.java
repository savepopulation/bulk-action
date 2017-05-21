package com.raqun.bulkaction.following;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.data.source.UserRepositoryComponent;
import com.raqun.bulkaction.util.ActivityScoped;

import dagger.Component;

/**
 * Created by tyln on 21/05/2017.
 */

@Component(dependencies = {UserRepositoryComponent.class})
@ActivityScoped
interface FollowingComponent {
    void inject(@NonNull FollowingActivity activity);
}

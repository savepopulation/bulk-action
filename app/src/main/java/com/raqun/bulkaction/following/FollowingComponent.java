package com.raqun.bulkaction.followers;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.data.source.UserRepository;
import com.raqun.bulkaction.data.source.UserRepositoryComponent;
import com.raqun.bulkaction.util.ActivityScoped;

import dagger.Component;

/**
 * Created by tyln on 21/05/2017.
 */

@Component(dependencies = {UserRepositoryComponent.class})
@ActivityScoped
public interface FollowingComponent {
    void inject(@NonNull FollowingActivity activity);
}

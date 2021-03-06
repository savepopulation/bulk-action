package com.raqun.bulkaction.likes;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.data.source.UserRepositoryComponent;
import com.raqun.bulkaction.util.ActivityScoped;

import dagger.Component;

/**
 * Created by tyln on 21/05/2017.
 */

@ActivityScoped
@Component(dependencies = {UserRepositoryComponent.class})
interface LikesComponent {
    void inject(@NonNull LikesActivity activity);
}

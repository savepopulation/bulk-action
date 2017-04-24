package com.raqun.bulkaction.login;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.data.source.UserRepositoryComponent;
import com.raqun.bulkaction.util.ActivityScoped;

import dagger.Component;

/**
 * Created by tyln on 24/04/2017.
 */
@Component(dependencies = UserRepositoryComponent.class)
@ActivityScoped
public interface LoginComponent {
    void inject(@NonNull LoginActivity activity);
}

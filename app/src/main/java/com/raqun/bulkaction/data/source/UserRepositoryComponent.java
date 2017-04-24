package com.raqun.bulkaction.data.source;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.ApplicationModule;
import com.raqun.bulkaction.data.api.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by tyln on 24/04/2017.
 */

@Singleton
@Component(modules = {UserRepositoryModule.class, ApiModule.class, ApplicationModule.class})
public interface UserRepositoryComponent {
    @NonNull
    UserRepository getUserRepository();
}

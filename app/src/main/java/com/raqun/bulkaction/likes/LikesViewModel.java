package com.raqun.bulkaction.likes;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.BaseViewModel;
import com.raqun.bulkaction.data.source.UserRepository;

import javax.inject.Inject;

/**
 * Created by tyln on 21/05/2017.
 */

public final class LikesViewModel {

    @NonNull
    private final UserRepository mUserRepository;

    @Inject
    public LikesViewModel(@NonNull UserRepository userRepository) {
        this.mUserRepository = userRepository;
        fetchUserLikes();
    }

    private void fetchUserLikes() {
        // Not implemented
    }
}

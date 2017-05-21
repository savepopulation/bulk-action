package com.raqun.bulkaction.following;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.BaseViewModel;
import com.raqun.bulkaction.data.source.UserRepository;

import javax.inject.Inject;

/**
 * Created by tyln on 21/05/2017.
 */

public final class FollowingViewModel {

    @NonNull
    private UserRepository mUserRepository;

    @Inject
    FollowingViewModel(@NonNull UserRepository userRepository) {
        this.mUserRepository = userRepository;
        fetchFollowingList();
    }

    private void fetchFollowingList() {

    }
}

package com.raqun.bulkaction.posts;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.BaseViewModel;
import com.raqun.bulkaction.data.source.UserRepository;

import javax.inject.Inject;

/**
 * Created by tyln on 21/05/2017.
 */

public final class PostsViewModel {

    @NonNull
    private final UserRepository mUserRepository;

    @Inject
    public PostsViewModel(@NonNull UserRepository userRepository) {
        this.mUserRepository = userRepository;
        fetchPostsData();
    }

    private void fetchPostsData() {
        // Not implemented
    }
}

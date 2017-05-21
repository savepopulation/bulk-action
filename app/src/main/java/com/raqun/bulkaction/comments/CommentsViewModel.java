package com.raqun.bulkaction.comments;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.data.source.UserRepository;

import javax.inject.Inject;

/**
 * Created by tyln on 21/05/2017.
 */

public final class CommentsViewModel {

    @NonNull
    private final UserRepository mUserRepository;

    @Inject
    public CommentsViewModel(@NonNull UserRepository userRepository) {
        this.mUserRepository = userRepository;
        fetchComments();
    }

    private void fetchComments() {
        // Not implemented
    }
}

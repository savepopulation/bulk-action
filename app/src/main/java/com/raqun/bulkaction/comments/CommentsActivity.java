package com.raqun.bulkaction.comments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.raqun.bulkaction.BaseActivity;
import com.raqun.bulkaction.BulkActionApp;
import com.raqun.bulkaction.Constants;
import com.raqun.bulkaction.R;
import com.raqun.bulkaction.ViewModelHolder;
import com.raqun.bulkaction.following.DaggerFollowingComponent;
import com.raqun.bulkaction.following.FollowingFragment;
import com.raqun.bulkaction.following.FollowingViewModel;

import javax.inject.Inject;

/**
 * Created by tyln on 21/05/2017.
 */

public final class CommentsActivity extends BaseActivity {
    private static final String TAG_COMMENTS_VIEW_MODEL = "comments_view_model";

    @NonNull
    @Inject
    CommentsViewModel mCommentsViewModel;

    @Nullable
    CommentsComponent mCommentsComponent;

    @NonNull
    public static Intent newIntent(@NonNull Context context) {
        return new Intent(context, CommentsActivity.class);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected int getTitleRes() {
        return R.string.title_comments;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final CommentsFragment commentsFragment = findOrCreateView();
        findOrRetainViewModelHolder();
        commentsFragment.setViewModel(mCommentsViewModel);
    }

    @NonNull
    private CommentsFragment findOrCreateView() {
        CommentsFragment commentsFragment = (CommentsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.framelayout_main);
        if (commentsFragment == null) {
            commentsFragment = CommentsFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.framelayout_main, commentsFragment)
                    .commit();
        }

        return commentsFragment;
    }

    private void findOrRetainViewModelHolder() {
        @SuppressWarnings("unchecked")
        ViewModelHolder<CommentsViewModel> retainedViewModel = (ViewModelHolder<CommentsViewModel>)
                getSupportFragmentManager().findFragmentByTag(TAG_COMMENTS_VIEW_MODEL);

        if (retainedViewModel != null && retainedViewModel.getViewModel() != null) {
            mCommentsViewModel = retainedViewModel.getViewModel();
        } else {
            mCommentsComponent = DaggerCommentsComponent.builder()
                    .userRepositoryComponent(((BulkActionApp) getApplication()).getUserRepositoryComponent())
                    .build();
            mCommentsComponent.inject(this);
            getSupportFragmentManager().beginTransaction()
                    .add(ViewModelHolder.newInstance(mCommentsViewModel), TAG_COMMENTS_VIEW_MODEL)
                    .commit();
        }
    }
}

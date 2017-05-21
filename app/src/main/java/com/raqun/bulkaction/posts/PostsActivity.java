package com.raqun.bulkaction.posts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
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

public final class PostsActivity extends BaseActivity {
    private static final String TAG_POSTS_VIEW_MODEL = "posts_view_model";

    @NonNull
    @Inject
    PostsViewModel mPostsViewModel;

    @Nullable
    PostsComponent mPostsComponent;

    @NonNull
    public static Intent newIntent(@NonNull Context context) {
        return new Intent(context, PostsActivity.class);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected int getMenuRes() {
        return Constants.NO_RES;
    }

    @Override
    protected int getScreenName() {
        return Constants.NO_RES;
    }

    @Override
    protected int getTitleRes() {
        return R.string.title_posts;
    }

    @Override
    protected int getNavigationType() {
        return NAVIGATION_BACK;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);

        final PostsFragment postsFragment = findOrCreateView();
        findOrRetainViewModelHolder();
        postsFragment.setViewModel(mPostsViewModel);
    }

    @Override
    protected void onDestroy() {
        mPostsComponent = null;
        super.onDestroy();
    }

    @NonNull
    private PostsFragment findOrCreateView() {
        PostsFragment postsFragment = (PostsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.framelayout_main);
        if (postsFragment == null) {
            postsFragment = PostsFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.framelayout_main, postsFragment)
                    .commit();
        }

        return postsFragment;
    }

    private void findOrRetainViewModelHolder() {
        @SuppressWarnings("unchecked")
        ViewModelHolder<PostsViewModel> retainedViewModel = (ViewModelHolder<PostsViewModel>)
                getSupportFragmentManager().findFragmentByTag(TAG_POSTS_VIEW_MODEL);

        if (retainedViewModel != null && retainedViewModel.getViewModel() != null) {
            mPostsViewModel = retainedViewModel.getViewModel();
        } else {

            mPostsComponent = DaggerPostsComponent.builder()
                    .userRepositoryComponent(((BulkActionApp) getApplication()).getUserRepositoryComponent())
                    .build();

            mPostsComponent.inject(this);

            getSupportFragmentManager().beginTransaction()
                    .add(ViewModelHolder.newInstance(mPostsViewModel), TAG_POSTS_VIEW_MODEL)
                    .commit();

        }
    }
}

package com.raqun.bulkaction.likes;

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
import com.raqun.bulkaction.login.DaggerLoginComponent;

import javax.inject.Inject;

/**
 * Created by tyln on 21/05/2017.
 */

public final class LikesActivity extends BaseActivity {
    private static final String TAG_LIKES_VIEW_MODEL = "likes_view_model";

    @NonNull
    @Inject
    LikesViewModel mLikesViewModel;

    @Nullable
    LikesComponent mLikesComponent;

    @NonNull
    public static Intent newIntent(@NonNull Context context) {
        return new Intent(context, LikesActivity.class);
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
        return R.string.title_likes;
    }

    @Override
    protected int getNavigationType() {
        return NAVIGATION_BACK;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final LikesFragment likesFragment = findOrCreateView();
        findOrRetainViewModelHolder();
        likesFragment.setViewModel(mLikesViewModel);
    }

    @Override
    protected void onDestroy() {
        mLikesComponent = null;
        super.onDestroy();
    }

    @NonNull
    private LikesFragment findOrCreateView() {
        LikesFragment likesFragment = (LikesFragment) getSupportFragmentManager()
                .findFragmentById(R.id.framelayout_main);
        if (likesFragment == null) {
            likesFragment = LikesFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.framelayout_main, likesFragment)
                    .commit();
        }

        return likesFragment;
    }

    private void findOrRetainViewModelHolder() {
        @SuppressWarnings("unchecked")
        ViewModelHolder<LikesViewModel> retainedViewModel = (ViewModelHolder<LikesViewModel>)
                getSupportFragmentManager().findFragmentByTag(TAG_LIKES_VIEW_MODEL);

        if (retainedViewModel != null && retainedViewModel.getViewModel() != null) {
            mLikesViewModel = retainedViewModel.getViewModel();
        } else {
            mLikesComponent = DaggerLikesComponent.builder()
                    .userRepositoryComponent(((BulkActionApp) getApplication()).getUserRepositoryComponent())
                    .build();
            mLikesComponent.inject(this);
            getSupportFragmentManager().beginTransaction()
                    .add(ViewModelHolder.newInstance(mLikesViewModel), TAG_LIKES_VIEW_MODEL)
                    .commit();
        }
    }
}

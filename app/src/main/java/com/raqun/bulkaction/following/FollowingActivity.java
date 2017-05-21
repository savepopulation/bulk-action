package com.raqun.bulkaction.following;

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
import com.raqun.bulkaction.data.factory.BulkActionFactory;
import com.raqun.bulkaction.profile.DaggerProfileComponent;
import com.raqun.bulkaction.profile.ProfileFragment;
import com.raqun.bulkaction.profile.ProfileViewModel;

import javax.inject.Inject;

/**
 * Created by tyln on 21/05/2017.
 */

public final class FollowingActivity extends BaseActivity {
    private static final String TAG_FOLLOWING_VIEW_MODEL = "following_view_model";

    @NonNull
    @Inject
    FollowingViewModel mFollowingViewModel;

    @Nullable
    FollowingComponent mFollowingComponent;

    @NonNull
    public static Intent newIntent(@NonNull Context context) {
        return new Intent(context, FollowingActivity.class);
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
        return R.string.title_following;
    }

    @Override
    protected int getNavigationType() {
        return NAVIGATION_BACK;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final FollowingFragment followingFragment = findOrCreateView();
        findOrRetainViewModelHolder();
        followingFragment.setViewModel(mFollowingViewModel);
    }

    @Override
    protected void onDestroy() {
        mFollowingComponent = null;
        super.onDestroy();
    }

    @NonNull
    private FollowingFragment findOrCreateView() {
        FollowingFragment followingFragment = (FollowingFragment) getSupportFragmentManager()
                .findFragmentById(R.id.framelayout_main);
        if (followingFragment == null) {
            followingFragment = FollowingFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.framelayout_main, followingFragment)
                    .commit();
        }

        return followingFragment;
    }

    private void findOrRetainViewModelHolder() {
        @SuppressWarnings("unchecked")
        ViewModelHolder<FollowingViewModel> retainedViewModel = (ViewModelHolder<FollowingViewModel>)
                getSupportFragmentManager().findFragmentByTag(TAG_FOLLOWING_VIEW_MODEL);

        if (retainedViewModel != null && retainedViewModel.getViewModel() != null) {
            mFollowingViewModel = retainedViewModel.getViewModel();
        } else {

            mFollowingComponent = DaggerFollowingComponent.builder()
                    .userRepositoryComponent(((BulkActionApp) getApplication()).getUserRepositoryComponent())
                    .build();

            mFollowingComponent.inject(this);

            getSupportFragmentManager().beginTransaction()
                    .add(ViewModelHolder.newInstance(mFollowingViewModel), TAG_FOLLOWING_VIEW_MODEL)
                    .commit();
        }
    }
}

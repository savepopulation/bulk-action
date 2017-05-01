package com.raqun.bulkaction.profile;

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
import com.raqun.bulkaction.data.source.UserRepository;

import javax.inject.Inject;

/**
 * Created by tyln on 15/04/2017.
 */

public final class ProfileActivity extends BaseActivity {
    private static final String TAG_ACTIONS_VIEW_MODEL = "actions_view_model";

    @NonNull
    @Inject
    UserRepository mUserRespository;

    @NonNull
    ProfileViewModel mProfileViewModel;

    @NonNull
    public static Intent newIntent(@NonNull Context context) {
        return new Intent(context, ProfileActivity.class);
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
        return R.string.title_actions;
    }

    @Override
    protected int getNavigationType() {
        return NAVIGATION_ROOT;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ProfileFragment profileFragment = findOrCreateViewFragment();
        findOrRetainViewModelHolder();
        profileFragment.setmProfileViewModel(mProfileViewModel);

    }

    private ProfileFragment findOrCreateViewFragment() {
        ProfileFragment profileFragment = (ProfileFragment) getSupportFragmentManager()
                .findFragmentById(R.id.framelayout_main);
        if (profileFragment == null) {
            profileFragment = new ProfileFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.framelayout_main, profileFragment)
                    .commit();
        }

        return profileFragment;
    }

    private void findOrRetainViewModelHolder() {
        @SuppressWarnings("unchecked")
        ViewModelHolder<ProfileViewModel> retainedViewModel = (ViewModelHolder<ProfileViewModel>)
                getSupportFragmentManager().findFragmentByTag(TAG_ACTIONS_VIEW_MODEL);

        if (retainedViewModel != null && retainedViewModel.getViewModel() != null) {
            mProfileViewModel = retainedViewModel.getViewModel();
        } else {
            DaggerProfileComponent.builder()
                    .userRepositoryComponent(((BulkActionApp) getApplication()).getUserRepositoryComponent())
                    .build()
                    .inject(this);
            mProfileViewModel = new ProfileViewModel(mUserRespository);
            getSupportFragmentManager().beginTransaction()
                    .add(ViewModelHolder.newInstance(mProfileViewModel), TAG_ACTIONS_VIEW_MODEL)
                    .commit();
        }
    }
}

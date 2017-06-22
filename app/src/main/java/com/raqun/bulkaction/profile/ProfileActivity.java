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
import com.raqun.bulkaction.comments.CommentsActivity;
import com.raqun.bulkaction.data.factory.BulkActionFactory;
import com.raqun.bulkaction.data.source.UserRepository;
import com.raqun.bulkaction.following.FollowingActivity;
import com.raqun.bulkaction.likes.LikesActivity;
import com.raqun.bulkaction.posts.PostsActivity;

import javax.inject.Inject;

/**
 * Created by tyln on 15/04/2017.
 */

public final class ProfileActivity extends BaseActivity
        implements ProfileNavigator {

    private static final String TAG_ACTIONS_VIEW_MODEL = "actions_view_model";

    @NonNull
    @Inject
    ProfileViewModel mProfileViewModel;

    @Nullable
    ProfileComponent mProfileComponent;

    @NonNull
    public static Intent newIntent(@NonNull Context context) {
        return new Intent(context, ProfileActivity.class);
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected int getTitleRes() {
        return R.string.title_actions;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final ProfileFragment profileFragment = findOrCreateView();
        findOrRetainViewModelHolder();
        profileFragment.setViewModel(mProfileViewModel);
    }

    @Override
    protected void onDestroy() {
        mProfileComponent = null;
        mProfileViewModel.onActivityDestroyed();
        super.onDestroy();
    }

    @Override
    public void navigateToFollowings() {
        startActivity(FollowingActivity.newIntent(this));
    }

    @Override
    public void navigateToLikes() {
        startActivity(LikesActivity.newIntent(this));
    }

    @Override
    public void navigateToPosts() {
        startActivity(PostsActivity.newIntent(this));
    }

    @Override
    public void navigateToComments() {
        startActivity(CommentsActivity.newIntent(this));
    }

    @NonNull
    private ProfileFragment findOrCreateView() {
        ProfileFragment profileFragment = (ProfileFragment) getSupportFragmentManager()
                .findFragmentById(R.id.framelayout_main);
        if (profileFragment == null) {
            profileFragment = ProfileFragment.newInstance();
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
            mProfileViewModel.setNavigator(this);
        } else {
            mProfileComponent = DaggerProfileComponent.builder()
                    .userRepositoryComponent(((BulkActionApp) getApplication()).getUserRepositoryComponent())
                    .profileModule(new ProfileModule(this))
                    .build();
            mProfileComponent.inject(this);
            getSupportFragmentManager().beginTransaction()
                    .add(ViewModelHolder.newInstance(mProfileViewModel), TAG_ACTIONS_VIEW_MODEL)
                    .commit();
        }
    }
}

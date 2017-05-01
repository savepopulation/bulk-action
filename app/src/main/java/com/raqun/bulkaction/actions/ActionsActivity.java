package com.raqun.bulkaction.actions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import com.raqun.bulkaction.BaseActivity;
import com.raqun.bulkaction.BulkActionApp;
import com.raqun.bulkaction.Constants;
import com.raqun.bulkaction.R;
import com.raqun.bulkaction.ViewModelHolder;
import com.raqun.bulkaction.data.source.DaggerUserRepositoryComponent;
import com.raqun.bulkaction.data.source.UserRepository;
import com.raqun.bulkaction.login.DaggerLoginComponent;

import javax.inject.Inject;

/**
 * Created by tyln on 15/04/2017.
 */

public final class ActionsActivity extends BaseActivity {
    private static final String TAG_ACTIONS_VIEW_MODEL = "actions_view_model";

    @NonNull
    @Inject
    UserRepository mUserRespository;

    @NonNull
    ActionsViewModel mActionsViewModel;

    @NonNull
    public static Intent newIntent(@NonNull Context context) {
        return new Intent(context, ActionsActivity.class);
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

        final ActionsFragment actionsFragment = findOrCreateViewFragment();
        findOrRetainViewModelHolder();
        actionsFragment.setmActionsViewModel(mActionsViewModel);

    }

    private ActionsFragment findOrCreateViewFragment() {
        ActionsFragment actionsFragment = (ActionsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.framelayout_main);
        if (actionsFragment == null) {
            actionsFragment = new ActionsFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.framelayout_main, actionsFragment)
                    .commit();
        }

        return actionsFragment;
    }

    private void findOrRetainViewModelHolder() {
        @SuppressWarnings("unchecked")
        ViewModelHolder<ActionsViewModel> retainedViewModel = (ViewModelHolder<ActionsViewModel>)
                getSupportFragmentManager().findFragmentByTag(TAG_ACTIONS_VIEW_MODEL);

        if (retainedViewModel != null && retainedViewModel.getViewModel() != null) {
            mActionsViewModel = retainedViewModel.getViewModel();
        } else {
            DaggerActionsComponent.builder()
                    .userRepositoryComponent(((BulkActionApp) getApplication()).getUserRepositoryComponent())
                    .build()
                    .inject(this);
            mActionsViewModel = new ActionsViewModel(mUserRespository);
            getSupportFragmentManager().beginTransaction()
                    .add(ViewModelHolder.newInstance(mActionsViewModel), TAG_ACTIONS_VIEW_MODEL)
                    .commit();
        }
    }
}

package com.raqun.bulkaction.followers;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.raqun.bulkaction.BaseActivity;
import com.raqun.bulkaction.Constants;
import com.raqun.bulkaction.R;

/**
 * Created by tyln on 21/05/2017.
 */

public final class FollowingActivity extends BaseActivity {

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
}

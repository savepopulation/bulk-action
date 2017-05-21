package com.raqun.bulkaction.followers;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.BaseFragment;
import com.raqun.bulkaction.Constants;
import com.raqun.bulkaction.R;

/**
 * Created by tyln on 21/05/2017.
 */

public final class FollowingFragment extends BaseFragment {

    @NonNull
    public static FollowingFragment newInstance() {
        return new FollowingFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_following;
    }

    @Override
    protected int getMenuRes() {
        return Constants.NO_RES;
    }
}

package com.raqun.bulkaction.following;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raqun.bulkaction.BaseFragment;
import com.raqun.bulkaction.BaseView;
import com.raqun.bulkaction.Constants;
import com.raqun.bulkaction.R;
import com.raqun.bulkaction.databinding.FragmentFollowingBinding;

/**
 * Created by tyln on 21/05/2017.
 */

public final class FollowingFragment extends BaseFragment
        implements BaseView<FollowingViewModel> {

    @NonNull
    private FollowingViewModel mViewModel;

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

    @Override
    public void setViewModel(@NonNull FollowingViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = super.onCreateView(inflater, container, savedInstanceState);
        final FragmentFollowingBinding fragmentFollowingBinding = DataBindingUtil.bind(view);
        fragmentFollowingBinding.setViewModel(mViewModel);
        return view;
    }
}

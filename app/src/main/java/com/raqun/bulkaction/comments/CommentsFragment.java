package com.raqun.bulkaction.comments;

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
import com.raqun.bulkaction.databinding.FragmentCommentsBinding;

/**
 * Created by tyln on 21/05/2017.
 */

public final class CommentsFragment extends BaseFragment
        implements BaseView<CommentsViewModel> {

    @NonNull
    private CommentsViewModel mViewModel;

    @NonNull
    public static CommentsFragment newInstance() {
        return new CommentsFragment();
    }

    @Override
    public void setViewModel(@NonNull CommentsViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_comments;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = super.onCreateView(inflater, container, savedInstanceState);
        final FragmentCommentsBinding fragmentCommentsBinding = DataBindingUtil.bind(view);
        fragmentCommentsBinding.setViewModel(mViewModel);
        return view;
    }
}

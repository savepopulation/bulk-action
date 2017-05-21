package com.raqun.bulkaction.posts;

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
import com.raqun.bulkaction.databinding.FragmentPostsBinding;

/**
 * Created by tyln on 21/05/2017.
 */

public final class PostsFragment extends BaseFragment
        implements BaseView<PostsViewModel> {

    @NonNull
    private PostsViewModel mViewModel;

    @NonNull
    public static PostsFragment newInstance() {
        return new PostsFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_posts;
    }

    @Override
    protected int getMenuRes() {
        return Constants.NO_RES;
    }

    @Override
    public void setViewModel(@NonNull PostsViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = super.onCreateView(inflater, container, savedInstanceState);
        final FragmentPostsBinding fragmentPostsBinding = DataBindingUtil.bind(view);
        fragmentPostsBinding.setViewModel(mViewModel);
        return view;
    }
}

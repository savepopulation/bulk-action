package com.raqun.bulkaction.likes;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raqun.bulkaction.BaseFragment;
import com.raqun.bulkaction.BaseView;
import com.raqun.bulkaction.BindingAdapterUtil;
import com.raqun.bulkaction.Constants;
import com.raqun.bulkaction.R;
import com.raqun.bulkaction.databinding.FragmentLikesBinding;

/**
 * Created by tyln on 21/05/2017.
 */

public final class LikesFragment extends BaseFragment
        implements BaseView<LikesViewModel> {

    @NonNull
    private LikesViewModel mViewModel;

    @NonNull
    public static LikesFragment newInstance() {
        return new LikesFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_likes;
    }

    @Override
    protected int getMenuRes() {
        return Constants.NO_RES;
    }

    @Override
    public void setViewModel(@NonNull LikesViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = super.onCreateView(inflater, container, savedInstanceState);
        final FragmentLikesBinding fragmentLikesBinding = DataBindingUtil.bind(view);
        fragmentLikesBinding.setViewModel(mViewModel);
        return view;
    }
}

package com.raqun.bulkaction.profile;

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
import com.raqun.bulkaction.databinding.FragmentProfileBinding;

/**
 * Created by tyln on 27/04/2017.
 */

public final class ProfileFragment extends BaseFragment
        implements BaseView<ProfileViewModel> {

    @NonNull
    private ProfileViewModel mViewModel;

    @NonNull
    public static ProfileFragment newInstance() {
        return new ProfileFragment();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_profile;
    }

    @Override
    protected int getMenuRes() {
        return Constants.NO_RES;
    }

    @Override
    public void setViewModel(@NonNull ProfileViewModel viewModel) {
        this.mViewModel = viewModel;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = super.onCreateView(inflater, container, savedInstanceState);
        final FragmentProfileBinding fragmentProfileBinding = FragmentProfileBinding.bind(view);
        fragmentProfileBinding.setViewModel(mViewModel);
        return view;
    }
}

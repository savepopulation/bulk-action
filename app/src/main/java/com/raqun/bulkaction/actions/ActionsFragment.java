package com.raqun.bulkaction.actions;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.raqun.bulkaction.BaseFragment;
import com.raqun.bulkaction.Constants;
import com.raqun.bulkaction.R;
import com.raqun.bulkaction.databinding.FragmentActionsBinding;

/**
 * Created by tyln on 27/04/2017.
 */

public final class ActionsFragment extends BaseFragment {

    @NonNull
    private ActionsViewModel mActionsViewModel;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_actions;
    }

    @Override
    protected int getMenuRes() {
        return Constants.NO_RES;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = super.onCreateView(inflater, container, savedInstanceState);
        final FragmentActionsBinding fragmentActionsBinding = FragmentActionsBinding.bind(view);
        fragmentActionsBinding.setActionsViewModel(mActionsViewModel);
        return view;
    }

    public void setmActionsViewModel(@NonNull ActionsViewModel actionsViewModel) {
        this.mActionsViewModel = actionsViewModel;
    }

    @Override
    public void onStart() {
        super.onStart();
        mActionsViewModel.start();
    }
}

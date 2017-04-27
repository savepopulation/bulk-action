package com.raqun.bulkaction.actions;

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

public class ActionsFragment extends Fragment {

    private ActionsViewModel mActionsViewModel;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_actions, container, false);

        FragmentActionsBinding fragmentActionsBinding = FragmentActionsBinding.bind(view);
        fragmentActionsBinding.setActionsViewModel(mActionsViewModel);

        setHasOptionsMenu(true);

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

package com.raqun.bulkaction;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

/**
 * Created by tyln on 27/04/2017.
 */

public class ViewModelHolder<VM> extends Fragment {

    private VM viewModel;

    public ViewModelHolder() {
        // Empty constructor
    }

    public static <M> ViewModelHolder newInstance(@NonNull M viewModel) {
        final ViewModelHolder viewModelHolder = new ViewModelHolder();
        viewModelHolder.setViewModel(viewModel);
        return viewModelHolder;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    public VM getViewModel() {
        return viewModel;
    }

    public void setViewModel(VM viewModel) {
        this.viewModel = viewModel;
    }
}

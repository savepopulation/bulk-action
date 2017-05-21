package com.raqun.bulkaction;

import android.support.annotation.NonNull;

/**
 * Created by tyln on 21/05/2017.
 */

public interface BaseView<T> {
    void setViewModel(@NonNull T viewModel);
}

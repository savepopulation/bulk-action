package com.raqun.bulkaction;

/**
 * Created by tyln on 21/05/2017.
 */

public interface BaseViewModel<T> {
    void onActivityDestroyed();

    void setNavigator(T navigator);
}

package com.raqun.bulkaction.data.source;

import android.support.annotation.NonNull;

import com.raqun.bulkaction.data.User;

/**
 * Created by tyln on 24/04/2017.
 */

public interface UserDataSource {
    void saveUser(@NonNull User user);
}

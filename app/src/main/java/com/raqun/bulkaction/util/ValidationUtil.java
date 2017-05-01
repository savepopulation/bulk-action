package com.raqun.bulkaction.util;

import android.support.annotation.Nullable;

import java.util.Collection;

/**
 * Created by tyln on 15/04/2017.
 */

public final class ValidationUtil {
    private ValidationUtil() {
        // Private Emptry Constructor
    }

    public static boolean isNullOrEmpty(@Nullable String s) {
        return s == null || s.length() == 0 || s.trim().length() == 0;
    }

    public static boolean isNullOrEmpty(@Nullable CharSequence s) {
        return s == null || s.length() == 0;
    }

    public static boolean isNullOrEmpty(@Nullable Collection collection) {
        return collection == null || collection.size() == 0;
    }
}

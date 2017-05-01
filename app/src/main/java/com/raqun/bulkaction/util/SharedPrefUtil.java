package com.raqun.bulkaction.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by tyln on 01/05/2017.
 */

public final class SharedPrefUtil {
    private static final String MASTER_KEY = "!bulk+4ct10n?";

    private SharedPrefUtil() {
        // Empty private constructor
    }

    @NonNull
    private static SharedPreferences getSharedPreferences(@NonNull Context context) {
        return context.getSharedPreferences(MASTER_KEY, Context.MODE_PRIVATE);
    }

    public static void put(@NonNull Context context, @NonNull String key, @Nullable String value) {
        getSharedPreferences(context).edit()
                .putString(key, value)
                .apply();
    }

    public static void put(@NonNull Context context, @NonNull String key, int value) {
        getSharedPreferences(context).edit()
                .putInt(key, value)
                .apply();
    }

    public static void clearData(@NonNull Context context) {
        getSharedPreferences(context)
                .edit()
                .clear()
                .apply();
    }

    @Nullable
    public static String get(@NonNull Context context, @NonNull String key, @Nullable String defaultVal) {
        return getSharedPreferences(context)
                .getString(key, defaultVal);
    }

    public static void remove(@NonNull Context context, @NonNull String key) {
        getSharedPreferences(context)
                .edit()
                .remove(key)
                .apply();
    }
}

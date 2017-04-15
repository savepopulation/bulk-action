package com.raqun.bulkaction.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by tyln on 15/04/2017.
 */

public final class AlertUtil {
    private AlertUtil() {
        // Empty Constructor
    }

    public static void alert(@NonNull final Context context, @Nullable final String mesage) {
        if (context == null || ValidationUtil.isNullOrEmpty(mesage)) {
            return;
        }

        Toast.makeText(context, mesage, Toast.LENGTH_SHORT).show();
    }

    @NonNull
    public static ProgressDialog createProgressDialog(@NonNull Context context,
                                                      @NonNull CharSequence message,
                                                      final boolean isCancelable) {
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(isCancelable);
        return progressDialog;
    }
}

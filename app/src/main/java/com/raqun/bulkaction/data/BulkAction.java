package com.raqun.bulkaction.data;

import android.support.annotation.DrawableRes;

/**
 * Created by tyln on 04/05/2017.
 */

public final class BulkAction {
    private final int id;
    private final String label;
    @DrawableRes
    private final int resId;

    public BulkAction(int id, String label, int resId) {
        this.id = id;
        this.label = label;
        this.resId = resId;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public int getResId() {
        return resId;
    }
}

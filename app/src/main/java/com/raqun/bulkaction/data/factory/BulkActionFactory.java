package com.raqun.bulkaction.data.factory;

import android.content.Context;
import android.support.annotation.NonNull;

import com.raqun.bulkaction.Constants;
import com.raqun.bulkaction.R;
import com.raqun.bulkaction.data.BulkAction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyln on 04/05/2017.
 */

public final class BulkActionFactory {

    private static final int ACTION_ID_UNFOLLOW = 0;
    private static final int ACTION_ID_UNLIKE = 1;
    private static final int ACTION_ID_DELETE_POST = 2;
    private static final int ACTION_ID_DELETE_COMMENT = 3;

    private BulkActionFactory() {
        // Private emtpy constructor
    }

    @NonNull
    public static List<BulkAction> getBulkActions(@NonNull Context context) {
        final List<BulkAction> actions = new ArrayList<>();
        actions.add(new BulkAction(ACTION_ID_UNFOLLOW, context.getString(R.string.bulk_action_unfollow), Constants.NO_RES));
        actions.add(new BulkAction(ACTION_ID_UNLIKE, context.getString(R.string.bulk_action_unlike), Constants.NO_RES));
        actions.add(new BulkAction(ACTION_ID_DELETE_POST, context.getString(R.string.bulk_action_delete_posts), Constants.NO_RES));
        actions.add(new BulkAction(ACTION_ID_DELETE_COMMENT, context.getString(R.string.bulk_action_delete_comments), Constants.NO_RES));
        return actions;
    }
}

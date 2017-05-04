package com.raqun.bulkaction.profile;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.raqun.bulkaction.R;
import com.raqun.bulkaction.data.BulkAction;
import com.raqun.bulkaction.databinding.ActionsRowBinding;

import java.util.List;

/**
 * Created by tyln on 04/05/2017.
 */

public final class ActionsAdapter extends BaseAdapter {

    @NonNull
    private final ObservableList<BulkAction> mActions;

    @NonNull
    private final Context mContext;

    public ActionsAdapter(@NonNull ObservableList<BulkAction> actions,
                          @NonNull Context context) {
        this.mActions = actions;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return mActions.size();
    }

    @Override
    public Object getItem(int i) {
        return mActions.get(i);
    }

    @Override
    public long getItemId(int i) {
        return mActions.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ActionsRowBinding actionsRowBinding;
        if (view == null) {
            actionsRowBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),
                    R.layout.actions_row, null, false);
            view = actionsRowBinding.getRoot();
        } else {
            actionsRowBinding = (ActionsRowBinding) view.getTag();
        }

        actionsRowBinding.setAction(mActions.get(i));
        view.setTag(actionsRowBinding);
        return view;
    }


}

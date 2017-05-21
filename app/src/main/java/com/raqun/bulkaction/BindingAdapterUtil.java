package com.raqun.bulkaction;

import android.databinding.BindingAdapter;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.ListView;

import com.raqun.bulkaction.data.BulkAction;
import com.squareup.picasso.Picasso;

/**
 * Created by tyln on 04/05/2017.
 */

public final class BindingAdapterUtil {

    private BindingAdapterUtil() {
        // Private empty constructor
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(@NonNull ImageView imageView, @NonNull String url) {
        Picasso.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}

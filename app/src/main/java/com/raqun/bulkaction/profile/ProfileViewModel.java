package com.raqun.bulkaction.profile;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import com.raqun.bulkaction.data.BulkAction;
import com.raqun.bulkaction.data.Counts;
import com.raqun.bulkaction.data.User;
import com.raqun.bulkaction.data.factory.BulkActionFactory;
import com.raqun.bulkaction.data.source.UserRepository;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tyln on 27/04/2017.
 */

public final class ProfileViewModel {

    @NonNull
    private final UserRepository mUserRepository;

    @NonNull
    public final ObservableField<User> mUserObservable;

    public final ObservableList<BulkAction> mBulkActions;

    @Inject
    ProfileViewModel(@NonNull UserRepository userRepository, @NonNull List<BulkAction> actions) {
        this.mUserRepository = userRepository;

        this.mUserObservable = new ObservableField<>();
        this.mBulkActions = new ObservableArrayList<>();
        mBulkActions.addAll(actions);
    }

    void start() {
        mUserRepository.getUser()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new SingleObserver<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        // Empty method
                    }

                    @Override
                    public void onSuccess(User value) {
                        mUserObservable.set(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", "error");
                    }
                });
    }


}

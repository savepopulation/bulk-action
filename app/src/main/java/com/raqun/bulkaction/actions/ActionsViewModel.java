package com.raqun.bulkaction.actions;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.ImageView;

import com.raqun.bulkaction.R;
import com.raqun.bulkaction.data.User;
import com.raqun.bulkaction.data.source.UserRepository;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;

/**
 * Created by tyln on 27/04/2017.
 */

public class ActionsViewModel {
    @NonNull
    private final UserRepository mUserRepository;

    public ObservableField<String> mUserName;

    ActionsViewModel(@NonNull UserRepository userRepository) {
        this.mUserRepository = userRepository;
        this.mUserName = new ObservableField<>();
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
                        mUserName.set(value.getUserName());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", "error");
                    }
                });
    }
}

package com.raqun.bulkaction.actions;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.raqun.bulkaction.data.User;
import com.raqun.bulkaction.data.source.UserRepository;

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

    public final ObservableField<String> userName = new ObservableField<>();

    ActionsViewModel(@NonNull UserRepository userRepository) {
        this.mUserRepository = userRepository;
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
                        Log.e("user name", "" + value.getUserName());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", "error");
                    }
                });
    }
}

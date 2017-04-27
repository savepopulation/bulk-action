package com.raqun.bulkaction.actions;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.raqun.bulkaction.data.User;
import com.raqun.bulkaction.data.source.UserRepository;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.Subject;

/**
 * Created by tyln on 27/04/2017.
 */

public class ActionsViewModel extends BaseObservable {
    @NonNull
    private final UserRepository mUserRepository;

    public final ObservableField<String> userName = new ObservableField<>();

    public ActionsViewModel(@NonNull UserRepository userRepository) {
        this.mUserRepository = userRepository;
    }

    public void start() {
        mUserRepository.getUser(mUserRepository.getCurrentUser().getToken())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<User>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(User value) {
                        userName.set(value.getUserName());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}

package com.raqun.bulkaction.profile;

import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;

import com.raqun.bulkaction.data.Counts;
import com.raqun.bulkaction.data.User;
import com.raqun.bulkaction.data.source.UserRepository;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by tyln on 27/04/2017.
 */

public class ProfileViewModel {
    @NonNull
    private final UserRepository mUserRepository;

    @NonNull
    public final ObservableField<String> mUserName;

    @NonNull
    public final ObservableField<Long> mFolowsCount;

    @NonNull
    public final ObservableField<Long> mFollowedByCount;

    @NonNull
    public final ObservableField<Long> mPostsCount;

    ProfileViewModel(@NonNull UserRepository userRepository) {
        this.mUserRepository = userRepository;

        this.mUserName = new ObservableField<>();
        this.mFolowsCount = new ObservableField<>();
        this.mFollowedByCount = new ObservableField<>();
        this.mPostsCount = new ObservableField<>();
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
                        final Counts counts = value.getCounts();
                        if (counts != null) {
                            mFolowsCount.set(counts.getFollows());
                            mFollowedByCount.set(counts.getFollowedBy());
                            mPostsCount.set(counts.getMedia());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("error", "error");
                    }
                });
    }
}

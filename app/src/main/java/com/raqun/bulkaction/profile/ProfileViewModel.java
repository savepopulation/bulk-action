package com.raqun.bulkaction.profile;

import android.databinding.BindingAdapter;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.ImageView;

import com.raqun.bulkaction.data.Counts;
import com.raqun.bulkaction.data.User;
import com.raqun.bulkaction.data.source.UserRepository;
import com.squareup.picasso.Picasso;

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

    ProfileViewModel(@NonNull UserRepository userRepository) {
        this.mUserRepository = userRepository;
        this.mUserObservable = new ObservableField<>();
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

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Picasso.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }
}

package com.raqun.bulkaction.profile;

import android.databinding.BindingAdapter;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.raqun.bulkaction.BaseViewModel;
import com.raqun.bulkaction.R;
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

public final class ProfileViewModel implements BaseViewModel<ProfileNavigator> {

    @NonNull
    private final UserRepository mUserRepository;

    @Nullable
    private ProfileNavigator mProfileNavigator;

    @NonNull
    public final ObservableField<User> mUserObservable = new ObservableField<>();

    @Inject
    ProfileViewModel(@NonNull UserRepository userRepository,
                     @Nullable ProfileNavigator profileNavigator) {
        this.mUserRepository = userRepository;
        this.mProfileNavigator = profileNavigator;

        fetchUserDetails();
    }

    private void fetchUserDetails() {
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

    @Override
    public void onActivityDestroyed() {
        this.mProfileNavigator = null;
    }

    @Override
    public void setNavigator(ProfileNavigator navigator) {
        this.mProfileNavigator = navigator;
    }

    public void onActionRequired(View view) {
        if (mProfileNavigator == null) return;

        switch (view.getId()) {
            case R.id.button_following:
                mProfileNavigator.navigateToFollowings();
                break;

            case R.id.button_likes:
                mProfileNavigator.navigateToLikes();
                break;

            case R.id.button_posts:
                mProfileNavigator.navigateToPosts();
                break;

            case R.id.button_comments:
                mProfileNavigator.navigateToComments();
                break;
        }
    }
}

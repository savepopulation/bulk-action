package com.raqun.bulkaction.data.api;


import com.raqun.bulkaction.data.bean.UserResponseBean;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tyln on 14.08.16.
 */
public interface BulkActionServices {
    @GET("users/self/")
    Single<UserResponseBean> getUser();
}

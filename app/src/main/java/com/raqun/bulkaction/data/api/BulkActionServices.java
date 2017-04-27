package com.raqun.bulkaction.data.api;


import com.raqun.bulkaction.data.bean.UserWrapper;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by tyln on 14.08.16.
 */
public interface BulkActionServices {
    @GET("users/self/")
    Observable<UserWrapper> getUser(@Query("access_token") String token);
}

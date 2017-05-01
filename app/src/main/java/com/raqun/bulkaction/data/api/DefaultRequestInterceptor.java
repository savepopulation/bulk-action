package com.raqun.bulkaction.data.api;

import com.raqun.bulkaction.data.source.UserRepository;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by tyln on 1.09.16.
 */
final class DefaultRequestInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (UserRepository.getCurrentUser() == null) {
            return chain.proceed(chain.request());
        } else {
            final Request originalRequest = chain.request();
            final HttpUrl originalUrl = originalRequest.url();

            final HttpUrl interceptedUrl = originalUrl.newBuilder()
                    .addQueryParameter(Constants.QUERY_PARAM_TOKEN, UserRepository.getCurrentUser().getToken())
                    .build();

            final Request.Builder requestBuilder = originalRequest.newBuilder()
                    .url(interceptedUrl);

            return chain.proceed(requestBuilder.build());
        }
    }
}

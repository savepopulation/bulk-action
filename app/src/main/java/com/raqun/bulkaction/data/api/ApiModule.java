package com.raqun.bulkaction.data.api;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.raqun.bulkaction.BuildConfig;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tyln on 14.08.16.
 */

@Module
public final class ApiModule {
    @Nullable
    private static final String BASE_URL = "https://www.instagram.com";//BuildConfig.BASE_URL;

    public ApiModule() {
        // Empty public constructor
    }

    @Provides
    @Singleton
    String provideBaseUrl() {
        return BASE_URL;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(@NonNull Interceptor interceptor) {
        return createApiClient(interceptor).build();
    }

    @Provides
    @Singleton
    BulkActionServices provideServices(@NonNull Retrofit retrofit) {
        return retrofit.create(BulkActionServices.class);
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(@NonNull String baseUrl, @NonNull OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    Interceptor provideDefaultRequestInterceptor() {
        return new DefaultRequestInterceptor();
    }

    @NonNull
    private static OkHttpClient.Builder createApiClient(@Nullable Interceptor requestInterceptor) {
        final OkHttpClient.Builder okHttpClientBuilder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClientBuilder.addInterceptor(interceptor);
        }
        okHttpClientBuilder.connectTimeout(Constants.DEFAULT_TIMEOUT, TimeUnit.MILLISECONDS);
        okHttpClientBuilder.addInterceptor(requestInterceptor);
        return okHttpClientBuilder;
    }
}

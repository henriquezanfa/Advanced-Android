package com.refinaria.advancedandroidcourse.networking;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Call;
import okhttp3.OkHttpClient;

@Module
public abstract class NetworkModule {
    @Provides
    @Singleton
    static Call.Factory providesOkHttp() {
        return new OkHttpClient.Builder().build();
    }

    @Provides
    @Named("base_url")
    static String providesBaseUrl() {
        return "https://api.github.com/";
    }
}
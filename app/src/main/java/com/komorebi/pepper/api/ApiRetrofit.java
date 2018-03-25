package com.komorebi.pepper.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.ConcurrentHashMap;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Komorebi on 2018/3/22.
 */

public class ApiRetrofit {

    private static final String BASE_URL = "http://115.159.52.234:81/v2/";
    private final Retrofit retrofit;
    private final ConcurrentHashMap<Class, Object> services;

    public ApiRetrofit() {
        this.services = new ConcurrentHashMap<>();
        final Gson gson = new GsonBuilder().create();
        OkHttpClient okHttpClient = new OkHttpClient();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public RetrofitService getApiService() {
        return retrofit.create(RetrofitService.class);
    }
}

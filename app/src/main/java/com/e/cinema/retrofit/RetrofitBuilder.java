package com.e.cinema.retrofit;


import com.e.cinema.BuildConfig;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitBuilder {

    private  static OkHttpClient client;

    private static   RetrofitService service;

    public static RetrofitService getService(){


   if(service == null)
    service = buildRetrofit();


      return service;
}
    private static RetrofitService buildRetrofit() {

        return new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL_CINEMA)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getClient())
                .build()
                .create(RetrofitService.class);
    }




    private static OkHttpClient getClient(){
        if (client == null)
            client = buildClient();
        return client;
    }

    private static OkHttpClient buildClient(){
        return new OkHttpClient.Builder()
                .callTimeout(5, TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .build();

    }
}


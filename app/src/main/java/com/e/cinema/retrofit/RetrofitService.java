package com.e.cinema.retrofit;

import com.e.cinema.model.Cinema;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface RetrofitService {

    @GET(" ")
    Call<Cinema> getFilms (@Query("t")String filmName,
                           @Query("apikey")String key);

}
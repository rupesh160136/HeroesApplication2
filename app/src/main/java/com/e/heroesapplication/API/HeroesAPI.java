package com.e.heroesapplication.API;

import com.e.heroesapplication.Model.Heroes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface HeroesAPI {
    @POST("heroes")
    Call<Void> addhero(@Body Heroes heroes);

    @GET("heroes")
    Call<List<Heroes>>getHero();
}

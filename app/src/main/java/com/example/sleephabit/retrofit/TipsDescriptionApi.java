package com.example.sleephabit.retrofit;

import com.example.sleephabit.model.TipsDescription;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TipsDescriptionApi {

    @GET("/td/get-all")
    Call<List<TipsDescription>> getAllTips();

    @POST("/td/save")
    Call<TipsDescription> save(@Body TipsDescription tipsDescription);
}

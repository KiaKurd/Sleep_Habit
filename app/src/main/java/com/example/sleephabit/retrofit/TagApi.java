package com.example.sleephabit.retrofit;

import com.example.sleephabit.model.Tag;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface TagApi {

    @GET("/tag/get-all")
    Call<List<Tag>> getAllTags();

    @POST("/tag/save")
    Call<Tag> save(@Body Tag tag);
}

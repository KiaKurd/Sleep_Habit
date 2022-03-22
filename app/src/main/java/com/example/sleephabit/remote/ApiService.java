package com.example.sleephabit.remote;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

    @PUT("/addUser")
    Call<ResponseClass> addUser(@Body ResponseRegisterClass responseRegisterClass);

    @POST("/getUser")
    Call<ResponseClass> getUser(@Body ResponseRegisterClass responseRegisterClass);

}
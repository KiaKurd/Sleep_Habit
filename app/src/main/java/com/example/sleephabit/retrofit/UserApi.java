package com.example.sleephabit.retrofit;

import com.example.sleephabit.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserApi {
    @GET("/user/get-all")
    Call<List<User>> getAllUsers();

    @POST("/user/save")
    Call<User> save(@Body User user);

    @POST("/user/auth/register")
    Call<User> register(@Body User user);

    @GET("/user/auth/login")
    Call<User> login(@Body User user);

}

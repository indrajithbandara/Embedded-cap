package com.example.hadri_santos.androidnetworking.rest;

import com.example.hadri_santos.androidnetworking.models.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by hadri_santos on 17/01/18.
 */

public interface JsonPlaceHolderApiInterface {
    @Headers("User-Agent: Retrofit2.0Tutorial-App")

    @GET("/users/{id}")
    Call<User> getUserById(@Path("id") Integer id);

    @PUT("/users/{id}")
    Call<User> updateUser(@Path("id") Integer id, @Body User user);
}


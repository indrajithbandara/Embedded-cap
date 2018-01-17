package com.example.hadri_santos.androidnetworking.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hadri_santos on 17/01/18.
 */

public class RestClient {
    private static JsonPlaceHolderApiInterface jsonPlaceHolderApiInterface ;
    private static String baseUrl = "http://jsonplaceholder.typicode.com" ;

    public static JsonPlaceHolderApiInterface getClient() {
        if (jsonPlaceHolderApiInterface == null) {

            Retrofit client = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            jsonPlaceHolderApiInterface = client.create(JsonPlaceHolderApiInterface.class);
        }
        return jsonPlaceHolderApiInterface;
    }

}

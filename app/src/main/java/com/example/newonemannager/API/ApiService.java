package com.example.newonemannager.API;

import com.example.newonemannager.Models.Commmon;
import com.example.newonemannager.Models.Food;
import com.google.android.gms.common.api.Api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
    OkHttpClient okHttpClient = new OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build();
    ApiService api = new Retrofit.Builder()
            .baseUrl(Commmon.baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient)
            .build()
            .create(ApiService.class);
    @GET("api/foods/getfood")
    Call<List<Food>> getFoods(@Query("keyword") String keyword);
}

package com.example.newonemannager.API;

import com.example.newonemannager.Models.Account;
import com.example.newonemannager.Models.Commmon;
import com.example.newonemannager.Models.Customer;
import com.example.newonemannager.Models.Emphloyee;
import com.example.newonemannager.Models.Food;
import com.example.newonemannager.Models.FoodDetail;
import com.example.newonemannager.Models.Material;
import com.example.newonemannager.Models.Order;
import com.example.newonemannager.Models.OrderDetail;
import com.example.newonemannager.Models.UsedMaterial;
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
    @GET("api/Accounts/GetAccount")
    Call<List<Account>>getAccount();
    @GET("api/Customers/Getcustomer")
    Call<List<Customer>>getCustomer();
    @GET("api/Employees/Getemployee")
    Call<List<Emphloyee>>getEmphloyees(@Query("keyword")String keyword);
    @GET("api/FoodDetails/GetFoodDetail")
    Call<List<FoodDetail>>getFoodDetail();
    @GET("api/Materials/getmaterial")
    Call<List<Material>>getMaterial(@Query("keyword")String keyword);
    @GET("api/Orders/getorder")
    Call<List<Order>>getOrder(@Query("keyword") String keyword);
    @GET("api/OrderDetails/GetOrderDetails")
    Call<List<OrderDetail>>getOrderDetail();
    @GET("api/UsedMaterials/GetUsedMaterials")
    Call<List<UsedMaterial>>getUsedMaterial();

}

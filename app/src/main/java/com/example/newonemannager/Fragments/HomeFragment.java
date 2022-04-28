package com.example.newonemannager.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.newonemannager.API.ApiService;
import com.example.newonemannager.Activity.FoodListActivity;
import com.example.newonemannager.Adapter.DoUongAdapter;
import com.example.newonemannager.Adapter.LoaiDoUongAdapter;
import com.example.newonemannager.Models.CategoryOfFood;
import com.example.newonemannager.Models.Common;
import com.example.newonemannager.Models.Food;
import com.example.newonemannager.R;

import org.lucasr.twowayview.TwoWayView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    TwoWayView lv_foryou, lv_category;
    GridView lv_food;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        setAdapter();
        loadData();
    }

    List<Food> foodList = new ArrayList<>();
    DoUongAdapter adapter;
    List<Food> foodForYou = new ArrayList<>();
    DoUongAdapter adapterForYou;
    LoaiDoUongAdapter loaiDoUongAdapter;
    List<CategoryOfFood> categoryOfFoodList = new ArrayList<>();

    private void setAdapter() {
        adapter = new DoUongAdapter(getContext(), foodList);
        lv_food.setAdapter(adapter);
        adapterForYou = new DoUongAdapter(getContext(), foodForYou);
        lv_foryou.setAdapter(adapterForYou);
        loaiDoUongAdapter = new LoaiDoUongAdapter(getContext(), categoryOfFoodList);
        lv_category.setAdapter(loaiDoUongAdapter);

    }

    private void init(View view) {
        lv_food = view.findViewById(R.id.lv_food);
        lv_foryou = view.findViewById(R.id.lv_foryou);
        lv_category = view.findViewById(R.id.lv_category);
    }

    private void loadData() {

        ApiService.api.getCategoryList().enqueue(new Callback<List<CategoryOfFood>>() {
            @Override
            public void onResponse(Call<List<CategoryOfFood>> call, Response<List<CategoryOfFood>> response) {
                if (response.body() != null) {
                    for (CategoryOfFood category : response.body()
                    ) {
                        categoryOfFoodList.add(category);
                        loaiDoUongAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<CategoryOfFood>> call, Throwable t) {

            }
        });
        ApiService.api.getFoods("").enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                if (response.body() != null) {
                    for (Food food : response.body()
                    ) {
                        foodList.add(food);
                        adapter.notifyDataSetChanged();
                    }
                    if (foodList.size() >= 5) {
                        for (int i = 0; i < 5; i++) {
                            Collections.shuffle(foodList);
                            foodForYou.add(foodList.get(i));
                            adapterForYou.notifyDataSetChanged();
                        }
                    } else {
                        for (Food food : foodList
                        ) {
                            foodForYou.add(food);
                            adapterForYou.notifyDataSetChanged();
                        }

                    }

                }
            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {

            }
        });
    }
}
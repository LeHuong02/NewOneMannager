package com.example.newonemannager.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.newonemannager.API.ApiService;
import com.example.newonemannager.Activity.FoodListActivity;
import com.example.newonemannager.Models.CategoryOfFood;
import com.example.newonemannager.Models.Common;
import com.example.newonemannager.Models.Food;
import com.example.newonemannager.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoaiDoUongAdapter extends ArrayAdapter<CategoryOfFood> {
    List<CategoryOfFood> categoryOfFoodList;
    Context context;

    public LoaiDoUongAdapter(@NonNull Context context, List<CategoryOfFood> categoryOfFoodList) {
        super(context, 0, categoryOfFoodList);
        this.categoryOfFoodList = categoryOfFoodList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return categoryOfFoodList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_sanpham, parent, false);
        }
        TextView tv_ten = convertView.findViewById(R.id.tv_ten);
        ImageView img_hinhanh = convertView.findViewById(R.id.img_hinhanh);
        CategoryOfFood categoryOfFood = categoryOfFoodList.get(position);
        tv_ten.setText(categoryOfFood.getName());
        Glide.with(context).load(categoryOfFood.getImage()).error(R.drawable.coffee1).into(img_hinhanh);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CategoryOfFood category = categoryOfFoodList.get(position);
                Common.foodList = new ArrayList<>();
                ApiService.api.getFoods("").enqueue(new Callback<List<Food>>() {
                    @Override
                    public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                        if (response.body() != null) {
                            for (Food food : response.body()
                            ) {
                                if (food.getIDCategory() == category.getID()) {
                                    Common.foodList.add(food);
                                }
                            }
                            context.startActivity(new Intent(getContext(), FoodListActivity.class));
                        }
                    }

                    @Override
                    public void onFailure(Call<List<Food>> call, Throwable t) {

                    }
                });

            }
        });
        return convertView;
    }
}
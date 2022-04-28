package com.example.newonemannager.Activity;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newonemannager.Adapter.DoUongAdapter;
import com.example.newonemannager.Models.Common;
import com.example.newonemannager.R;

public class FoodListActivity extends AppCompatActivity {

    GridView lv_food;
    DoUongAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        lv_food = findViewById(R.id.lv_food);
        adapter = new DoUongAdapter(getApplicationContext(), Common.foodList);
        lv_food.setAdapter(adapter);
    }
}
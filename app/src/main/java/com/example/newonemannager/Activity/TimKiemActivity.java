package com.example.newonemannager.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newonemannager.API.ApiService;
import com.example.newonemannager.Adapter.DoUongAdapter;
import com.example.newonemannager.Models.Food;
import com.example.newonemannager.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TimKiemActivity extends AppCompatActivity {

    EditText edtTimKiem;
    GridView gv_food;
    DoUongAdapter adapter;
    List<Food> foodList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);
        gv_food = findViewById(R.id.lv_food);
        adapter = new DoUongAdapter(getApplicationContext(), foodList);
        gv_food.setAdapter(adapter);
        edtTimKiem = findViewById(R.id.edt_timkiem);
        edtTimKiem.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH) {
                    String searchString = edtTimKiem.getText().toString();
                    ApiService.api.getFoods(searchString).enqueue(new Callback<List<Food>>() {
                        @Override
                        public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                            if (response.body() != null) {
                                for (Food food : response.body()
                                ) {
                                    Log.e("TAG",food.getName());
                                    foodList.add(food);
                                    adapter.notifyDataSetChanged();
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<List<Food>> call, Throwable t) {

                        }
                    });
                    return true;
                }
                return false;
            }
        });
    }
}
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
import com.example.newonemannager.Activity.OrderActivity;
import com.example.newonemannager.Models.Common;
import com.example.newonemannager.Models.Food;
import com.example.newonemannager.R;

import java.util.List;

public class DoUongAdapter extends ArrayAdapter<Food> {
    List<Food> foodList;
    Context context;

    public DoUongAdapter(@NonNull Context context, List<Food> foodList) {
        super(context, 0, foodList);
        this.foodList = foodList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_sanpham, parent, false);
        }
        TextView tv_ten = convertView.findViewById(R.id.tv_ten);
        ImageView img_hinhanh = convertView.findViewById(R.id.img_hinhanh);
        Food food = foodList.get(position);
        tv_ten.setText(food.getName());
        Glide.with(context).load(food.getImage()).error(R.drawable.coffee1).into(img_hinhanh);
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Common.food = food;
                Intent intent = new Intent(context, OrderActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}

package com.example.newonemannager.Activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.newonemannager.Models.Cart;
import com.example.newonemannager.Models.Common;
import com.example.newonemannager.R;

import java.util.ArrayList;
import java.util.Random;

public class OrderActivity extends AppCompatActivity {

    ImageView img_hinhanh;
    TextView tv_ten;
    int[] gias = new int[]{20000, 25000, 30000, 35000, 40000, 45000, 50000};
    int so = 0;
    TextView tv_giatien;
    TextView tv_so;
    int gia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        init();
        gia = gias[new Random().nextInt(6)];
        tv_giatien.setText("đ0.0");
        tv_so.setText("0");
        if (Common.food != null) {
            tv_ten.setText(Common.food.getName());
            Glide.with(getApplicationContext()).load(Common.food.getImage()).into(img_hinhanh);
        }
        onClick();
    }

    private void init() {
        img_hinhanh = findViewById(R.id.image_hinhanh);
        tv_ten = findViewById(R.id.tv_ten);
        tv_giatien = findViewById(R.id.tv_giatien);
        tv_so = findViewById(R.id.tv_so);
    }

    private void onClick() {
        findViewById(R.id.btn_sangtrai).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.btn_cong).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                so++;
                tv_so.setText(so + "");
                tv_giatien.setText(Common.formatMoney(so * gia) + "");
            }
        });
        findViewById(R.id.btn_tru).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                so--;
                if (so < 0) {
                    so = 0;
                } else {

                    tv_so.setText(so + "");
                    tv_giatien.setText(Common.formatMoney(so * gia) + "");
                }
            }
        });
        findViewById(R.id.btn_giohang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Common.cartList == null) {
                    Common.cartList = new ArrayList<>();
                }

                String name = Common.food.getName();
                int price = gia;
                String image = Common.food.getImage();
                int quantity = so;
                Cart cart = new Cart(name, price, quantity, image);
                Common.cartList.add(cart);
                AlertDialog.Builder builder = new AlertDialog.Builder(OrderActivity.this);
                builder.setTitle("Thêm giỏ hàng thành công");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });

    }
}
package com.example.newonemannager.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newonemannager.Activity.PayActivity;
import com.example.newonemannager.Adapter.CartAdapter;
import com.example.newonemannager.Models.Cart;
import com.example.newonemannager.Models.Common;
import com.example.newonemannager.R;


public class VerificationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verification, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        anhXa(view);
        loadGioHang();
        btn_dathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), PayActivity.class));
            }
        });
    }

    RecyclerView lv_giohang;
    TextView tv_sum;
    Button btn_dathang;
    CartAdapter cartAdapter;

    private void loadGioHang() {
        if (Common.cartList != null) {
            cartAdapter = new CartAdapter(getContext());
            lv_giohang.setAdapter(cartAdapter);
            int tong = 0;
            for (Cart cart : Common.cartList
            ) {
                tong += cart.getSum();
            }
            tv_sum.setText(tong + " vnd");
        }


    }


    private void anhXa(View view) {
        lv_giohang = view.findViewById(R.id.lv_giohang);
        tv_sum = view.findViewById(R.id.tv_sum);
        btn_dathang = view.findViewById(R.id.btn_muahang);
    }
}
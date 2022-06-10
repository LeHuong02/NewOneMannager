package com.example.newonemannager.Activity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newonemannager.Adapter.CartAdapter;
import com.example.newonemannager.Models.Cart;
import com.example.newonemannager.Models.Common;
import com.example.newonemannager.R;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class PayActivity extends AppCompatActivity {

    FusedLocationProviderClient locationProviderClient;
    Geocoder geocoder;
    List<Address> addresses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        anhXa();
        loadGioHang();
        onClick();
        requestPermission();

    }

    RecyclerView lv_giohang;
    TextView tv_sum;
    Button btn_dathang;
    CartAdapter cartAdapter;
    EditText edt_address, edt_phone_number, edt_note;

    private void onClick() {
        findViewById(R.id.btn_position).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCurrentAddress();
            }
        });
        btn_dathang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Common.cartList.clear();
                Toast.makeText(getApplicationContext(), "Đặt thành công", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
    }

    //get vi tri hien tai
    @SuppressLint("MissingPermission")
    private void getCurrentAddress() {
        locationProviderClient = LocationServices.getFusedLocationProviderClient(this);
        geocoder = new Geocoder(this, Locale.getDefault());
        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

        }
        locationProviderClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null) {
                    double lat = location.getLatitude();
                    double lng = location.getLongitude();
                    try {
                        addresses = geocoder.getFromLocation(lat, lng, 1);
                        String addressLine1 = addresses.get(0).getAddressLine(0);
                        String city = addresses.get(0).getLocality();
                        String state = addresses.get(0).getAdminArea();

                        String fullAddress = addressLine1 + ",  " + city + ",  " + state;
                        edt_address.setText(fullAddress);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private void loadGioHang() {
        if (Common.cartList != null) {
            cartAdapter = new CartAdapter(getApplicationContext());
            lv_giohang.setAdapter(cartAdapter);
            int tong = 0;
            for (Cart cart : Common.cartList
            ) {
                tong += cart.getSum();
            }
            tv_sum.setText(tong + " vnd");
        }


    }


    private void anhXa() {
        lv_giohang = findViewById(R.id.lv_giohang);
        tv_sum = findViewById(R.id.tv_sum_final);
        btn_dathang = findViewById(R.id.btn_buy);
        edt_address = findViewById(R.id.edt_address);
        edt_phone_number = findViewById(R.id.edt_phone_number);
        edt_note = findViewById(R.id.edt_note);
    }
}
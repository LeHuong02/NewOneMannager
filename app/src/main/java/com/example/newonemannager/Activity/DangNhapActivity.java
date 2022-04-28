package com.example.newonemannager.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newonemannager.API.ApiService;
import com.example.newonemannager.Models.Account;
import com.example.newonemannager.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DangNhapActivity extends AppCompatActivity {

    EditText edt_taikhoan, edt_matkhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        edt_taikhoan = findViewById(R.id.edit_taikhoan_dangnhap);
        edt_matkhau = findViewById(R.id.edit_matkhau_dangnhap);
        findViewById(R.id.btn_dangky_dangnhap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DangKyActivity.class));
            }
        });
        findViewById(R.id.btn_dangnhap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), TrangChuActivity.class));
                ProgressDialog dialog = new ProgressDialog(DangNhapActivity.this);
                dialog.setTitle("Đang đăng nhập");
                dialog.show();
                ApiService.api.login(edt_taikhoan.getText().toString(), edt_matkhau.getText().toString()).enqueue(new Callback<Account>() {
                    @Override
                    public void onResponse(Call<Account> call, Response<Account> response) {
                        dialog.dismiss();
                        if (response.body() != null) {
                            startActivity(new Intent(getApplicationContext(), TrangChuActivity.class));
                        } else {
                            Toast.makeText(getApplicationContext(), "Tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_LONG).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Account> call, Throwable t) {

                    }
                });
            }
        });
    }
}
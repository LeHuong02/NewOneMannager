package com.example.newonemannager.Activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newonemannager.API.ApiService;
import com.example.newonemannager.Models.Account;
import com.example.newonemannager.Models.Customer;
import com.example.newonemannager.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DangKyActivity extends AppCompatActivity {
    EditText edit_taikhoan_hoten, edt_taikhoan, edt_matkhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);

        edit_taikhoan_hoten = findViewById(R.id.edit_taikhoan_hoten);
        edt_taikhoan = findViewById(R.id.edt_taikhoan);
        edt_matkhau = findViewById(R.id.edt_matkhau);
        findViewById(R.id.btn_trolai).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        findViewById(R.id.btn_dangky).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog dialog = new ProgressDialog(DangKyActivity.this);
                dialog.setTitle("Vui lòng chờ");
                dialog.show();
                Account account = new Account(edt_taikhoan.getText().toString(), edt_matkhau.getText().toString(), Byte.parseByte("0"));
                ApiService.api.postAccount(account).enqueue(new Callback<Integer>() {
                    @Override
                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                        if (response.body() != null) {
                            if (response.body() > 0) {
                                Customer customer = new Customer(edit_taikhoan_hoten.getText().toString(), 0, account.getUsername());
                                ApiService.api.postCustomer(customer).enqueue(new Callback<Integer>() {
                                    @Override
                                    public void onResponse(Call<Integer> call, Response<Integer> response) {
                                        if (response.body() != null) {
                                            if (response.body() > 0) {
                                                dialog.dismiss();
                                                Toast.makeText(getApplicationContext(), "Đăng ký tài khoản thành công", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<Integer> call, Throwable t) {
                                        dialog.dismiss();
                                    }
                                });
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<Integer> call, Throwable t) {
                        dialog.dismiss();
                    }
                });

            }
        });
    }
}
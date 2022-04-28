package com.example.newonemannager.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.newonemannager.Adapter.MenuAdapter;
import com.example.newonemannager.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TrangChuActivity extends AppCompatActivity {
    ViewPager view_main;
    BottomNavigationView view_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trang_chu);
        init();
        setViewLogin();
        setSwichNav();
    }
    private void init() {
        view_main = findViewById(R.id.view_main);
        view_nav = findViewById(R.id.nav_main);
    }

    private void setViewLogin() {
        MenuAdapter adapter = new MenuAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        view_main.setAdapter(adapter);
        view_main.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        view_nav.getMenu().findItem(R.id.trangchu).setChecked(true);
                        break;
                    case 1:
                        view_nav.getMenu().findItem(R.id.giohang).setChecked(true);
                        break;
                    case 2:
                        view_nav.getMenu().findItem(R.id.veri).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setSwichNav() {
        view_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.trangchu:
                        view_main.setCurrentItem(0);
                        break;
                    case R.id.giohang:
                        view_main.setCurrentItem(1);
                        break;
                    case R.id.veri:
                        view_main.setCurrentItem(2);
                        break;
                }
                return true;
            }
        });
    }
}
package com.example.newonemannager.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.newonemannager.Fragments.HomeFragment;
import com.example.newonemannager.Fragments.OrderFragment;
import com.example.newonemannager.Fragments.VerificationFragment;

public class MenuAdapter extends FragmentStatePagerAdapter {
    public MenuAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new OrderFragment();
            case 2:
                return new VerificationFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
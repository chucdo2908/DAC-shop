package com.example.shopgiay;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewpagerAdapter extends FragmentStatePagerAdapter {


    public ViewpagerAdapter(@NonNull FragmentManager fragmentManager, int lifecycle) {
        super(fragmentManager, lifecycle);
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Fragment_home();
            case 1:
                return new Fragment_thongbao();
            case 2:
                return new Fragment_giohang();
            case 3:
                return new Fragment_canhan();
            default:
                return new Fragment_home();
        }
    }



    @Override
    public int getCount() {
        return 4;
    }
}

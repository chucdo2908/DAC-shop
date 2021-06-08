package com.example.shopgiay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Trangchu extends AppCompatActivity  {
    private BottomNavigationView nav;
    private ViewPager ViewP ;
    connection conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        nav = findViewById(R.id.navl);
        ViewP = findViewById(R.id.viewpger);
        LoadViewpager();
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.H :

                        ViewP.setCurrentItem(0);
                        break;

                    case R.id.TB :
                        ViewP.setCurrentItem(1);
                        break;
                    case R.id.GH :
                        ViewP.setCurrentItem(2);
                        break;
                    case R.id.CN :
                        ViewP.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });

    }
    public void  LoadViewpager(){

        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager() , FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        ViewP.setAdapter(viewpagerAdapter);
        ViewP.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0 :
                        nav.getMenu().findItem(R.id.H).setChecked(true);
                        break;
                    case 1 :
                        nav.getMenu().findItem(R.id.TB).setChecked(true);
                        break;
                    case 2 :
                        nav.getMenu().findItem(R.id.GH).setChecked(true);
                        break;
                    case 3 :
                        nav.getMenu().findItem(R.id.CN).setChecked(true);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}
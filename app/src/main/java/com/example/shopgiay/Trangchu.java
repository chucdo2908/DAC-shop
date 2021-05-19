package com.example.shopgiay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Trangchu extends AppCompatActivity {
    BottomNavigationView nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        nav = findViewById(R.id.navl);
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.H :
                        Toast.makeText(getApplicationContext(),"oke" , Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.TB :
                        Toast.makeText(getApplicationContext(),"thông báo" , Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.GH :
                        Toast.makeText(getApplicationContext(),"Giỏ hàng" , Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.CN :
                        Toast.makeText(getApplicationContext(),"cá nhân" , Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
}
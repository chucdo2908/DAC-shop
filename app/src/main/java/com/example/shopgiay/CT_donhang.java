package com.example.shopgiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class CT_donhang extends AppCompatActivity {
    int id ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_t_donhang);
        Intent i = getIntent();
        id = i.getIntExtra("id" , 0);

    }
}
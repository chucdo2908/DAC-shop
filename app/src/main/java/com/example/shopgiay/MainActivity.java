package com.example.shopgiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main = findViewById(R.id.main);
        main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(main == v){
                    Intent in = new Intent(MainActivity.this , Trangchu.class);
                    startActivity(in);
                }else {
                    Toast.makeText(getApplication(),"lỗi",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
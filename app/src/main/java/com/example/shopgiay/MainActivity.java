package com.example.shopgiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Animation top_anim,bottomAmin;
    private static int SPLASH_SCREEN =3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        top_anim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAmin = AnimationUtils.loadAnimation(this, R.anim.boton_animation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Trangchu.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN);
    }
}
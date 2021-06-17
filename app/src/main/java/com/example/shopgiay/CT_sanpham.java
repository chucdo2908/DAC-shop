package com.example.shopgiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;

public class CT_sanpham extends AppCompatActivity {
    private TextView gia , ten , size , soluong , thongtin ;
    private ImageView anh;
    private Button Mua;
    private int id;
    private String Ten  , Size , Thongtin,Anh,Gia , Soluong;
    private int id_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_t_sanpham);
        anhxa();
        Intent i = getIntent();
        id = i.getIntExtra("id",0);
        connection conn = new connection(getApplicationContext(),"DACshop",null,1);
        Cursor cursor = conn.GetData("SELECT * FROM SP WHERE ID = " + id + "");
        if(cursor.getCount()!=0){
           while (cursor.moveToNext()){
               Ten = cursor.getString(1);
               Gia = cursor.getString(6);
               Size = cursor.getString(4);
               Soluong = cursor.getString(5);
               Thongtin = cursor.getString(3);
               Anh = cursor.getString(7);
           }
        }else {
            Toast.makeText(getApplicationContext(),"lỗi",Toast.LENGTH_SHORT).show();
        }
        ten.setText(Ten);
        size.setText(Size);
        gia.setText(Gia+ "đ");
        soluong.setText(Soluong);
        thongtin.setText(Thongtin);
        Glide.with(getApplicationContext()).load(Anh).into(anh);
        Mua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Mua.setBackgroundResource(R.drawable.bg_cho);
            }
        });
    }
    public void anhxa(){
        Mua = findViewById(R.id.muahang);
        ten = findViewById(R.id.tensp);
        gia = findViewById(R.id.gia_sp);
        size = findViewById(R.id.size_sp);
        soluong = findViewById(R.id.soluong_sp);
        thongtin = findViewById(R.id.thongtin_sp);
        anh = findViewById(R.id.hinhanh);

    }
}
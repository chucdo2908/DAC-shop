package com.example.shopgiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class XemthongtinUsers extends AppCompatActivity {
    TextView ten , diachi , sdt , ngaysinh , taikhoan;
    Button thoat;
    int id ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xemthongtin_users);
        anhxa();
        Intent in = getIntent();
        String tk = in.getStringExtra("tk_use");
        connection conn = new connection(getApplicationContext(),"DACshop",null,1);
        Cursor cursor = conn.GetData("SELECT * FROM TK_User WHERE Taikhoan = '" + tk + "'");
        while (cursor.moveToNext()){
            taikhoan.setText(cursor.getString(1));
            id = cursor.getInt(0);
            Cursor cursor1 = conn.GetData("SELECT * FROM TT_Users WHERE ID_TK = " + id + "");
            while(cursor1.moveToNext()){
                ten.setText(cursor1.getString(2));
                diachi.setText(cursor1.getString(3));
                sdt.setText(cursor1.getString(4));
                ngaysinh.setText(cursor1.getString(5));
            }
        }
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XemthongtinUsers.this,Trangchu.class);
                intent.putExtra("ten_tk" , tk);
                intent.putExtra("id_user" , id);
                startActivity(intent);
            }
        });

    }
    public void anhxa(){
        ten = findViewById(R.id.Ten_use);
        diachi = findViewById(R.id.diachi_use);
        sdt = findViewById(R.id.sdt_use);
        ngaysinh = findViewById(R.id.ngaysinh_use);
        taikhoan = findViewById(R.id.taikhoan_use);
        thoat = findViewById(R.id.xacnhan_use);
    }
}
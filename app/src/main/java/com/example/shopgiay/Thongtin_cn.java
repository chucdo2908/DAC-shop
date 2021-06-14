package com.example.shopgiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Thongtin_cn extends AppCompatActivity {
    TextView txt_ten , txt_dc , txt_sdt,txt_ns;
    Button btn_xacnhan;
    String TK="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin_cn);
        anhxa();
        Intent i = getIntent();
        TK = i.getStringExtra("tk");
        connection conn = new connection(getApplicationContext(),"DACshop",null,1);
        Cursor cursor = conn.GetData("SELECT * FROM TK_User WHERE Taikhoan = '" + TK + "'");
        btn_xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cursor.getCount()!=0){
                    while (cursor.moveToNext()){
                        int id = cursor.getInt(0);
                        String ten = txt_ten.getText().toString();
                        String diachi = txt_dc.getText().toString();
                        String sdt = txt_sdt.getText().toString();
                        String ngaysinh = txt_ns.getText().toString();
                        conn.QueryData("CREATE TABLE IF NOT EXISTS TT_Users" + "(ID INTEGER PRIMARY KEY AUTOINCREMENT ,ID_TK INTEGER, Ten_user VARCHAR ," +
                                " Diachi VARCHAR ,SDT VARCHAR ,Ngaysinh Date ," +
                                "FOREIGN KEY(ID_TK)  REFERENCES TK_User(ID_TK) )");
                        try {
                            conn.Querythongtin( id,ten, diachi,sdt,ngaysinh);
                            Toast.makeText(getApplicationContext(),"Cập nhật thành công !!",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(Thongtin_cn.this,Trangchu.class);
                            startActivity(intent);
                        } catch (Exception e) {
                            Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
                        }
                    }

                }else {
                    Toast.makeText(getApplicationContext(),"Lỗi",Toast.LENGTH_SHORT).show();
                }
            }
        });



    }
    public void anhxa(){
        txt_ten = findViewById(R.id.Ten);
        txt_dc = findViewById(R.id.diachi);
        txt_sdt = findViewById(R.id.SDT);
        txt_ns = findViewById(R.id.ngaysinh);
        btn_xacnhan = findViewById(R.id.xacnhan);

    }
}
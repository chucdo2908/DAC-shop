package com.example.shopgiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.LENGTH_LONG;

public class dangnhap_dangky extends AppCompatActivity {
    private EditText txt_mk , txt_tk;
    private TextView quen_mk;
    private Button btn_dn , btn_dk;
    int id_use;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap_dangky);
        anhxa();
        connection conn = new connection(getApplicationContext(),"DACshop",null,1);
        btn_dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_dk.setBackgroundResource(R.drawable.bg_tt);
                Intent intent = new Intent(getApplicationContext() , Dangky_user.class);
               startActivity(intent);
            }
        });
        btn_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn_dn.setBackgroundResource(R.drawable.bg_tt);
                String a = txt_tk.getText().toString();
                String b = txt_mk.getText().toString();
                if(a.equals("") || b.equals("")){
                    Toast.makeText(getApplicationContext(),"Chưa nhập tài khoản hoặc mật khẩu !!", Toast.LENGTH_SHORT).show();
                    btn_dn.setBackgroundResource(R.drawable.bg_tktt);
                }else {
                    Cursor cursor = conn.GetData("SELECT * FROM TK_User WHERE Taikhoan = '" + a + "' AND " + " Matkhau = '" + b + "'");
                    if(cursor.getCount()!=0){
                        while (cursor.moveToNext()){
                            id_use = cursor.getInt(0);
                        }
                        Toast.makeText(getApplicationContext(),"Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(dangnhap_dangky.this,Trangchu.class);
                        intent.putExtra("ten_tk" , a);
                        intent.putExtra("id_user" , id_use);
                       startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(),"Tài khoản hoặc mật khẩu không chính xác", Toast.LENGTH_SHORT).show();
                        txt_tk.setText("");
                        txt_mk.setText("");
                        btn_dn.setBackgroundResource(R.drawable.bg_tktt);
                    }
                }
            }
        });
    }
    public void anhxa(){
        txt_tk = findViewById(R.id.taikhoan);
        txt_mk = findViewById(R.id.matkhau);
        quen_mk = findViewById(R.id.quen_mk);
        btn_dk = findViewById(R.id.btn_dk);
        btn_dn = findViewById(R.id.btn_dn);
    }
}
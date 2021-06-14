package com.example.shopgiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Dangky_user extends AppCompatActivity {
    private EditText dk_tk ,dk_mk , NL_mk;
    private TextView quaylai;
    private Button xacnhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky_user);
        anhxa_dk();
        connection conn = new connection(getApplicationContext(),"DACshop",null,1);
        conn.QueryData("CREATE TABLE IF NOT EXISTS TK_User" +
                "(ID_tk INTEGER PRIMARY KEY AUTOINCREMENT , Taikhoan VARCHAR , Matkhau VARCHAR  )");
        quaylai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quaylai.setTextColor(R.drawable.bg_tktt);
                Intent intent = new Intent(getApplicationContext(),dangnhap_dangky.class);
                startActivity(intent);
            }
        });
        xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tk = dk_tk.getText().toString();
                String mk = dk_mk.getText().toString();
                String nl_mk = NL_mk.getText().toString();
                if(tk.equals("") && mk.equals("") && nl_mk.equals("")){
                    Toast.makeText(getApplicationContext(),"chưa nhập đủ thông tin !!",Toast.LENGTH_SHORT).show();
                }else if (!mk.toString().equals(nl_mk.toString())){
                    Toast.makeText(getApplicationContext(),"Mật khẩu không khớp !!",Toast.LENGTH_SHORT).show();
                }else{
                    try {
                        conn.QueryUser( tk, mk);
                        Toast.makeText(getApplicationContext(),"Đăng kí thành công !!",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),dangnhap_dangky.class);
                        startActivity(intent);
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });
    }
    public void anhxa_dk(){
        dk_tk = findViewById(R.id.dk_tk);
        dk_mk = findViewById(R.id.dk_mk);
        NL_mk = findViewById(R.id.NL_matkhau);
        quaylai = findViewById(R.id.quaylai);
        xacnhan = findViewById(R.id.btn_xacnhan);
    }
}
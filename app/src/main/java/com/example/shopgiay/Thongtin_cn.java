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
   private TextView txt_ten , txt_dc , txt_sdt,txt_ns;
   private Button btn_xacnhan,quayve;
   private String TK="";
   private int id;
   private String ten , diachi , sdt , ngaysinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongtin_cn);
        anhxa();
        Intent i = getIntent();
        TK = i.getStringExtra("tk");
        connection conn = new connection(getApplicationContext(), "DACshop", null, 1);
        Cursor cursor = conn.GetData("SELECT * FROM TK_User WHERE Taikhoan = '" + TK + "'");
        conn.QueryData("CREATE TABLE IF NOT EXISTS TT_Users" + "(ID INTEGER PRIMARY KEY AUTOINCREMENT ,ID_TK INTEGER, Ten_user VARCHAR ," +
                " Diachi VARCHAR ,SDT VARCHAR ,Ngaysinh Date ," +
                "FOREIGN KEY(ID_TK)  REFERENCES TK_User(ID_TK) )");
        if (cursor.getCount() != 0) {
            while (cursor.moveToNext()) {
                id = cursor.getInt(0);
            }
            Cursor cursor1 = conn.GetData("SELECT * FROM TT_Users Where ID_TK = '" + id + "'");
            if (cursor1.getCount() != 0) {
                while (cursor1.moveToNext()){
                    ///hiển thị thông tin cá nhân nếu có .....
                    txt_ten.setText(cursor1.getString(2));
                    txt_dc.setText(cursor1.getString(3));
                    txt_sdt.setText(cursor1.getString(4));
                    txt_ns.setText(cursor1.getString(5));
                }
            } else {
                btn_xacnhan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ten = txt_ten.getText().toString();
                        diachi = txt_dc.getText().toString();
                        sdt = txt_sdt.getText().toString();
                        ngaysinh = txt_ns.getText().toString();
                        conn.Querythongtin(id, ten, diachi, sdt, ngaysinh);
                        Toast.makeText(getApplicationContext(), "Cập nhật thành công !!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Thongtin_cn.this, Trangchu.class);
                        intent.putExtra("ten_tk", TK);
                        intent.putExtra("id_user" , id);
                        startActivity(intent);
                    }
                });
            }
        } else {
            Toast.makeText(getApplicationContext(), "Lỗi", Toast.LENGTH_SHORT).show();
        }
        quayve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Thongtin_cn.this, Trangchu.class);
                intent.putExtra("ten_tk", TK);
                intent.putExtra("id_user" , id);
                startActivity(intent);
            }
        });
    }
    public void anhxa(){
        txt_ten = findViewById(R.id.Ten);
        txt_dc = findViewById(R.id.diachi);
        txt_sdt = findViewById(R.id.SDT);
        txt_ns = findViewById(R.id.ngaysinh);
        btn_xacnhan = findViewById(R.id.xacnhan);
        quayve = findViewById(R.id.quayve);

    }
}
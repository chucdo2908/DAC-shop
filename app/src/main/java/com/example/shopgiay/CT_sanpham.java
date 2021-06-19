package com.example.shopgiay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CT_sanpham extends AppCompatActivity {
    private TextView gia , ten , size , soluong , thongtin ;
    private EditText slmua;
    private ImageView anh;
    private Button Mua;
    private int id;
    private String Ten  , Size , Thongtin,Anh,Gia , Soluong , soluongmua;
    private int id_user;
    private String Ten_use , diachi , sdt ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_t_sanpham);
        anhxa();
        Intent i = getIntent();
        id = i.getIntExtra("id",0);
        id_user = i.getIntExtra("id_use",0);
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
                Cursor cursor1 = conn.GetData("SELECT * FROM TT_Users WHERE ID_TK = " + id_user + "");
                if(cursor1.getCount()!=0){
                    while (cursor1.moveToNext()) {
                        Ten_use = cursor1.getString(2);
                        diachi = cursor1.getString(3);
                        sdt = cursor1.getString(4);
                    }
                    // dữ liệu thêm vào bảng....
                        DateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy  hh : mm : ss");
                        dateFormatter.setLenient(false);
                        Date currentTime = Calendar.getInstance().getTime();
                        String ngaymua = dateFormatter.format(currentTime);
                        int size_sp = Integer.parseInt(size.getText().toString());
                        int soluong_sp = Integer.parseInt(soluong.getText().toString());
                        int soluongmua = Integer.parseInt(slmua.getText().toString());
                        float Giasp = Float.parseFloat(Gia);
                        float tonggia = soluongmua*Giasp;
                        int soluongcon = soluong_sp - soluongmua;
                        String ten_use = Ten_use;
                        String diachi_use = diachi;
                        String sdt_use = sdt;
                        conn.QueryData("CREATE TABLE IF NOT EXISTS DonHang" +
                                "(ID_DH INTEGER PRIMARY KEY AUTOINCREMENT ,ID INTEGER,ID_TK INTEGER, Ten_sp VARCHAR" +
                                " , Soluongmua INTERGER , Tonggia Float , Size INTRGER , Ten_use VARCHAR , Diachi VARCHAR" +
                                ",sdt VARCHAR , NgayMua Date , FOREIGN KEY(ID_TK)  REFERENCES TK_User(ID_TK)," +
                                "FOREIGN KEY(ID)  REFERENCES SP(ID))");
                    try {
                        conn.QueryDonHang(id,id_user,Ten , soluongmua , tonggia , size_sp , ten_use , diachi_use , sdt_use , ngaymua);
                        Toast.makeText(getApplicationContext(), "Đã đặt hàng !!", Toast.LENGTH_SHORT).show();
                        conn.QueryData("UPDATE SP SET Soluong = "+soluongcon+" Where ID =" + id + " ");
                        Mua.setBackgroundResource(R.drawable.bg_tktt);
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Mua.setBackgroundResource(R.drawable.bg_tktt);
                    Toast.makeText(getApplicationContext(),"bạn chưa đăng nhập hoặc cập nhật thông tin",Toast.LENGTH_SHORT).show();
                }
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
        slmua = findViewById(R.id.soluongmua);


    }
}
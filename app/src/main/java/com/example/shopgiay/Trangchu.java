package com.example.shopgiay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Trangchu extends AppCompatActivity {
    ListView list ;
    ArrayList<sanpham> arrayList = new ArrayList<>();;
    list_sp product ;
    private BottomNavigationView nav;
    private ViewPager ViewP ;
    connection db = new connection(this,"DACshop.sqlite" , null, 1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        product = new list_sp(this, R.layout.listviewtt, arrayList);
        list = findViewById(R.id.list);
        list.setAdapter(product);
        loadata();
        nav = findViewById(R.id.navl);
        ViewP = findViewById(R.id.viewpger);
        LoadViewpager();
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.H :
                        ViewP.setCurrentItem(0);
                        break;

                    case R.id.TB :
                        ViewP.setCurrentItem(1);
                        break;
                    case R.id.GH :
                        ViewP.setCurrentItem(2);
                        break;
                    case R.id.CN :
                        ViewP.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });

    }
    public void  LoadViewpager(){

        ViewpagerAdapter viewpagerAdapter = new ViewpagerAdapter(getSupportFragmentManager() , FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        ViewP.setAdapter(viewpagerAdapter);
        ViewP.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0 :
                        nav.getMenu().findItem(R.id.H).setChecked(true);
                        break;
                    case 1 :
                        nav.getMenu().findItem(R.id.TB).setChecked(true);
                        break;
                    case 2 :
                        nav.getMenu().findItem(R.id.GH).setChecked(true);
                        break;
                    case 3 :
                        nav.getMenu().findItem(R.id.CN).setChecked(true);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public  void loadata(){
        db.QueryData("CREATE TABLE IF NOT EXISTS sanpham" +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT , Ten_sp VARCHAR , Hang_sp VARCHAR ,Thongt_sp VARCHAR ,Size INTEGER , Soluong INTEGER,Gia INTEGER ,Img VARCHAR )");
//        db.QueryData("INSERT INTO sanpham VALUES(null,'nike1','nike','hàng đẹp',42,30,500000,'344334')");
//        db.QueryData("INSERT INTO sanpham VALUES(null,'nike2','nike','hàng đẹp',41,30,500000,'344343534')");
//        db.QueryData("INSERT INTO sanpham VALUES(null,'nike3','nike','hàng đẹp',43,30,550000,'3443435343434')");

        Cursor cursorSP = db.getData("SELECT * FROM sanpham");
        while (cursorSP.moveToNext()){
           int id = cursorSP.getInt(0);
           String ten = cursorSP.getString(1);
           String hang = cursorSP.getString(2);
           String thongtin = cursorSP.getString(3);
           int size = cursorSP.getInt(4);
           int soluong = cursorSP.getInt(5);
            int gia = cursorSP.getInt(6);
           String img = cursorSP.getString(7);
            sanpham sp = new sanpham(id, ten, hang, thongtin, size, soluong, gia, img);
           arrayList.add(sp);
        }
        product.notifyDataSetChanged();
    }
}
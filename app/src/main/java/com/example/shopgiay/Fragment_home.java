package com.example.shopgiay;

import android.database.Cursor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class Fragment_home extends Fragment    {
    private Trangchu trangchu;
    ListView list ;
    ArrayList<sanpham> arrayList = new ArrayList<>();
    list_sp product ;
    private ViewPager viewpager;
    private CircleIndicator circleIndicator;
    private slideAdapter adapter;
    private List<slide> list_slide;
    private Timer timer;
    private TextView sapxep , danhsach , dangbang;
    private EditText E_timkiem;
    private Button timkiem;


    public  Fragment_home() {

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home , container , false);
        //load slide ...
        viewpager = view.findViewById(R.id.viewpager1);
        circleIndicator = view.findViewById(R.id.Cir);
        list_slide = getListphoto();
        adapter = new slideAdapter(getContext(), list_slide);
        viewpager.setAdapter(adapter);
        circleIndicator.setViewPager(viewpager);
        adapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        autoslide();

        //chức năng
        sapxep = view.findViewById(R.id.sapxep);
        danhsach = view.findViewById(R.id.danhsach);
        dangbang = view.findViewById(R.id.dangbang);
        E_timkiem = view.findViewById(R.id.timkiem);
        timkiem = view.findViewById(R.id.btntk);
        sapxep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sapxep.setBackgroundResource(R.drawable.bg_tt);
            }
        });
        danhsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                danhsach.setBackgroundResource(R.drawable.bg_tt);

            }
        });
        dangbang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dangbang.setBackgroundResource(R.drawable.bg_tt);
            }
        });
        timkiem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timkiem.setBackgroundResource(R.drawable.bg_tktt);
                String tk = E_timkiem.getText().toString();
                if(tk.equals("")){
                    //load dữ liệu trang chủ
                    connection conn = new connection(getContext(),"DACshop",null,1);
                    trangchu = (Trangchu) getActivity();
                    list = view.findViewById(R.id.listt);
                    arrayList = new ArrayList<sanpham>();
                    product = new list_sp(getActivity(), R.layout.listviewtt , arrayList);
                    list.setAdapter(product);

//       conn.QueryData("CREATE TABLE IF NOT EXISTS SP" +
//               "(ID INTEGER PRIMARY KEY AUTOINCREMENT , Ten_sp VARCHAR , Hang_sp VARCHAR ,Thongt_sp VARCHAR ,Size INTEGER , Soluong INTEGER,Gia INTEGER ,Img BLOB )");
//   //    conn.QueryData("INSERT INTO SP VALUES(null,'nike2','nike','hàng đẹp',42,30,500000,1)");
//    conn.QueryData("INSERT INTO SP VALUES(null,'MLB1','MLB','hàng đẹp',41,30,500000,'R.drawable.mlb.jpg')");
//      conn.QueryData("INSERT INTO SP VALUES(null,'ADIDAS YEEZY 350 V2','Adidas','hàng đẹp',42,30,600000,'https://giaygiare.vn/upload/sanpham/thumbs/adidas-yeezy-350-v2-sand-taupe-1-1.jpg')");

                    Cursor cursorSP = conn.GetData("SELECT * FROM SP");
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
////        init();
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            view.setBackgroundResource(R.drawable.bg_tt);
                            Toast.makeText(getActivity(),arrayList.get(position).Ten_sp ,Toast.LENGTH_SHORT).show();
                        }
                    });
                    timkiem.setBackgroundResource(R.drawable.bg_cho);
                }else {
                    connection conn = new connection(getContext(),"DACshop",null,1);
                    trangchu = (Trangchu) getActivity();
                    list = view.findViewById(R.id.listt);
                    arrayList = new ArrayList<sanpham>();
                    product = new list_sp(getActivity(), R.layout.listviewtt , arrayList);
                    list.setAdapter(product);
                    Cursor cursorSP = conn.GetData("SELECT * FROM SP Where Ten_sp = '"+ tk + "'");
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
                    timkiem.setBackgroundResource(R.drawable.bg_cho);
                }



            }
        });

        //load dữ liệu trang chủ
        connection conn = new connection(getContext(),"DACshop",null,1);
        trangchu = (Trangchu) getActivity();
        list = view.findViewById(R.id.listt);
        arrayList = new ArrayList<sanpham>();
        product = new list_sp(getActivity(), R.layout.listviewtt , arrayList);
        list.setAdapter(product);

//       conn.QueryData("CREATE TABLE IF NOT EXISTS SP" +
//               "(ID INTEGER PRIMARY KEY AUTOINCREMENT , Ten_sp VARCHAR , Hang_sp VARCHAR ,Thongt_sp VARCHAR ,Size INTEGER , Soluong INTEGER,Gia INTEGER ,Img BLOB )");
//   //    conn.QueryData("INSERT INTO SP VALUES(null,'nike2','nike','hàng đẹp',42,30,500000,1)");
//    conn.QueryData("INSERT INTO SP VALUES(null,'MLB1','MLB','hàng đẹp',41,30,500000,'R.drawable.mlb.jpg')");
//      conn.QueryData("INSERT INTO SP VALUES(null,'ADIDAS YEEZY 350 V2','Adidas','hàng đẹp',42,30,600000,'https://giaygiare.vn/upload/sanpham/thumbs/adidas-yeezy-350-v2-sand-taupe-1-1.jpg')");

       Cursor cursorSP = conn.GetData("SELECT * FROM SP");
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
////        init();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundResource(R.drawable.bg_tt);
                Toast.makeText(getActivity(),arrayList.get(position).Ten_sp ,Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
    private List<slide> getListphoto(){
        List<slide> list = new ArrayList<>();
        list.add(new slide(R.drawable.silde1));
        list.add(new slide(R.drawable.silde1));
        list.add(new slide(R.drawable.silde1));
        return list ;
    }
    private  void autoslide(){
        if(list_slide == null || list_slide.isEmpty() || viewpager == null){
            return ;
        }
        if(timer == null){
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        @Override
                        public void run() {
                            int img = viewpager.getCurrentItem();
                            int total = list_slide.size() - 1;
                            if (img < total){
                                img ++;
                                viewpager.setCurrentItem(img);
                            } else {
                                viewpager.setCurrentItem(0);
                            }
                        }
                    });
            }
        },500 , 3000);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(timer != null){
            timer.cancel();
            timer = null;
        }
    }

}

package com.example.shopgiay;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.sql.Connection;
import java.util.ArrayList;

public class Fragment_home extends Fragment  {
    ListView list ;
    ArrayList<sanpham> arrayList = new ArrayList<>();
    list_sp product ;
//    connection db = new connection(getContext(),"shopgiay.sqlite" , null, 1);

    public Fragment_home(){

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home , container , false);
        list = view.findViewById(R.id.listt);
        arrayList = new ArrayList<sanpham>();
        product = new list_sp(getActivity(), R.layout.listviewtt , arrayList);
        list.setAdapter(product);
        arrayList.add(new sanpham(1,"nike1","nike","hàng đẹp",42,30,500000,"344334"));
        arrayList.add(new sanpham(2,"MLB","MLB","hàng đẹp",42,30,600000,"344334"));
        arrayList.add(new sanpham(3,"vans","vans","hàng đẹp",41,30,400000,"344334"));
        arrayList.add(new sanpham(4,"nike1","nike","hàng đẹp",42,30,500000,"344334"));
        arrayList.add(new sanpham(5,"nike1","nike","hàng đẹp",42,30,500000,"344334"));
        arrayList.add(new sanpham(6,"nike1","nike","hàng đẹp",42,30,500000,"344334"));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),arrayList.get(position).toString() ,Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }

//    public  void loadata(){
//        db.QueryData("CREATE TABLE IF NOT EXISTS SP" +
//                "(ID INTEGER PRIMARY KEY AUTOINCREMENT , Ten_sp VARCHAR , Hang_sp VARCHAR ,Thongt_sp VARCHAR ,Size INTEGER , Soluong INTEGER,Gia INTEGER ,Img VARCHAR )");
//           db.QueryData("INSERT INTO sanpham VALUES(null,'nike1','nike','hàng đẹp',42,30,500000,'344334')");
////        db.QueryData("INSERT INTO sanpham VALUES(null,'nike2','nike','hàng đẹp',41,30,500000,'344343534')");
////        db.QueryData("INSERT INTO sanpham VALUES(null,'nike3','nike','hàng đẹp',43,30,550000,'3443435343434')");
//
//        Cursor cursorSP = db.getData("SELECT * FROM SP");
//        while (cursorSP.moveToNext()){
//            int id = cursorSP.getInt(0);
//            String ten = cursorSP.getString(1);
//            String hang = cursorSP.getString(2);
//            String thongtin = cursorSP.getString(3);
//            int size = cursorSP.getInt(4);
//            int soluong = cursorSP.getInt(5);
//            int gia = cursorSP.getInt(6);
//            String img = cursorSP.getString(7);
//            sanpham sp = new sanpham(id, ten, hang, thongtin, size, soluong, gia, img);
//            arrayList.add(sp);
//        }
//        product.notifyDataSetChanged();
//    }
}

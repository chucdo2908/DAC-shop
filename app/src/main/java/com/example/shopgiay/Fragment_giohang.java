package com.example.shopgiay;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Fragment_giohang extends Fragment {
    ListView list ;
    ArrayList<Donhang> arrayList = new ArrayList<>();
    listAdapter_donhang product ;
    int id_sp , id,id_use , soluong , gia ;
    String ten_sp ,  ten_user , diachi , sdt , ngaymua , hinhanh ;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_giohang , container , false);
        connection conn = new connection(getContext(),"DACshop",null,1);
        Trangchu trangchu = (Trangchu) getActivity();
        id_use =  trangchu.id_use;
        list = view.findViewById(R.id.Lhoadon);
        arrayList = new ArrayList<Donhang>();
        product = new listAdapter_donhang(getContext(),R.layout.list_hd , arrayList);
        list.setAdapter(product);
        Cursor cursorHD = conn.GetData("Select * FROM DonHang WHERE ID_TK = "+ id_use +" ");
        while (cursorHD.moveToNext()){
             id = cursorHD.getInt(0);
             id_sp = cursorHD.getInt(1);
             ten_sp = cursorHD.getString(3);
             ten_user = cursorHD.getString(7);
             diachi = cursorHD.getString(8);
             sdt = cursorHD.getString(9);
             ngaymua = cursorHD.getString(10);
             soluong = cursorHD.getInt(4);
             gia = cursorHD.getInt(5);
            Cursor cursorHD1 = conn.GetData("Select * FROM SP WHERE ID = "+ id_sp +" ");
            while (cursorHD1.moveToNext()){
                hinhanh = cursorHD1.getString(7);
            }
            Donhang donhang = new Donhang(id,id_sp,id_use,soluong,gia,ten_sp,ten_user,diachi,sdt,ngaymua,hinhanh);
            arrayList.add(donhang);
        }
        product.notifyDataSetChanged();
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        return view;
    }
    @Override
    public void onResume() {

        super.onResume();
    }
}

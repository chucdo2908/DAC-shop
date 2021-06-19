package com.example.shopgiay;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Objects;

public class Fragment_canhan extends Fragment {
    ListView list ;
    ArrayList<String> array;
    ArrayAdapter<String> adapter;
   private Trangchu trangchu;
    public Fragment_canhan(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_canhan , container , false);
        trangchu = (Trangchu) getActivity();
        String TK = trangchu.TK;
        connection conn = new connection(getContext(),"DACshop",null,1);
        Cursor cursor = conn.GetData("SELECT * FROM TK_User WHERE Taikhoan = '" + TK + "'");
        if(cursor.getCount()==0){
            list = (ListView) view.findViewById(R.id.list_CN);
            array = new ArrayList<String>();
            adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1 , array);
            list.setAdapter(adapter);
            array.add("Đăng nhập/Đăng kí");
            array.add("Cập nhật thông tin cá nhân");
            array.add("Đã xem gần đây");
            array.add("Trung tâm trợ giúp");
            array.add("Đăng Xuất tài khoản");
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String s = array.get(position);
                    if(s.equals("Đăng nhập/Đăng kí")){
                        Intent in = new Intent(view.getContext() , dangnhap_dangky.class);
                        startActivity(in);
                    }else { if(s.equals("Cập nhật thông tin cá nhân")){
                        Toast.makeText(getContext(),"Bạn chưa đăng nhập !!",Toast.LENGTH_SHORT).show();
                    }

                    }
                }
            });
        }else {
            list = (ListView) view.findViewById(R.id.list_CN);
            array = new ArrayList<String>();
            adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1 , array);
            list.setAdapter(adapter);
            array.add(TK);
            array.add("Cập nhật thông tin cá nhân");
            array.add("Đã xem gần đây");
            array.add("Trung tâm trợ giúp");
            array.add("Đăng Xuất tài khoản");
            list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String s = array.get(position);
                    if(s.equals(TK)){
                        Intent in = new Intent(view.getContext() , XemthongtinUsers.class);
                        in.putExtra("tk_use",TK);
                        startActivity(in);
                    }else {
                        if (s.equals("Cập nhật thông tin cá nhân")){
                            Intent in = new Intent(view.getContext() , Thongtin_cn.class);
                            in.putExtra("tk",TK);
                            startActivity(in);
                        }else {
                            if (s.equals("Đăng Xuất tài khoản")){
                                Intent intent = new Intent(view.getContext() , Trangchu.class);
                                startActivity(intent);
                            }
                        }

                    }
                }
            });
        }
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
    }

}

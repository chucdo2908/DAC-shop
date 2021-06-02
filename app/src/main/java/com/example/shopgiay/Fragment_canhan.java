package com.example.shopgiay;

import android.content.Intent;
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

public class Fragment_canhan extends Fragment {
    ListView list ;
    ArrayList<String> array;
    ArrayAdapter<String> adapter;
    public Fragment_canhan(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_canhan , container , false);
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
                if(s == "Đăng nhập/Đăng kí"){
                    Intent in = new Intent(view.getContext() , dangnhap_dangky.class);
                    startActivity(in);
                }else {

                }
            }
        });


        return view;
    }
}

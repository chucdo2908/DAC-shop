package com.example.shopgiay;

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
    public Fragment_canhan(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_canhan , container , false);
        String[] menuitem = {"Đăng ký/Đăng nhập", "Thông tin cá nhân" , "Đã xem gần đây","Đã thích","Trung tâm trợ giúp"};
        ListView listView =(ListView) view.findViewById(R.id.list_CN);
        ArrayAdapter<String> listadap = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1,menuitem
        );
        listView.setAdapter(listadap);
        return view;
    }
}

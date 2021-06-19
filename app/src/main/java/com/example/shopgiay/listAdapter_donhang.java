package com.example.shopgiay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.List;

public class listAdapter_donhang extends BaseAdapter {
    Context con;
    int layout ;
    List<Donhang> arrayHD ;

    public listAdapter_donhang(Context con, int layout, List<Donhang> arrayHD) {
        this.con = con;
        this.layout = layout;
        this.arrayHD = arrayHD;
    }

    @Override
    public int getCount() {
        return  arrayHD.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayHD.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    class  hoadon{
        TextView ten_sp  , soluong , ngaymua , tonggia;
        ImageView hinhanh;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewrow = convertView;
        hoadon HD = new hoadon();
        if(viewrow == null){
            viewrow = inflater.inflate(layout , null);
            HD.ten_sp = (TextView) viewrow.findViewById(R.id.ten_hd);
            HD.soluong = (TextView) viewrow.findViewById(R.id.soluong_hd);
            HD.tonggia = (TextView) viewrow.findViewById(R.id.gia_hd);
            HD.ngaymua = (TextView) viewrow.findViewById(R.id.ngaymua_hd);
            HD.hinhanh = (ImageView) viewrow.findViewById(R.id.anh);
            viewrow.setTag(HD);
        }else {
            HD = (listAdapter_donhang.hoadon) viewrow.getTag();
        }
        String sl = String.valueOf(arrayHD.get(position).soluong);
        String tg = String.valueOf(arrayHD.get(position).gia);
        HD.ten_sp.setText(arrayHD.get(position).ten_sp);
        HD.soluong.setText(sl);
        HD.tonggia.setText(tg);
        HD.ngaymua.setText(arrayHD.get(position).ngaymua);
        Glide.with(con).load(arrayHD.get(position).hinhanh).into(HD.hinhanh);

        return viewrow;
    }
}

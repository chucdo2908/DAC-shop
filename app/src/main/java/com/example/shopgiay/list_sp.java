package com.example.shopgiay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class list_sp extends BaseAdapter {
    Context con;
    int layout ;
    List<sanpham> arraySP ;

    public list_sp(Context con, int layout, List<sanpham> arraySP) {
        this.con = con;
        this.layout = layout;
        this.arraySP = arraySP;
    }

    @Override
    public int getCount() {
        return arraySP.size();
    }

    @Override
    public Object getItem(int position) {
        return arraySP.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    class ViewSP{
        TextView ten , size_sp , giaSP ;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View viewrow = convertView;
        ViewSP SP = new ViewSP();
        if(viewrow == null){
            viewrow = inflater.inflate(layout , null);
            SP.ten = (TextView) viewrow.findViewById(R.id.tensp);
            SP.size_sp = (TextView) viewrow.findViewById(R.id.size);
            SP.giaSP = (TextView) viewrow.findViewById(R.id.gia);
            viewrow.setTag(SP);
        }else {
            SP = (ViewSP) viewrow.getTag();
        }

        DecimalFormat dec = new DecimalFormat("###,###,###");

        SP.ten.setText(arraySP.get(position).Ten_sp);
        SP.size_sp.setText(dec.format(arraySP.get(position).Size));
        SP.giaSP.setText(dec.format(arraySP.get(position).Gia) + "vnđ");


        return viewrow;
    }
}

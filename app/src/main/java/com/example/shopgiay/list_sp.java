package com.example.shopgiay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class list_sp extends BaseAdapter implements Filterable {
    Context con;
    int layout ;
    List<sanpham> arraySP ;
    List<sanpham> arraySPsearch;
    String id ;

    public list_sp(Context con, int layout, List<sanpham> arraySP) {
        this.con = con;
        this.layout = layout;
        this.arraySP = arraySP;
        this.arraySPsearch = arraySP;
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
       ImageView img;

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
            SP.img = (ImageView) viewrow.findViewById(R.id.img);
            viewrow.setTag(SP);
        }else {
            SP = (ViewSP) viewrow.getTag();
        }

        DecimalFormat dec = new DecimalFormat("###,###,###");

        SP.ten.setText(arraySP.get(position).Ten_sp);
        SP.size_sp.setText(dec.format(arraySP.get(position).Size));
        SP.giaSP.setText(dec.format(arraySP.get(position).Gia) + " Đ");
        Glide.with(con).load(arraySP.get(position).img).into(SP.img);
        id = new Integer(arraySP.get(position).ID).toString();
        return viewrow;
    }
    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                String search = constraint.toString();
                if(search.isEmpty()){
                    arraySPsearch = arraySP;
                }else {
                    List<sanpham> list = new ArrayList<>();
                    for (sanpham sp : arraySPsearch){
                        if(sp.getTen_sp().toLowerCase().contains(search.toLowerCase())){
                            list.add(sp);
                        }
                    }
                    arraySPsearch = list;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = arraySPsearch;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                    arraySPsearch =(List<sanpham>) results.values;
                    notifyDataSetChanged();
            }
        };
    }
}

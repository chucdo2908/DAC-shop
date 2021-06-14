package com.example.shopgiay;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class connection extends SQLiteOpenHelper {

    public connection(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    // insert, update ,delete , create ..
    public void QueryData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
    public void QueryUser( String tk, String mk){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO TK_User VALUES(null , ? , ?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.bindString(1 , tk);
        statement.bindString(2 , mk);
        statement.executeInsert();
    }
    public void Querythongtin(int id_tk , String ten , String diachi , String sdt , String ngaysinh){
        SQLiteDatabase db = getWritableDatabase();
        String sql = "INSERT INTO TT_Users VALUES(null , ? , ? , ? , ? , ?)";
        SQLiteStatement statement = db.compileStatement(sql);
        statement.bindDouble(1,id_tk);
        statement.bindString(2,ten);
        statement.bindString(3,diachi);
        statement.bindString(4,sdt);
        statement.bindString(5,ngaysinh);

    }
    //select
    public Cursor GetData(String sql){
        SQLiteDatabase db = getWritableDatabase();
        return  db.rawQuery(sql,null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}

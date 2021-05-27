package com.example.shopgiay;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class connection extends SQLiteOpenHelper {
    public connection(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // truy vấn không trả kết quả
    public void QueryData(String SQL){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(SQL);
    }
    // truy vấn trả về kq
    public Cursor getData(String SQL){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(SQL , null);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

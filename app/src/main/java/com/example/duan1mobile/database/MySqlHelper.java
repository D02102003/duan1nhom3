package com.example.duan1mobile.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySqlHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME_KHACHHANG = "KHACHHANG";
    public static final String KEY_KHACHHANG_MAKH = "MAKHACHHANG";
    public static final String KEY_KHACHHANG_TAIKHOAN = "TAIKHOANKHACHHANG";
    public static final String KEY_KHACHHANG_HOTENKH = "HOTENKHACHHANG";
    public static final String KEY_KHACHHANG_NAM = "NAMSINHKHACHHANG";
    public static final String KEY_KHACHHANG_MATKHAUKH = "MATKHAUKHACHHANG";
    public static final String KEY_KHACHHANG_IMAGEKH = "IMAGEKHACHHANG";

    public static final String TABLE_NAME_SANPHAM = "SANPHAM";
    public static final String KEY_SANPHAM_MASP = "MASANPHAM";
    public static final String KEY_SANPHAM_TENSP = "TENSANPHAM";
    public static final String KEY_SANPHAM_GIASP = "GIASANPHAM";
    public static final String KEY_SANPHAM_PHAMTRAMGIAGIASP = "PHANTRAMMASANPHAM";
    public static final String KEY_SANPHAM_SOLUONGSP = "SOLUONGSP";



    public MySqlHelper(Context context){
        super(context,"quanlicuahanglv.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql1 = "CREATE TABLE " + TABLE_NAME_KHACHHANG
                + "("
                + KEY_KHACHHANG_MAKH + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_KHACHHANG_HOTENKH + " TEXT NOT NULL ,"
                + KEY_KHACHHANG_TAIKHOAN + " TEXT NOT NULL ,"
                + KEY_KHACHHANG_NAM + " TEXT NOT NULL ,"
                + KEY_KHACHHANG_MATKHAUKH + " TEXT NOT NULL,"
                + KEY_KHACHHANG_IMAGEKH + " BLOB "
                + ")";
        sqLiteDatabase.execSQL(sql1);
        sql1  = "INSERT INTO " + TABLE_NAME_KHACHHANG + " VALUES ( null,'Tran Trung Hieu','trantrunghieu','2003' ,'123456' , null)";
        sqLiteDatabase.execSQL(sql1);
        //

//        sql1 = "CREATE TABLE" + TABLE_NAME_SANPHAM
//                + " INTERGER PRIMARY KEY AUTOINCREMENT, "
//                +""

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

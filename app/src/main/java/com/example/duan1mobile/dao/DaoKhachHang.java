package com.example.duan1mobile.dao;

import static com.example.duan1mobile.database.MySqlHelper.KEY_KHACHHANG_HOTENKH;
import static com.example.duan1mobile.database.MySqlHelper.KEY_KHACHHANG_IMAGEKH;
import static com.example.duan1mobile.database.MySqlHelper.KEY_KHACHHANG_MAKH;
import static com.example.duan1mobile.database.MySqlHelper.KEY_KHACHHANG_MATKHAUKH;
import static com.example.duan1mobile.database.MySqlHelper.KEY_KHACHHANG_NAM;
import static com.example.duan1mobile.database.MySqlHelper.KEY_KHACHHANG_TAIKHOAN;
import static com.example.duan1mobile.database.MySqlHelper.TABLE_NAME_KHACHHANG;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.duan1mobile.Model.Khachhang;
import com.example.duan1mobile.database.MySqlHelper;

import java.util.ArrayList;
import java.util.List;

public class DaoKhachHang {
    MySqlHelper mMySqlHeper;
    SQLiteDatabase mSQLiteDatabase;

    public DaoKhachHang(Context context) {
        mMySqlHeper = new MySqlHelper(context);
    }

    public Khachhang getUserLogin(String username, String password) {
        this.mSQLiteDatabase = mMySqlHeper.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME_KHACHHANG
                + " WHERE " + KEY_KHACHHANG_TAIKHOAN + " = '" + username + "' and " + KEY_KHACHHANG_MATKHAUKH + " = '" + password + "'";
        Cursor cursor = this.mSQLiteDatabase.rawQuery(sql, null);
        Khachhang user = new Khachhang();
        if (cursor.moveToFirst()) {
            user.setMaKH(Integer.parseInt(cursor.getString(0)));
            user.setHoTenKH(cursor.getString(1));
            user.setTaiKhoanKH(cursor.getString(2));
            user.setNamSinhKH(cursor.getString(3));
            user.setMaKhauKH(cursor.getString(4));
            user.setKhachHangPhoto(cursor.getBlob(5));
        }
        cursor.close();
        this.mSQLiteDatabase.close();
        return user;
    }

    public Bitmap getPhotoSql(int idKH) {
        this.mSQLiteDatabase = mMySqlHeper.getReadableDatabase();
        String sql = "SELECT " + TABLE_NAME_KHACHHANG + "." + KEY_KHACHHANG_IMAGEKH + " AS IMAGEUSER FROM " + TABLE_NAME_KHACHHANG + " WHERE " + TABLE_NAME_KHACHHANG + "." + KEY_KHACHHANG_MAKH + " = " + idKH;
        Cursor cursor = this.mSQLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            byte[] imgByte = cursor.getBlob(0);
            cursor.close();
            return BitmapFactory.decodeByteArray(imgByte, 0, imgByte.length);
        }
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
        return null;
    }

    @SuppressLint("Range")
    public List<Khachhang> getListKhachHang() {
        List<Khachhang> list = new ArrayList<Khachhang>();
        this.mSQLiteDatabase = mMySqlHeper.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME_KHACHHANG;

        Cursor cursor = this.mSQLiteDatabase.rawQuery(sql, null);
        Khachhang user;
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = Integer.parseInt(cursor.getString(cursor.getColumnIndex(KEY_KHACHHANG_MAKH)));
                String username = cursor.getString(cursor.getColumnIndex(KEY_KHACHHANG_TAIKHOAN));
                String tenKhachHang = cursor.getString(cursor.getColumnIndex(KEY_KHACHHANG_HOTENKH));
                String namSinhKhachHang = cursor.getString(cursor.getColumnIndex(KEY_KHACHHANG_NAM));
                String password = cursor.getString(cursor.getColumnIndex(KEY_KHACHHANG_MATKHAUKH));
                byte[] imgByte = cursor.getBlob(cursor.getColumnIndex(KEY_KHACHHANG_IMAGEKH));
                user = new Khachhang(username ,id , password , tenKhachHang ,namSinhKhachHang ,imgByte);
                list.add(user);
                cursor.moveToNext();
            }
        }
        cursor.close();
        this.mSQLiteDatabase.close();
        return list;
    }

    public boolean deleteTitle(int id) {
        this.mSQLiteDatabase = mMySqlHeper.getWritableDatabase();
        return mSQLiteDatabase.delete(TABLE_NAME_KHACHHANG, KEY_KHACHHANG_MAKH + "=?", new String[]{String.valueOf(id)}) > 0;
    }

    public boolean themKind(Khachhang khachhang) {
        this.mSQLiteDatabase = mMySqlHeper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_KHACHHANG_HOTENKH, khachhang.getHoTenKH());
        values.put(KEY_KHACHHANG_TAIKHOAN, khachhang.getTaiKhoanKH());
        values.put(KEY_KHACHHANG_NAM, khachhang.getNamSinhKH());
        values.put(KEY_KHACHHANG_MATKHAUKH, khachhang.getMaKhauKH());
        values.put(KEY_KHACHHANG_IMAGEKH, khachhang.getKhachHangPhoto());
        long result = this.mSQLiteDatabase.insert(TABLE_NAME_KHACHHANG, null, values);
        if (result <= 0) {
            return false;
        }
        return true;
    }

    public boolean editKind(Khachhang khachhang) {
        this.mSQLiteDatabase = mMySqlHeper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_KHACHHANG_HOTENKH, khachhang.getHoTenKH());
        values.put(KEY_KHACHHANG_TAIKHOAN, khachhang.getTaiKhoanKH());
        values.put(KEY_KHACHHANG_NAM, khachhang.getNamSinhKH());
        values.put(KEY_KHACHHANG_MATKHAUKH, khachhang.getMaKhauKH());
        values.put(KEY_KHACHHANG_IMAGEKH, khachhang.getKhachHangPhoto());
        int r = this.mSQLiteDatabase.update(TABLE_NAME_KHACHHANG, values, KEY_KHACHHANG_MAKH + "=?", new String[]{String.valueOf(khachhang.getMaKH())});
        if (r <= 0) {
            return false;
        }
        return true;
    }

    public boolean changePassword(Khachhang khachhang) {
        this.mSQLiteDatabase = mMySqlHeper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_KHACHHANG_MATKHAUKH, khachhang.getMaKhauKH());
        int r = this.mSQLiteDatabase.update(TABLE_NAME_KHACHHANG, values, KEY_KHACHHANG_MAKH + "=?", new String[]{String.valueOf(khachhang.getMaKH())});
        if (r <= 0) {
            return false;
        }
        return true;
    }


}

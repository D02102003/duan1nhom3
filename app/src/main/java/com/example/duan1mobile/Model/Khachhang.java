package com.example.duan1mobile.Model;

import java.io.Serializable;

public class Khachhang implements Serializable {
    private String taiKhoanKH;
    private int maKH;
    private String maKhauKH;
    private String hoTenKH;
    private String namSinhKH;
    private byte[] khachHangPhoto;

    public Khachhang() {
    }

    public Khachhang(String taiKhoanKH, int maKH, String maKhauKH, String hoTenKH, String namSinhKH, byte[] khachHangPhoto) {
        this.taiKhoanKH = taiKhoanKH;
        this.maKH = maKH;
        this.maKhauKH = maKhauKH;
        this.hoTenKH = hoTenKH;
        this.namSinhKH = namSinhKH;
        this.khachHangPhoto = khachHangPhoto;
    }

    public String getTaiKhoanKH() {
        return taiKhoanKH;
    }

    public void setTaiKhoanKH(String taiKhoanKH) {
        this.taiKhoanKH = taiKhoanKH;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getMaKhauKH() {
        return maKhauKH;
    }

    public void setMaKhauKH(String maKhauKH) {
        this.maKhauKH = maKhauKH;
    }

    public String getHoTenKH() {
        return hoTenKH;
    }

    public void setHoTenKH(String hoTenKH) {
        this.hoTenKH = hoTenKH;
    }

    public String getNamSinhKH() {
        return namSinhKH;
    }

    public void setNamSinhKH(String namSinhKH) {
        this.namSinhKH = namSinhKH;
    }

    public byte[] getKhachHangPhoto() {
        return khachHangPhoto;
    }

    public void setKhachHangPhoto(byte[] khachHangPhoto) {
        this.khachHangPhoto = khachHangPhoto;
    }
}

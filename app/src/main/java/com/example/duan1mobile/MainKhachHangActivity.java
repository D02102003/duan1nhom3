package com.example.duan1mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.duan1mobile.Model.Khachhang;
import com.example.duan1mobile.activity.LoginPeopleActivity;
import com.example.duan1mobile.databinding.ActivityMainBinding;
import com.example.duan1mobile.databinding.ActivityMainKhachHangBinding;
import com.google.android.material.appbar.MaterialToolbar;

import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class MainKhachHangActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityMainKhachHangBinding binding;
    private MaterialToolbar toolbar;
    private LinearLayout idThongTinKH;
    private LinearLayout idSanPhamKH;
    private LinearLayout idDonMua;
    private LinearLayout idThongTinTaiChinh;
    private LinearLayout idDoiMatKhauKH;
    private LinearLayout idLogoutKH;
    private LinearLayout idHome;

    private Khachhang khachhang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainKhachHangBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolbar = (MaterialToolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        DuoDrawerToggle drawerToggle = new DuoDrawerToggle(this, binding.drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        binding.drawer.setDrawerListener(drawerToggle);
        drawerToggle.syncState();

        View contentview = binding.drawer.getContentView();
        View menuView = binding.drawer.getMenuView();

        idHome = (LinearLayout) menuView.findViewById(R.id.idHomeKH);
        idLogoutKH = (LinearLayout) menuView.findViewById(R.id.idLogoutKH);
        idThongTinKH = (LinearLayout) menuView.findViewById(R.id.idThongTinKH);
        idDoiMatKhauKH = (LinearLayout) menuView.findViewById(R.id.idDoiMatKhauKH);
        idDonMua = (LinearLayout) menuView.findViewById(R.id.idDonMua);
        idThongTinTaiChinh = (LinearLayout) menuView.findViewById(R.id.idTaiChinh);
        idSanPhamKH = (LinearLayout) menuView.findViewById(R.id.idSanPhamKH);
        idSanPhamKH.setOnClickListener(this);
        idLogoutKH.setOnClickListener(this);
        idHome.setOnClickListener(this);
        idDonMua.setOnClickListener(this);
        idThongTinTaiChinh.setOnClickListener(this);
        idDoiMatKhauKH.setOnClickListener(this);
        idThongTinKH.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
    }

//    public void showInfo(){
//        int id = LoginPeopleActivity.id;
//        Log.e("Login", String.valueOf(id));
//        if (id != 1) {
//            idThongTinKH.setVisibility(View.GONE);
//        } else {
//            idThongTinKH.setVisibility(View.VISIBLE);
//        }
//        khachhang = (Khachhang) getIntent().getSerializableExtra("khachhang");
//        if (khachhang.getTaiKhoanKH().equals("trantrunghieu")) {
//            binding.idUser.setText(khachhang.getHoTenKH() + " (Chủ Tịch)");
//            byte[] imageuuuu = khachhang.getKhachHangPhoto();
//            if (imageuuuu != null) {
//                Bitmap bitmap = BitmapFactory.decodeByteArray(imageuuuu, 0, imageuuuu.length);
//                binding.idImageUser.setImageBitmap(bitmap);
//            }
//        } else {
//            binding.idUser.setText(khachhang.getHoTenKH());
//            byte[] imageuuuu = khachhang.getKhachHangPhoto();
//            if (imageuuuu != null) {
//                Bitmap bitmap = BitmapFactory.decodeByteArray(imageuuuu, 0, imageuuuu.length);
//                binding.idImageUser.setImageBitmap(bitmap);
//            }
//        }
//    }

    @Override
    protected void onResume() {
        super.onResume();
//        showInfo();
    }
}
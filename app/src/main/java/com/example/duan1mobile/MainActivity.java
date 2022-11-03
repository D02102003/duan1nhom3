package com.example.duan1mobile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.duan1mobile.Model.Khachhang;
import com.example.duan1mobile.activity.LoginPeopleActivity;
import com.example.duan1mobile.databinding.ActivityMainBinding;
import com.example.duan1mobile.fragment.DoanhThuFragment;
import com.example.duan1mobile.fragment.DoiMatKhauAdminFragment;
import com.example.duan1mobile.fragment.HomeFragment;
import com.example.duan1mobile.fragment.SanPhamFragment;
import com.example.duan1mobile.fragment.ThongKeFragment;
import com.google.android.material.appbar.MaterialToolbar;

import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;
    private MaterialToolbar toolBar;
    private LinearLayout idHome;
    private LinearLayout idSanPham;
    private LinearLayout idThongKe;
    private LinearLayout idDoanhThu;
    private LinearLayout idDoiMatKhau;
    private LinearLayout idThoat;

    private Khachhang khachhang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        toolBar = (MaterialToolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolBar);
        getSupportActionBar().setTitle("");
        DuoDrawerToggle drawerToggle = new DuoDrawerToggle(this, binding.drawer, toolBar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        binding.drawer.setDrawerListener(drawerToggle);
        drawerToggle.syncState();
        View contentview = binding.drawer.getContentView();
        View menuView = binding.drawer.getMenuView();
        idHome = (LinearLayout) menuView.findViewById(R.id.idHome);
        idSanPham = (LinearLayout) menuView.findViewById(R.id.idSanPham);
        idThongKe = (LinearLayout) menuView.findViewById(R.id.idThongKe);
        idDoanhThu = (LinearLayout) menuView.findViewById(R.id.idDoanhThu);
        idDoiMatKhau = (LinearLayout) menuView.findViewById(R.id.idDoiMatKhau);
        idThoat = (LinearLayout) menuView.findViewById(R.id.idLogout);

        idHome.setOnClickListener(this);
        idSanPham.setOnClickListener(this);
        idThoat.setOnClickListener(this);
        idDoanhThu.setOnClickListener(this);
        idThongKe.setOnClickListener(this);
        idDoiMatKhau.setOnClickListener(this);
        replaceFragment(new HomeFragment());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.idHome:
                getSupportActionBar().setTitle("");
                HomeFragment homeFragment = new HomeFragment();
                replaceFragment(homeFragment);
                break;
            case R.id.idDoanhThu:
                getSupportActionBar().setTitle("");
                DoanhThuFragment doanhThuFragment = new DoanhThuFragment();
                replaceFragment(doanhThuFragment);
                break;
            case R.id.idDoiMatKhau:
                getSupportActionBar().setTitle("");
                DoiMatKhauAdminFragment doiMatKhauAdminFragment = new DoiMatKhauAdminFragment();
                replaceFragment(doiMatKhauAdminFragment);
                break;
            case R.id.idSanPham:
                getSupportActionBar().setTitle("");
                SanPhamFragment sanPhamFragment = new SanPhamFragment();
                replaceFragment(sanPhamFragment);
                break;
            case R.id.idThongKe:
                getSupportActionBar().setTitle("");
                ThongKeFragment thongKeFragment = new ThongKeFragment();
                replaceFragment(thongKeFragment);
                break;
            case R.id.idLogout:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Thoát");
                builder.setMessage("Bạn có muồn thoát ứng dụng không");
                builder.setCancelable(false);
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
        }
        binding.drawer.closeDrawer();
    }

    //    public void replaceFragment(Fragment fragment){
//        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//        transaction.replace(R.id.frame_layout,fragment);
//        transaction.commit();
//    }
    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);

    }

    public void showInfo() {
        int id = LoginPeopleActivity.id;
        Log.e("Login", String.valueOf(id));
        if (id != 1) {
            idDoanhThu.setVisibility(View.GONE);
            idThongKe.setVisibility(View.GONE);
        } else {
            idDoanhThu.setVisibility(View.VISIBLE);
            idThongKe.setVisibility(View.VISIBLE);
        }
        khachhang = (Khachhang) getIntent().getSerializableExtra("khachhang");
        if (khachhang.getTaiKhoanKH().equals("trantrunghieu")) {
            binding.idUser.setText(khachhang.getHoTenKH() + " (Chủ Tịch)");
            byte[] imageuuuu = khachhang.getKhachHangPhoto();
            if (imageuuuu != null) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(imageuuuu, 0, imageuuuu.length);
                binding.idImageUser.setImageBitmap(bitmap);
            }
        } else {
            binding.idUser.setText(khachhang.getHoTenKH());
            byte[] imageuuuu = khachhang.getKhachHangPhoto();
            if (imageuuuu != null) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(imageuuuu, 0, imageuuuu.length);
                binding.idImageUser.setImageBitmap(bitmap);
            }

        }
    }

        @Override
        protected void onResume () {
            super.onResume();
            showInfo();
        }
    }
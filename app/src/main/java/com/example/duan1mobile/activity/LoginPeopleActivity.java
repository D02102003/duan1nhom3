package com.example.duan1mobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.duan1mobile.MainActivity;
import com.example.duan1mobile.MainKhachHangActivity;
import com.example.duan1mobile.Model.Khachhang;
import com.example.duan1mobile.R;
import com.example.duan1mobile.dao.DaoKhachHang;
import com.example.duan1mobile.databinding.ActivityLoginPeopleBinding;

import java.util.ArrayList;
import java.util.List;

public class LoginPeopleActivity extends AppCompatActivity {
    private ActivityLoginPeopleBinding binding;
    private List<Khachhang> list;
    private DaoKhachHang daoKhachHang;
    public static String KEY_USERNAME = "tennguoidung";
    public static String KEY_PASSWORD = "matkhau";
    public static String KEY_CHECKSTATUS = "checkstatus";
    public static String name = "";
    public static String password = "";
    public static int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginPeopleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        list = new ArrayList<>();
        daoKhachHang = new DaoKhachHang(this);
        binding.btLoginPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        binding.tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(LoginPeopleActivity.this, SignUpActivity.class);
                startActivity(intent1);
            }
        });
    }

    private void login() {
        boolean xetTk = false;
        String tenTaiKhoan = binding.etUsernameKhach.getText().toString();
        String matKhau = binding.etPasswordKhach.getText().toString();

        if (binding.etUsernameKhach.getText().toString().isEmpty() || binding.etUsernameKhach.getText().toString() == null) {

            binding.tvghichu.setText("You Have Not Entered Username");
            binding.tvghichu.setTextColor(Color.RED);
            return;
        } else if (binding.etPasswordKhach.getText().toString().isEmpty() || binding.etPasswordKhach.getText().toString() == null) {

            binding.tvghichu.setText("You Have Not Entered Password");
            binding.tvghichu.setTextColor(Color.RED);
            return;
        } else {
            Khachhang khachhang = daoKhachHang.getUserLogin(tenTaiKhoan, matKhau);
            if (tenTaiKhoan.equals(khachhang.getTaiKhoanKH()) && matKhau.equals(khachhang.getMaKhauKH())) {
                id = khachhang.getMaKH();
                name = khachhang.getHoTenKH();
                password = khachhang.getMaKhauKH();
                Dialog dialog = new Dialog(LoginPeopleActivity.this);
                dialog.setContentView(R.layout.showloading);
                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                timerDelayRemoveDialog(1000, dialog, khachhang);
                dialog.show();
                luuThongTin();

            } else {
                Dialog dialog = new Dialog(LoginPeopleActivity.this);
                dialog.setContentView(R.layout.showloading);
                Window window = dialog.getWindow();
                window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
                timerDelayRemoveDialog2(1000, dialog);
                dialog.show();
                return;
            }
        }
    }

    private void timerDelayRemoveDialog2(int i, Dialog dialog) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                binding.tvghichu.setText("Incorrect Account Or Password");
                binding.tvghichu.setTextColor(Color.RED);
                dialog.dismiss();
            }
        }, i);
    }

    private void timerDelayRemoveDialog(int i, Dialog dialog, Khachhang thu) {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(LoginPeopleActivity.this , MainActivity.class);
                intent.putExtra("khachhang", thu);
                startActivity(intent);
                dialog.dismiss();
            }
        }, i);
    }


    private void luuThongTin() {
        SharedPreferences sharedPreferences = getSharedPreferences("thuVien", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String ten = binding.etUsernameKhach.getText().toString();
        String pass = binding.etPasswordKhach.getText().toString();
        boolean check = binding.cbLuuThongTinKhach.isChecked();
        if (!check) {
            editor.clear();
        } else {
            editor.putString(KEY_USERNAME, ten);
            editor.putString(KEY_PASSWORD, pass);
            editor.putBoolean(KEY_CHECKSTATUS, check);
        }
        editor.commit();
    }

    private void layThongTin() {
        SharedPreferences sharedPreferences = getSharedPreferences("thuVien", MODE_PRIVATE);
        boolean check = sharedPreferences.getBoolean(KEY_CHECKSTATUS, false);
        if (check) {
            String tenNguoiDung = sharedPreferences.getString(KEY_USERNAME, "");
            String matKhau = sharedPreferences.getString(KEY_PASSWORD, "");
            binding.etUsernameKhach.setText(tenNguoiDung);
            binding.etPasswordKhach.setText(matKhau);
        } else {
            binding.etUsernameKhach.setText("");
            binding.etPasswordKhach.setText("");
        }
        binding.cbLuuThongTinKhach.setChecked(check);

    }

    @Override
    protected void onResume() {
        super.onResume();
        layThongTin();
    }
}
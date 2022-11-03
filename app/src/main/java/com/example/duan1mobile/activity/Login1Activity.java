package com.example.duan1mobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.duan1mobile.R;

public class Login1Activity extends AppCompatActivity {
    private LinearLayout admin;
    private LinearLayout people;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login1);
        admin = findViewById(R.id.admin);
        people = findViewById(R.id.people);
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login1Activity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        people.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Login1Activity.this,LoginPeopleActivity.class);
                startActivity(intent1);
            }
        });
    }
}
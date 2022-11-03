package com.example.duan1mobile.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duan1mobile.R;

public class DoiMatKhauAdminFragment extends Fragment {

    public DoiMatKhauAdminFragment() {
        // Required empty public constructor
    }


    public static DoiMatKhauAdminFragment newInstance() {
        DoiMatKhauAdminFragment fragment = new DoiMatKhauAdminFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_doi_mat_khau_admin, container, false);
    }
}
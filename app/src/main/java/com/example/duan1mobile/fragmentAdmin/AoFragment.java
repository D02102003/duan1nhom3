package com.example.duan1mobile.fragmentAdmin;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.duan1mobile.R;


public class AoFragment extends Fragment {


    public AoFragment() {
        // Required empty public constructor
    }


    public static AoFragment newInstance() {
        AoFragment fragment = new AoFragment();

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
        return inflater.inflate(R.layout.fragment_ao, container, false);
    }
}
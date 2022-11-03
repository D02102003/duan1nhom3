package com.example.duan1mobile.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.duan1mobile.fragmentAdmin.AoFragment;
import com.example.duan1mobile.fragmentAdmin.PhuKienFragment;
import com.example.duan1mobile.fragmentAdmin.QuanFragment;

public class ViewPager2Adapter extends FragmentStateAdapter {
    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new AoFragment();
            case 1:
                return new QuanFragment();
            case 2:
                return new PhuKienFragment();
            default:
                return new AoFragment();

        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

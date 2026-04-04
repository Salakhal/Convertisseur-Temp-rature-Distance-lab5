package com.example.convertertabsjava_lab5;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

// Classe dédiée au routage des différents écrans
public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity contexteParent) {
        super(contexteParent);
    }

    @NonNull
    @Override
    public Fragment createFragment(int positionActive) {
        // Logique de distribution des fragments selon l'index
        if (positionActive == 0) {
            return new TempFragment();
        }
        return new DistanceFragment();
    }

    @Override
    public int getItemCount() {
        return 2; // Taille stricte de notre collection de fragments
    }
}
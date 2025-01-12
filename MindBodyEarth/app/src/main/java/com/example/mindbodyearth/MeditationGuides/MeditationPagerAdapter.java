package com.example.mindbodyearth.MeditationGuides;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MeditationPagerAdapter extends FragmentStateAdapter {

    public MeditationPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new VideosFragment();
        } else {
            return new ArticlesFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

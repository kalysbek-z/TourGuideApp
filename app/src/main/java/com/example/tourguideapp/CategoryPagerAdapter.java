package com.example.tourguideapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class CategoryPagerAdapter extends FragmentPagerAdapter {

    public CategoryPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Places";
            case 1:
                return "Parks";
            default:
                return "Food";
        }
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PlacesFragment();
            case 1:
                return new ParksFragment();
            default:
                return new FoodFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}

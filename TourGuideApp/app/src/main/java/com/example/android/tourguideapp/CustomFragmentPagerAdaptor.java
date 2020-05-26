package com.example.android.tourguideapp;

import android.content.Context;
import android.util.Log;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.Fragment;

public class CustomFragmentPagerAdaptor extends FragmentPagerAdapter {

    private Context context;
    public CustomFragmentPagerAdaptor(FragmentManager fm, Context context){
        super(fm);
        this.context = context;
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new com.example.android.tourguideapp.FoodFragment();
        } else if (position == 1){
            return new SiteFragment();
        } else if (position == 2) {
            return new EventsFragment();
        }else {
            return new com.example.android.tourguideapp.StartupFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0: title = context.getResources().getString(R.string.category_food);
                    break;
            case 1: title = context.getResources().getString(R.string.category_site);
                    break;
            case 2: title = context.getResources().getString(R.string.category_events);
                    break;
            case 3: title = context.getResources().getString(R.string.category_industry);
                    break;
        }
        return title;
    }
}

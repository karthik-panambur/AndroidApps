package com.example.android.tourguideapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class CustomFragmentPagerAdaptor extends FragmentPagerAdapter {

    private Context context;
    public CustomFragmentPagerAdaptor(FragmentManager fm, Context context){
        super(fm);
        this.context = context;
    }


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new com.example.android.miwok.NumbersFragment();
        } else if (position == 1){
            return new ColorsFragment();
        } else if (position == 2) {
            return new com.example.android.miwok.FamilyFragments();
        }else {
            return new com.example.android.miwok.PhrasesFragments();
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
            case 0: title = context.getResources().getString(R.string.category_numbers);
                    break;
            case 1: title = context.getResources().getString(R.string.category_colors);
                    break;
            case 2: title = context.getResources().getString(R.string.category_family);
                    break;
            case 3: title = context.getResources().getString(R.string.category_phrases);
                    break;
            default : ;
        }
        Log.e("title", title);
        return title;
    }
}

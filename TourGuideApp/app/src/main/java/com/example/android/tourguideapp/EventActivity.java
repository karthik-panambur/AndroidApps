package com.example.android.tourguideapp;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new EventsFragment())
                .commit();
    }

    public static class EventsFragment extends Fragment {

        public EventsFragment(){}
        @Override
        public void onStop() {
            super.onStop();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.city_list, container, false);
            // Inflate the layout for this fragment
            ArrayList<City> Citys = new ArrayList<>();
            Citys.add(new City("red","weṭeṭṭi",R.drawable.r0,"a"));
            Citys.add(new City("green","chokokki",R.drawable.r1,"a"));
            Citys.add(new City("brown","takaakki",R.drawable.r2,""));
            Citys.add(new City("gray","topoppi",R.drawable.r3,"a"));
            Citys.add(new City("black","kululli",R.drawable.r4,"a"));
            Citys.add(new City("white","kelelli",R.drawable.r5,"a"));
            Citys.add(new City("dusty yellow","ṭopiisә",R.drawable.r6,"a"));
            Citys.add(new City("mustard yellow","chiwiiṭә",R.drawable.r7,"a"));


            CityAdapter itemsAdapter = new CityAdapter(getActivity(), Citys, R.color.category_event);
            ListView listView = (ListView) rootView.findViewById(R.id.list);
            listView.setAdapter(itemsAdapter);


            return rootView;
        }
    }
}
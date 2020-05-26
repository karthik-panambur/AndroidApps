package com.example.android.tourguideapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FoodFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    public FoodFragment(){}
    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.city_list, container, false);
        ArrayList<com.example.android.tourguideapp.City> places = new ArrayList<>();
        places.add(new com.example.android.tourguideapp.City("Le Cinq","French",R.drawable.r0,"12 PM - 3 PM"));
        places.add(new com.example.android.tourguideapp.City("Patchanka","Middle Eastern",R.drawable.r1,"12 PM - 8 PM"));
        places.add(new com.example.android.tourguideapp.City("Epicure","Continental",R.drawable.r2,"Open 24 hr"));
        places.add(new com.example.android.tourguideapp.City("Madito","Italian",R.drawable.r3,"Open 24 hr"));
        places.add(new com.example.android.tourguideapp.City("Mokonuts","Thai",R.drawable.r4,"6PM - 8pm"));
        places.add(new com.example.android.tourguideapp.City("L'Orangerie","French",R.drawable.r5,"7 AM - 10 PM"));
        places.add(new com.example.android.tourguideapp.City("Midi 12","Italian",R.drawable.r6,"Open 24 hr"));
        places.add(new com.example.android.tourguideapp.City("Le Gabriel","French",R.drawable.r7,"7 AM - 10 PM"));
        places.add(new com.example.android.tourguideapp.City("Restaurant Kei","Chinese",R.drawable.r8,"Open 24 hr"));
        places.add(new com.example.android.tourguideapp.City("Signature","English",R.drawable.r9,"Open 24 hr"));


        com.example.android.tourguideapp.CityAdapter itemsAdapter = new com.example.android.tourguideapp.CityAdapter(getActivity(), places,R.color.category_food);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        return rootView;
    }
}

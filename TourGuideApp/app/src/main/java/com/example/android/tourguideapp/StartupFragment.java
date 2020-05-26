package com.example.android.tourguideapp;

import android.app.SearchManager;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class StartupFragment extends Fragment {


    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.city_list, container, false);
        ArrayList<com.example.android.tourguideapp.City> Citys = new ArrayList<>();
        Citys.add(new com.example.android.tourguideapp.City("Meero","Photography","Matches Professional Photographers with clients"));
        Citys.add(new com.example.android.tourguideapp.City("Alan","Health Fintech","Reshaping Health Insurance"));
        Citys.add(new com.example.android.tourguideapp.City("Doctolib","MEdical Healthcare","Medical Booking platform"));
        Citys.add(new com.example.android.tourguideapp.City("Alsid","Cybersecurity","Protecting client company from cyber threats"));
        Citys.add(new com.example.android.tourguideapp.City("Georges","Accounting Finance","AN Accounting robot"));
        Citys.add(new com.example.android.tourguideapp.City("Ynsect","Agriculture","Transforming insects into nutrients for Agriculture"));
        Citys.add(new com.example.android.tourguideapp.City("BlaBlaCar","Transportation","Connecting drivers with passengers"));
        Citys.add(new com.example.android.tourguideapp.City("Leavy","Rental Travel","Rental platfrorm for short term rentals"));

        com.example.android.tourguideapp.CityAdapter itemsAdapter = new com.example.android.tourguideapp.CityAdapter(getActivity(), Citys, R.color.category_industry);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                City currentItem = (City)adapterView.getItemAtPosition(i);
                String name = currentItem.getName();
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, name);
                startActivity(intent);

            }
        });

        return rootView;
    }
}

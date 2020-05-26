package com.example.android.tourguideapp;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EventsFragment extends Fragment {

    public EventsFragment(){}
    @Override
    public void onStop() {
        super.onStop();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.city_list, container, false);
        ArrayList<com.example.android.tourguideapp.City> places = new ArrayList<>();
        places.add(new com.example.android.tourguideapp.City("UEFA Champions League Final","Parc de Paris","7PM"));
        places.add(new com.example.android.tourguideapp.City("French Open Grand Slam","Phillipe Chartrier, Roland Garos","4PM"));
        places.add(new com.example.android.tourguideapp.City("French Grand prix","Reb Bull ring","2PM"));
        places.add(new com.example.android.tourguideapp.City("G20 Summit","Palace of Versailles","10AM"));
        places.add(new com.example.android.tourguideapp.City("Festival D Avignon","Avignon","All day"));
        places.add(new com.example.android.tourguideapp.City("FIDE  Chess Championship","Aronion Indoor Stadium, Paris","10AM"));
        places.add(new com.example.android.tourguideapp.City("Bastille Day","PAris","7 AM - 11 AM"));


        com.example.android.tourguideapp.CityAdapter itemsAdapter = new com.example.android.tourguideapp.CityAdapter(getActivity(), places,R.color.category_event);

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

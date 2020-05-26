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



public class SiteFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    public SiteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onStop() {
        super.onStop();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.city_list, container, false);

        ArrayList<com.example.android.tourguideapp.City> Citys = new ArrayList<>();
        Citys.add(new com.example.android.tourguideapp.City("Eiffel Tower","324m high 19th century tower","6AM - 10PM"));
        Citys.add(new com.example.android.tourguideapp.City("Louvre Museum","Art Museum with vast collection","10AM - 10PM"));
        Citys.add(new com.example.android.tourguideapp.City("Notre Dame","Gothic Church With Literary Link","6AM - 6PM"));
        Citys.add(new com.example.android.tourguideapp.City("Arc de Teiomphe","Triumphal Arch and National Monument","Open 24 hr"));
        Citys.add(new com.example.android.tourguideapp.City("Champs Elysees","Iconic Site of dining and shops","Open 24 hr"));
        Citys.add(new com.example.android.tourguideapp.City("Sacre Coer","Hiltop Basilica","6AM - 6PM"));
        Citys.add(new com.example.android.tourguideapp.City("Palace of Versailles","Palace of Louis XIV","8AM - 10PM"));
        Citys.add(new com.example.android.tourguideapp.City("Montmarte","Charming hill with a landmark basilica","6AM - 6PM"));



        com.example.android.tourguideapp.CityAdapter itemsAdapter = new com.example.android.tourguideapp.CityAdapter(getActivity(), Citys,R.color.category_site);

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

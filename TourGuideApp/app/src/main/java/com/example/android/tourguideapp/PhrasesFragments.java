package com.example.android.tourguideapp;

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
        Citys.add(new com.example.android.tourguideapp.City("red","weṭeṭṭi",R.drawable.r0,"a"));
        Citys.add(new com.example.android.tourguideapp.City("green","chokokki",R.drawable.r1,"a"));
        Citys.add(new com.example.android.tourguideapp.City("brown","takaakki",R.drawable.r2,""));
        Citys.add(new com.example.android.tourguideapp.City("gray","topoppi",R.drawable.r3,"a"));
        Citys.add(new com.example.android.tourguideapp.City("black","kululli",R.drawable.r4,"a"));
        Citys.add(new com.example.android.tourguideapp.City("white","kelelli",R.drawable.r5,"a"));
        Citys.add(new com.example.android.tourguideapp.City("dusty yellow","ṭopiisә",R.drawable.r6,"a"));
        Citys.add(new com.example.android.tourguideapp.City("mustard yellow","chiwiiṭә",R.drawable.r7,"a"));

        com.example.android.tourguideapp.CityAdapter itemsAdapter = new com.example.android.tourguideapp.CityAdapter(getActivity(), Citys, R.color.category_industry);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int res = words.get(i).getAudio();
                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(getActivity(),res);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                    }
                });
            }
        });
*/
        return rootView;
    }
}

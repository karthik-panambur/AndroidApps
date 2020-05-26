package com.example.android.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.musicapp.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LastPlayedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last_played);
        ArrayList<Songs> songs = new ArrayList<>();
        songs.add(new Songs("The Way You Look Tonight","Fed Astaire", "1920"));
        songs.add(new Songs("Old Hollywood","Julian Casablancas","Pecado"));
        songs.add(new Songs("Diamonds Ares a Girls's Best Friend","Marilyn Monroe","Villa"));
        songs.add(new Songs("The Trolley Song","Judy Garland","Los Leones"));
        songs.add(new Songs("Put the Blame on Mame","Rita Hayworth","Boot Camp"));
        songs.add(new Songs("Amado Mio","Rita Hayworth","Rozok"));
        songs.add(new Songs("Stay With Me","Postmodern Jukebox","Gatka"));


        SongAdaptor itemsAdapter = new SongAdaptor(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}

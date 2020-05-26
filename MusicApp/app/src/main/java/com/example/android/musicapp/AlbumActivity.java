package com.example.android.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.musicapp.R;

import java.util.ArrayList;

public class BuySongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_songs);
        ArrayList<com.example.android.musicapp.Songs> songs = new ArrayList<>();
        songs.add(new com.example.android.musicapp.Songs("Broken Wings","Alter Bridge","Pai Nan"));
        songs.add(new com.example.android.musicapp.Songs("Carnival of Rust","POTF","Camp Charlie"));
        songs.add(new com.example.android.musicapp.Songs("One Last Goodbye","Anathema","Ruins"));
        songs.add(new com.example.android.musicapp.Songs("Winf Of Change","Scorpion","Docks"));
        songs.add(new com.example.android.musicapp.Songs("The MAn Who Sold The World","Nirvana","Podovosto"));
        songs.add(new com.example.android.musicapp.Songs("Nothing Else MAtters","Metallica","Trinity"));
        songs.add(new com.example.android.musicapp.Songs("I don't want to miss a thing","Aerosmith","Dyno City"));
        songs.add(new com.example.android.musicapp.Songs("Black","Pearl Jam","Black and White"));
        songs.add(new com.example.android.musicapp.Songs("Things Change","No Man","Friends"));
        songs.add(new com.example.android.musicapp.Songs("Two and a Hald Men","Charlie Harper","Chuck Lorre"));


        com.example.android.musicapp.SongAdaptor itemsAdapter = new com.example.android.musicapp.SongAdaptor(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}

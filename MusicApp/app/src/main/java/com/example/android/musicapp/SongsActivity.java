package com.example.android.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.musicapp.R;

import java.util.ArrayList;

public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songs);
        ArrayList<Songs> songs = new ArrayList<>();
        songs.add(new Songs("Stuck With you","Ariana Grande & Justin Beiber","Purpose"));
        songs.add(new Songs("Say so","Doja Cat","Alive"));
        songs.add(new Songs("Gooba","6ix9ine","God Save The Queen"));
        songs.add(new Songs("Blinding Lights","The Weekend","Stoned"));
        songs.add(new Songs("Savage","Megan Thee Stallion","Chartered"));
        songs.add(new Songs("Toosie Slide","Drake","Fearless"));
        songs.add(new Songs("The Box","Roddy Ricch","One"));
        songs.add(new Songs("Rockstar","DaBaby","Three Lions"));
        songs.add(new Songs("Don't Start Now","Dua Lipa","Daredevils"));
        songs.add(new Songs("Circles","Post Malone","Masterpiece"));

        com.example.android.musicapp.SongAdaptor itemsAdapter = new com.example.android.musicapp.SongAdaptor(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}

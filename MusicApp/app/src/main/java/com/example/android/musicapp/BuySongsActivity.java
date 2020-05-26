package com.example.android.musicapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.musicapp.R;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        ArrayList<com.example.android.musicapp.Songs> songs = new ArrayList<>();
        songs.add(new com.example.android.musicapp.Songs("father","әpә"));
        songs.add(new com.example.android.musicapp.Songs("mother","ata"));
        songs.add(new com.example.android.musicapp.Songs("son","aangsi"));
        songs.add(new com.example.android.musicapp.Songs("daughter","tune"));
        songs.add(new com.example.android.musicapp.Songs("older brother","taachi"));
        songs.add(new com.example.android.musicapp.Songs("younger brother","chalitti"));
        songs.add(new com.example.android.musicapp.Songs("older sister","teṭe"));
        songs.add(new com.example.android.musicapp.Songs("younger sister","kolliti"));
        songs.add(new com.example.android.musicapp.Songs("grandmother","ama"));
        songs.add(new com.example.android.musicapp.Songs("gramdfather","paapa"));


        com.example.android.musicapp.SongAdaptor itemsAdapter = new com.example.android.musicapp.SongAdaptor(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}

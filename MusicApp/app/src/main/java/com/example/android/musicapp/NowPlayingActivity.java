package com.example.android.musicapp;

import  androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.musicapp.R;

import java.util.ArrayList;

public class ArtistActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artist);
        ArrayList<Songs> Songss = new ArrayList<>();
        Songss.add(new Songs("red","weṭeṭṭi"));
        Songss.add(new Songs("green","chokokki"));
        Songss.add(new Songs("brown","takaakki"));
        Songss.add(new Songs("gray","topoppi"));
        Songss.add(new Songs("black","kululli"));
        Songss.add(new Songs("white","kelelli"));
        Songss.add(new Songs("dusty yellow","ṭopiisә"));
        Songss.add(new Songs("mustard yellow","chiwiiṭә"));


        SongAdaptor itemsAdapter = new SongAdaptor(this, Songss);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}

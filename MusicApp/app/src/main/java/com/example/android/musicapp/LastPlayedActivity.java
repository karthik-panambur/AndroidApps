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

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        ArrayList<Songs> songs = new ArrayList<>();
        songs.add(new Songs("one","lutti"));
        songs.add(new Songs("two","otiiko"));
        songs.add(new Songs("three","tolookosu"));
        songs.add(new Songs("four","oyyisa"));
        songs.add(new Songs("five","massokka"));
        songs.add(new Songs("six","temmokka"));
        songs.add(new Songs("seven","kenekaku"));
        songs.add(new Songs("eight","kawinta"));
        songs.add(new Songs("nine","wo'e"));
        songs.add(new Songs("ten","na'aacha"));



        SongAdaptor itemsAdapter = new SongAdaptor(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}

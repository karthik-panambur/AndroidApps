package com.example.android.musicapp;

import  androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.android.musicapp.R;

import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        ArrayList<Songs> songs = new ArrayList<>();
        songs.add(new Songs("Lost Stars","Kiera Knightley","Water City"));
        songs.add(new Songs("Beneath The Surface","Dream heater","Primorsk"));
        songs.add(new Songs("Never Gonna Say I'm Sorry","Ace of Base","Georgopool"));
        songs.add(new Songs("Johny B Goode","Chuck Berry","Mylta"));
        songs.add(new Songs("Evergreen","Barbra Streisand","Tovar"));
        songs.add(new Songs("Mera Dil Bhi Kitna Pagal Hai","Kumar Sanu","School"));
        songs.add(new Songs("Wonderwall","Oasis","Hospital"));
        songs.add(new Songs("Fix You","Coldplay","Palace"));


        SongAdaptor itemsAdapter = new SongAdaptor(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);
    }
}

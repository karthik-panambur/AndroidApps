package com.example.android.musicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the content of the activity to use the activity_main.xml layout file
        setContentView(R.layout.activity_main);

        TextView songsTextView = (TextView)findViewById(R.id.songs);
        songsTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,SongsActivity.class);
                startActivity(intent);
            }
        });

        TextView lastPlayedTextView = (TextView)findViewById(R.id.last_played_songs);
        lastPlayedTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,LastPlayedActivity.class);
                startActivity(intent);
            }
        });

        TextView nowPlayingTextView = (TextView)findViewById(R.id.now_playing);
        nowPlayingTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,NowPlayingActivity.class);
                startActivity(intent);
            }
        });

        TextView buySongsTextView = (TextView)findViewById(R.id.buy_songs);
        buySongsTextView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this,BuySongsActivity.class);
                startActivity(intent);
            }
        });
    }
}

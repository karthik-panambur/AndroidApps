package com.example.android.tourguideapp;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class EventsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new com.example.android.tourguideapp.EventsFragment())
                .commit();
    }
}
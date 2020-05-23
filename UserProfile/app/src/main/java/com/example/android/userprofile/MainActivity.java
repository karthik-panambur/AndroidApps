package com.example.android.userprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView nameTV = (TextView)findViewById(R.id.name);
        TextView birthdayTV = (TextView)findViewById(R.id.birthday);
        TextView countryTV = (TextView)findViewById(R.id.country);
        ImageView img = (ImageView)findViewById(R.id.profile_picture);
        nameTV.setText("Karthik P");
        nameTV.setTextSize(40);
        nameTV.setTextColor(Color.RED);
        birthdayTV.setText("July 13 1994");
        birthdayTV.setTextSize(24);
        birthdayTV.setTextColor(Color.RED);
        countryTV.setText("India");
        countryTV.setTextSize(24);
        countryTV.setTextColor(Color.parseColor("Teal"));
        img.setImageResource(R.drawable.karthik);
    }
}

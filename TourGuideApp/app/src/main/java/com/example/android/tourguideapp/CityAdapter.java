package com.example.android.tourguideapp;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CityAdapter extends ArrayAdapter<City> {

    private int background;

    public CityAdapter(Context context, ArrayList<City> City, int color)
    {
        super(context,0,City);
        this.background = color;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        City City = getItem(position);
        LinearLayout linearLayout = (LinearLayout)listItemView.findViewById(R.id.text_layout);
        int color = ContextCompat.getColor(getContext(),this.background);
        linearLayout.setBackgroundColor(color);

        TextView nameText = (TextView) listItemView.findViewById(R.id.name);
        nameText.setText(City.getName());

        TextView locationText = (TextView) listItemView.findViewById(R.id.location);
        locationText.setText(City.getLocation());

        TextView contactText = (TextView) listItemView.findViewById(R.id.contact);
        contactText.setText(City.getcontact());


        ImageView image = (ImageView)listItemView.findViewById(R.id.image);
        if(City.hasImage()){
            image.setImageResource(City.getImage());
            image.setVisibility(View.VISIBLE);
        }
        else{
            image.setVisibility(View.GONE);
        }
        return listItemView;
    }
}

package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.ArrayList;
import java.util.List;

public class EarthQuakeAdaptor extends ArrayAdapter<EarthQuake> {

    EarthQuakeAdaptor(Context context, List<EarthQuake> earthQuakes){
      super(context,0,earthQuakes);
    }

    private int getMagnitudeColor(double mag){
        int magnitude = (int)mag;
        int ret = 0;
        switch (magnitude){
            case 10: ret = R.color.magnitude10plus;
            break;
            case 9: ret = R.color.magnitude9;
                break;
            case 8: ret = R.color.magnitude8;
                break;
            case 7: ret = R.color.magnitude7;
                break;
            case 6: ret = R.color.magnitude6;
                break;
            case 5: ret = R.color.magnitude5;
                break;
            case 4: ret = R.color.magnitude4;
                break;
            case 3: ret = R.color.magnitude3;
                break;
            default:ret = R.color.magnitude2;
        }
        return ret;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }


        EarthQuake quake = getItem(position);
        TextView magTextView = (TextView)listItemView.findViewById(R.id.magnitude);
        DecimalFormat formatter = new DecimalFormat("0.0");

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = ContextCompat.getColor(getContext(),getMagnitudeColor(quake.getMagnitude()));

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        magTextView.setText(formatter.format(quake.getMagnitude()));

        String primaryLoc = quake.getLocation();;
        String secondoryLoc = "near the";
        if(primaryLoc.contains("of")){
            String arr[] =  primaryLoc.split("of");
            secondoryLoc = arr[0] + "of";
            primaryLoc = arr[1];
        }
        TextView primaryLocationTextView = (TextView)listItemView.findViewById(R.id.primary_location);
        primaryLocationTextView.setText(primaryLoc);

        TextView secondaryLocationTextView = (TextView)listItemView.findViewById(R.id.secondary_location);
        secondaryLocationTextView.setText(secondoryLoc);

        TextView dateTextView = (TextView)listItemView.findViewById(R.id.date);
        Date date = new Date(quake.getDate());
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
        String sDate = sdf.format(date);
        dateTextView.setText(sDate);

        TextView timeTextView = (TextView)listItemView.findViewById(R.id.time);
        sdf = new SimpleDateFormat("HH:MM");
        String tDate = sdf.format(date);
        timeTextView.setText(tDate);
        return listItemView;
    }
}

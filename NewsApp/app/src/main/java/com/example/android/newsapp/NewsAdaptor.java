package com.example.android.newsapp;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdaptor extends ArrayAdapter<News> {

    NewsAdaptor(Context context, List<News> news){
      super(context,0,news);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        News news = getItem(position);
        String sectionName = news.getSectionName();;
        TextView SectionNameTextView = (TextView)listItemView.findViewById(R.id.section_name);
        SectionNameTextView.setText(sectionName);
        TextView webTitleTextView = (TextView)listItemView.findViewById(R.id.web_title);
        webTitleTextView.setText(news.getWebTitle());
        String sDate = "", sTime = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:SS'Z'");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MMM dd, yyyy");
        try{
            Date date = sdf.parse(news.getDateTime());
            sDate = sdf1.format(date);
            sdf1 = new SimpleDateFormat("HH:MM");
            sTime = sdf1.format(date);
        }catch(ParseException pe){
            Log.e(this.getClass().getSimpleName().toString(),pe.getMessage());
        }
        TextView dateTextView = (TextView)listItemView.findViewById(R.id.date);
        dateTextView.setText(sDate + " " +sTime);

        TextView timeTextView = (TextView)listItemView.findViewById(R.id.author);
        timeTextView.setText(news.getAuthor());
        return listItemView;
    }
}

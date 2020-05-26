package com.example.android.newsapp;

import android.content.Context;
import android.util.Log;
import android.content.AsyncTaskLoader;
import androidx.annotation.Nullable;


import java.util.ArrayList;
import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    private String url;

    NewsLoader(Context context, String url){
        super(context);
        this.url = url;
    }
    @Nullable
    @Override
    public List<News> loadInBackground() {
        List<News> news = new ArrayList<>();
        if(url.isEmpty())
            return null;
        try {
            news = QueryUtils.fetchNewsData(url);
        }catch(Exception io){
            Log.e("Error",io.getMessage());
        }

        return news;

    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }
}

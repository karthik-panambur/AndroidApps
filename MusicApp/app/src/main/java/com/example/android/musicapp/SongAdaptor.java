package com.example.android.musicapp;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.android.musicapp.R;
import com.example.android.musicapp.Songs;

import java.util.ArrayList;

public class SongAdaptor extends ArrayAdapter<Songs> {

    public SongAdaptor(Context context, ArrayList<Songs> songs){
        super(context,0,songs);
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Songs songs = getItem(position);

        TextView songText = (TextView) listItemView.findViewById(R.id.song);
        songText.setText("Name: " + songs.getSong());

        TextView artistText = (TextView) listItemView.findViewById(R.id.artist);
        artistText.setText("Artist: " + songs.getArtist());

        TextView albumText = (TextView) listItemView.findViewById(R.id.album);
        albumText.setText("Album: " + songs.getAlbum());
        return listItemView;
    }
}

package com.example.android.tourguideapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ColorsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private MediaPlayer mediaPlayer;
    /**
     * Clean up the media player by releasing its resources.
     */

    public ColorsFragment(){}
    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.word_list, container, false);
        // Inflate the layout for this fragment
        ArrayList<com.example.android.miwok.Word> words = new ArrayList<>();
        words.add(new com.example.android.miwok.Word("red","weṭeṭṭi",R.drawable.color_red,R.raw.color_red));
        words.add(new com.example.android.miwok.Word("green","chokokki",R.drawable.color_green,R.raw.color_green));
        words.add(new com.example.android.miwok.Word("brown","takaakki",R.drawable.color_brown,R.raw.color_brown));
        words.add(new com.example.android.miwok.Word("gray","topoppi",R.drawable.color_gray,R.raw.color_gray));
        words.add(new com.example.android.miwok.Word("black","kululli",R.drawable.color_black,R.raw.color_black));
        words.add(new com.example.android.miwok.Word("white","kelelli",R.drawable.color_white,R.raw.color_white));
        words.add(new com.example.android.miwok.Word("dusty yellow","ṭopiisә",R.drawable.color_dusty_yellow,R.raw.color_dusty_yellow));
        words.add(new com.example.android.miwok.Word("mustard yellow","chiwiiṭә",R.drawable.color_mustard_yellow,R.raw.color_mustard_yellow));


        com.example.android.miwok.WordAdaptor itemsAdapter = new com.example.android.miwok.WordAdaptor(getActivity(), words, R.color.category_colors);
        ListView listView = (ListView) rootView.findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                com.example.android.miwok.Word currentWord = (com.example.android.miwok.Word)adapterView.getItemAtPosition(i);
                int res = currentWord.getAudio();
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(getActivity(),res);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                    }
                });
            }
        });
    return rootView;
    }
}

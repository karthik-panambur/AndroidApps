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



public class SiteFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    private MediaPlayer mediaPlayer;

    public NumbersFragment() {
        // Required empty public constructor
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
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        ArrayList<com.example.android.miwok.Word> words = new ArrayList<>();
        words.add(new com.example.android.miwok.Word("one","lutti",R.drawable.number_one,R.raw.number_one));
        words.add(new com.example.android.miwok.Word("two","otiiko",R.drawable.number_two,R.raw.number_two));
        words.add(new com.example.android.miwok.Word("three","tolookosu",R.drawable.number_three,R.raw.number_three));
        words.add(new com.example.android.miwok.Word("four","oyyisa",R.drawable.number_four,R.raw.number_four));
        words.add(new com.example.android.miwok.Word("five","massokka",R.drawable.number_five,R.raw.number_five));
        words.add(new com.example.android.miwok.Word("six","temmokka",R.drawable.number_six,R.raw.number_six));
        words.add(new com.example.android.miwok.Word("seven","kenekaku",R.drawable.number_seven,R.raw.number_seven));
        words.add(new com.example.android.miwok.Word("eight","kawinta",R.drawable.number_eight,R.raw.number_eight));
        words.add(new com.example.android.miwok.Word("nine","wo'e",R.drawable.number_nine,R.raw.number_nine));
        words.add(new com.example.android.miwok.Word("ten","na'aacha",R.drawable.number_ten,R.raw.number_ten));



        com.example.android.miwok.WordAdaptor itemsAdapter = new com.example.android.miwok.WordAdaptor(getActivity(), words,R.color.category_numbers);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                com.example.android.miwok.Word currentWord = (com.example.android.miwok.Word) adapterView.getItemAtPosition(i);
                int res = currentWord.getAudio();
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(getActivity(), res);
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

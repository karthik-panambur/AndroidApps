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

public class StartupFragment extends Fragment {

    private MediaPlayer mediaPlayer;


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
    } @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        final ArrayList<com.example.android.miwok.Word> words = new ArrayList<>();
        words.add(new com.example.android.miwok.Word("Where are you going?","minto wuksus",-1,R.raw.phrase_where_are_you_going));
        words.add(new com.example.android.miwok.Word("What is your name?","tinnә oyaase'nә",-1,R.raw.phrase_what_is_your_name));
        words.add(new com.example.android.miwok.Word("My name is...","oyaaset...",-1,R.raw.phrase_my_name_is));
        words.add(new com.example.android.miwok.Word("How are you feeling?","michәksәs?",-1,R.raw.phrase_how_are_you_feeling));
        words.add(new com.example.android.miwok.Word("I’m feeling good.","kuchi achit",-1,R.raw.phrase_im_feeling_good));
        words.add(new com.example.android.miwok.Word("Are you coming?","әәnәs'aa?",-1,R.raw.phrase_are_you_coming));
        words.add(new com.example.android.miwok.Word("Yes, I’m coming.","hәә’ әәnәm",-1,R.raw.phrase_yes_im_coming));
        words.add(new com.example.android.miwok.Word("I’m coming.","әәnәm",-1,R.raw.phrase_im_coming));
        words.add(new com.example.android.miwok.Word("Let’s go.","yoowutis",-1,R.raw.phrase_lets_go));
        words.add(new com.example.android.miwok.Word("Come here.","әnni'nem",-1,R.raw.phrase_come_here));

        com.example.android.miwok.WordAdaptor itemsAdapter = new com.example.android.miwok.WordAdaptor(getActivity(), words, R.color.category_phrases);

        ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int res = words.get(i).getAudio();
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

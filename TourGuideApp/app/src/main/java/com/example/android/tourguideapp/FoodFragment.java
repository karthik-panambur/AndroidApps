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

public class FoodFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    private MediaPlayer mediaPlayer;
    /**
     * Clean up the media player by releasing its resources.
     */

    public FamilyFragments(){}
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
        ArrayList<com.example.android.miwok.Word> words = new ArrayList<>();
        words.add(new com.example.android.miwok.Word("father","әpә",R.drawable.family_father,R.raw.family_father));
        words.add(new com.example.android.miwok.Word("mother","ata",R.drawable.family_mother,R.raw.family_mother));
        words.add(new com.example.android.miwok.Word("son","aangsi",R.drawable.family_son,R.raw.family_son));
        words.add(new com.example.android.miwok.Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new com.example.android.miwok.Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new com.example.android.miwok.Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new com.example.android.miwok.Word("older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new com.example.android.miwok.Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new com.example.android.miwok.Word("grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new com.example.android.miwok.Word("grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));


        com.example.android.miwok.WordAdaptor itemsAdapter = new com.example.android.miwok.WordAdaptor(getActivity(), words,R.color.category_family);

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

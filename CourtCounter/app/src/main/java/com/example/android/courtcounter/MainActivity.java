package com.example.android.courtcounter;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.android.courtcounter.R;

public class MainActivity extends AppCompatActivity {
    private int scoreForTeamA;
    private int scoreForTeamB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreForTeamA = 0;
        scoreForTeamB = 0;
    }

    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void threePointerA(View view){
        scoreForTeamA += 3;
        displayForTeamA(scoreForTeamA);
    }

    public void twoPointerA(View view){
        scoreForTeamA += 2;
        displayForTeamA(scoreForTeamA);
    }

    public void freeThrowA(View view){
        scoreForTeamA += 1;
        displayForTeamA(scoreForTeamA);
    }


    public void threePointerB(View view){
        scoreForTeamB += 3;
        displayForTeamB(scoreForTeamB);
    }

    public void twoPointerB(View view){
        scoreForTeamB += 2;
        displayForTeamB(scoreForTeamB);
    }

    public void freeThrowB(View view){
        scoreForTeamB += 1;
        displayForTeamB(scoreForTeamB);
    }
    public void resetScores(View view){
        scoreForTeamA = 0;
        scoreForTeamB = 0;
        displayForTeamA(scoreForTeamA);
        displayForTeamB(scoreForTeamB);
    }
}
package com.example.android.soccerscorekeeper;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.android.soccerscorekeeper.R;

public class MainActivity extends AppCompatActivity {
    private int scoreForTeamA;
    private int scoreForTeamB;
    private int foulsForTeamA;
    private int foulsForTeamB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreForTeamA = 0;
        scoreForTeamB = 0;
        foulsForTeamA = 0;
        foulsForTeamB = 0;
    }

    public void displayScoreForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayScoreForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayFoulsForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_fouls);
        scoreView.setText(String.valueOf(score));
    }

    public void displayFoulsForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_fouls);
        scoreView.setText(String.valueOf(score));
    }

    public void scoreA(View view){
        scoreForTeamA += 1;
        displayScoreForTeamA(scoreForTeamA);
    }

    public void scoreB(View view){
        scoreForTeamB += 1;
        displayScoreForTeamB(scoreForTeamB);
    }

    public void foulsA(View view){
        foulsForTeamA += 1;
        displayFoulsForTeamA(foulsForTeamA);
    }

    public void foulsB(View view){
        foulsForTeamB += 1;
        displayFoulsForTeamB(foulsForTeamB);
    }

    public void resetScores(View view){
        scoreForTeamA = 0;
        scoreForTeamB = 0;
        foulsForTeamB = 0;
        foulsForTeamA = 0;
        displayScoreForTeamA(scoreForTeamA);
        displayScoreForTeamB(scoreForTeamB);
        displayFoulsForTeamA(foulsForTeamA);
        displayFoulsForTeamB(foulsForTeamB);
        displayWinner("");
    }

    public void findWinner(View view){
        String winnerMessage = scoreForTeamA > scoreForTeamB ? "Winner Team A!!" : (scoreForTeamA == scoreForTeamB ? "It's a Draw!!" : "Winner Team B!!");
        displayWinner(winnerMessage);
    }

    private void displayWinner(String message){
        TextView scoreView = (TextView) findViewById(R.id.winner_text_view);
        scoreView.setText(message);
    }
}
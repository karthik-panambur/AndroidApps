package com.example.android.chelseaquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    private boolean oneOptionSelected(CheckBox option1,CheckBox option2,CheckBox option3,CheckBox option4){
        int count = 0;
        if(option1.isChecked())count+=1;
        if(option2.isChecked())count+=1;
        if(option3.isChecked())count+=1;
        if(option4.isChecked())count+=1;
        return count == 1 ? true : false;
    }
    private void errorToast(){
        Context context = getApplicationContext();
        CharSequence text = "Please select 1 option for every question";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void scoreToast(int correctAnswers){
        Context context = getApplicationContext();
        CharSequence text = "You scored " + correctAnswers + " out of 5 points";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
    public void checkAnswers(View view){
     int score = 0;
     //Q1

     CheckBox q1O1 = (CheckBox)findViewById(R.id.q1_option1);
     CheckBox q1O2 = (CheckBox)findViewById(R.id.q1_option2);
     CheckBox q1O3 = (CheckBox)findViewById(R.id.q1_option3);
     CheckBox q1O4 = (CheckBox)findViewById(R.id.q1_option4);
     if(!oneOptionSelected(q1O1,q1O2,q1O3,q1O4)){
         errorToast();
         return;
     }
     score = q1O4.isChecked()?score+1:score;

     //Q2

        CheckBox q2O1 = (CheckBox)findViewById(R.id.q2_option1);
        CheckBox q2O2 = (CheckBox)findViewById(R.id.q2_option2);
        CheckBox q2O3 = (CheckBox)findViewById(R.id.q2_option3);
        CheckBox q2O4 = (CheckBox)findViewById(R.id.q2_option4);
        if(!oneOptionSelected(q2O1,q2O2,q2O3,q2O4)){
            errorToast();
            return;
        }
        score = q2O2.isChecked()?score+1:score;

        //Q3

        CheckBox q3O1 = (CheckBox)findViewById(R.id.q3_option1);
        CheckBox q3O2 = (CheckBox)findViewById(R.id.q3_option2);
        CheckBox q3O3 = (CheckBox)findViewById(R.id.q3_option3);
        CheckBox q3O4 = (CheckBox)findViewById(R.id.q3_option4);
        if(!oneOptionSelected(q3O1,q3O2,q3O3,q3O4)){
            errorToast();
            return;
        }
        score = q3O1.isChecked()?score+1:score;
        //Q4
        EditText q4 = (EditText)findViewById(R.id.q4_answer);
        score = q4.getText().toString().equals("2012") ? score +=1: score;

        //Q5

        CheckBox q5O1 = (CheckBox)findViewById(R.id.q5_option1);
        CheckBox q5O2 = (CheckBox)findViewById(R.id.q5_option2);
        CheckBox q5O3 = (CheckBox)findViewById(R.id.q5_option3);
        CheckBox q5O4 = (CheckBox)findViewById(R.id.q5_option4);
        if(!oneOptionSelected(q5O1,q5O2,q5O3,q5O4)){
            errorToast();
            return;
        }
        score = q5O3.isChecked()?score+1:score;

        scoreToast(score);
    }
}

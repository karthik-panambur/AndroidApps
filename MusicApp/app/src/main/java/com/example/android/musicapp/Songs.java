package com.example.android.miwok;

public class Word {
    private String english;
    private String miwok;

    Word(String english, String miwok){
        this.english = english;
        this.miwok = miwok;
    }
    public void setText(String english, String miwok){
        this.english = english;
        this.miwok = miwok;
    }
    public String getDefaultTranslation(){
        return this.english;
    }
    public String getMiwokTranslation(){
        return this.miwok;
    }
}

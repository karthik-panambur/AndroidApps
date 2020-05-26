package com.example.android.musicapp;

public class Songs {
    private String mSongName;
    private String mArtistName;
    private String mAlbumNAme;

    Songs(String song, String artist, String album){
        this.mSongName = song;
        this.mArtistName = artist;
        this.mAlbumNAme = album;
    }
    public void setText(String song, String artist, String album){
        this.mSongName = song;
        this.mArtistName = artist;
        this.mArtistName = album;
    }
    public String getSong(){
        return this.mSongName;
    }
    public String getArtist(){
        return this.mArtistName;
    }
    public  String getAlbum(){ return this.mAlbumNAme; }
}

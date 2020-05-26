package com.example.android.tourguideapp;

import android.widget.ImageView;

public class City {
    private String name;
    private String location;
    private int image = IMAGE_DEFAULT;
    private static final int IMAGE_DEFAULT = -1;
    private String  contact;

    City(String name, String location, int image, String contact){
        this.name = name;
        this.location = location;
        this.image = image;
        this.contact = contact;
    }

    City(String name, String location, int image){
        this.name = name;
        this.location = location;
        this.image = image;
    }

    City(String name, String location){
        this.name = name;
        this.location = location;
    }

    public void setText(String name, String location, int image){
        this.name = name;
        this.location = location;
        this.image = image;
    }

    /**
     * returns the corresponding name City
     * @return
     */
    public String getName(){
        return this.name;
    }

    /**
     * return the correspondong location translation
     * @return
     */
    public String getLocation(){
        return this.location;
    }

    /**
     * return the corresponding image id if present
     * @return
     */
    public int getImage(){
        return this.image;
    }

    /**
     * returns true if an image is present
     * @return
     */
    public boolean hasImage(){
        return image != IMAGE_DEFAULT;
    }

    /**
     * returns the resource id of contact associated with the City
     */
    public String getcontact(){
        return this.contact;
    }
}

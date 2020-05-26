package com.example.android.tourguideapp;

public class City {
    private String name;
    private String location;
    private int image = IMAGE_DEFAULT;
    private static final int IMAGE_DEFAULT = -1;
    private String  operatingHours;

    City(String name, String location, int image, String contact){
        this.name = name;
        this.location = location;
        this.image = image;
        this.operatingHours = contact;
    }

    City(String name, String location, String operatingHours){
        this.name = name;
        this.location = location;
        this.operatingHours = operatingHours;
    }

    City(String name, String location){
        this.name = name;
        this.location = location;
    }

    /**
     * returns the corresponding name
     * @return
     */
    public String getName(){
        return this.name;
    }

    /**
     * return the correspondong location
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
     * returns the corresponding operating hours
     */
    public String getOperatingHours(){
        return this.operatingHours;
    }
}

package com.example.android.newsapp;

public class News {
    private String sectionName;
    private String webTitle;
    private String url;
    private String dateTime;
    private String author;

    /**
     * constructor for the news class
     * @param sectionName
     * @param webTitle
     * @param url
     * @param dateTime
     */
    News(String sectionName, String webTitle, String url, String dateTime, String author){
        this.sectionName = sectionName;
        this.webTitle = webTitle;
        this.url = url;
        this.dateTime = dateTime;
        this.author = author;
    }

    /**
     * getter for returning sectionName
     * @return
     */
    public String getSectionName(){
        return this.sectionName;
    }

    /**
     * getter for returning web title
     * @return
     */
    public  String getWebTitle(){
        return this.webTitle;
    }

    /**
     * getter for returning news url
     * @return
     */
    public String getUrl(){
        return this.url;
    }

    /**
     * getter for returning news was published
     * @return
     */
    public  String getDateTime(){
        return this.dateTime;
    }
    /**
     * getter for returning the author
     * @return
     */
    public String getAuthor(){ return this.author;}
}

package com.example.calendar;

public class Datalist  {
    int image;
    String heading, description;

    public Datalist( int image,String heading,String description) {
        this.image=image;
        this.heading=heading;
        this.description=description;
    }

    public int getImage() {
        return image;
    }

    public String getHeading() {
        return heading;
    }

    public String getDescription() {
        return description;
    }
}

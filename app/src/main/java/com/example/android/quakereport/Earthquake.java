package com.example.android.quakereport;

public class Earthquake {
    double magnitude;
    String location, date;

    Earthquake() {
        magnitude = -1.0;
        location = date = null;
    }

    Earthquake(double magnitude, String location, String date) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public String getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }


}

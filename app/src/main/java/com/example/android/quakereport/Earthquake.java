package com.example.android.quakereport;

public class Earthquake {
    private double magnitude;
    private String location, url;
    private long date;

    Earthquake() {
        magnitude = -1.0;
        location = null;
        date = -1;
    }

    Earthquake(double magnitude, String location, long date, String url) {
        this.magnitude = magnitude;
        this.location = location;
        this.date = date;
        this.url = url;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public long getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public String getUrl() {
        return url;
    }

}

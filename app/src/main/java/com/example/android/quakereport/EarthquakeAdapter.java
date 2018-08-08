package com.example.android.quakereport;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakeArrayList) {
        super(context, 0, earthquakeArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.earthquake_activity, parent, false);

        }

        Earthquake currentEarthquake = getItem(position);

        DecimalFormat magFormat = new DecimalFormat("0.0");
        String mag = magFormat.format(currentEarthquake.getMagnitude());

        TextView magnitudeText = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeText.setText(mag);

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeText.getBackground();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        magnitudeCircle.setColor(magnitudeColor);


        String earthquakeLocation = currentEarthquake.getLocation();
        if(earthquakeLocation.contains("of")) {
            int seperationIndex = earthquakeLocation.indexOf("of") + 3;
            String locationOffset = earthquakeLocation.substring(0, seperationIndex);
            String mainLocation = earthquakeLocation.substring(seperationIndex);

            TextView locationDirection = (TextView) listItemView.findViewById(R.id.location_offset);
            locationDirection.setText(locationOffset);

            TextView locationText = (TextView) listItemView.findViewById(R.id.location);
            locationText.setText(mainLocation);
        }
        else {
            TextView locationText = (TextView) listItemView.findViewById(R.id.location);
            locationText.setText(earthquakeLocation);

            TextView locationOffset = (TextView) listItemView.findViewById(R.id.location_offset);
            locationOffset.setText("Near the");
        }



        TextView dateText = (TextView) listItemView.findViewById(R.id.date);
        Date date = new Date(currentEarthquake.getDate());
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        String formatedDate = dateFormat.format(date);
        dateText.setText(formatedDate);

        TextView timeText = (TextView) listItemView.findViewById(R.id.time);
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        String formattedTime = timeFormat.format(date);
        timeText.setText(formattedTime);


        return listItemView;
    }

    private int getMagnitudeColor(double magnitude) {
        int magIntensity = (int) magnitude;
        int magnitudeColor;
        switch(magIntensity) {
            case 0:
            case 1:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude1);
                break;
            case 2:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude2);
                break;
            case 3:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude3);
                break;
            case 4:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude4);
                break;
            case 5:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude5);
                break;
            case 6:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude6);
                break;
            case 7:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude7);
                break;
            case 8:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude8);
                break;
            case 9:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude9);
                break;
            default:
                magnitudeColor = ContextCompat.getColor(getContext(), R.color.magnitude10plus);
                break;
        }
        return magnitudeColor;
    }
}

package com.example.android.quakereport;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    public EarthquakeAdapter(Activity context, ArrayList<Earthquake> earthquakeArrayList) {
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

        TextView magnitudeText = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeText.setText(Double.toString(currentEarthquake.getMagnitude()));

        TextView locationText = (TextView) listItemView.findViewById(R.id.location);
        Log.d(TAG, "getView: Attempting to set location. Current Location: " + currentEarthquake.getLocation() + " ---------------");
        locationText.setText(currentEarthquake.getLocation());


        TextView dateText = (TextView) listItemView.findViewById(R.id.date);
        dateText.setText(currentEarthquake.getDate());


        return listItemView;
    }
}

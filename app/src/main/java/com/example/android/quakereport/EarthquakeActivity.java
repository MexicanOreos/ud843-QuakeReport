/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_list);

        // Populates the arrayList of Earthquakes extracted from a JSON file.
        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

        ListView earthquakeListView = (ListView) findViewById(R.id.earthquakeListView);

        // Create a new {@link ArrayAdapter} of earthquakes
        //It's final due to the OnItemClickListener
        final EarthquakeAdapter earthquakeAdapter = new EarthquakeAdapter(this, earthquakes);

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(earthquakeAdapter);

        /*
        * The reason we are using a OnItemClickListener instead of a OnClickListener that we used in the Miwok/Spanish app is due to the nature of the app
        * In the Miwok/Spanish app we had a main activity with explicitly stated and made textviews
        * In this app, we have our main ListView begin populated by LinearLayouts that are using
        * an adapter and a recycler. Using onClickListener would just make it so that when any portion
        * of the screen is clicked, the app will just launch one intent, and there is also no way of knowing
        * which earthquake was clicked.
        *
        * An OnItemClickListener is used in conjunction with a view that has an adapter. This lets us
        * know which item (VIEW) in the adapter was clicked and from there we can get the relevant information.
        *
        * Since the adapter is pulling information from the ArrayList of earthquakes, we can get the
        * earthquake from the ArrayList by referring to its position in the adapter. We use get item
        * along with the int to get the position.
        *
        * Now with the earthquake object, we can get the URL that it contains, put that in an implicit
        * intent and start an activity.
        */
        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Earthquake currentEarthquake = earthquakeAdapter.getItem(i);
                Uri earthquakeWebpage = Uri.parse(currentEarthquake.getUrl());
                Intent webIntent = new Intent(Intent.ACTION_VIEW, earthquakeWebpage);
                startActivity(webIntent);
            }
        });

    }
}

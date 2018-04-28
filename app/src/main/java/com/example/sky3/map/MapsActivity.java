package com.example.sky3.map;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
      /*  LatLng sydney = new LatLng(45.51, -122.68);
        mMap.addMarker(new MarkerOptions().position(sydney).title("X"));
        LatLng sydney2 = new LatLng(45.51, -122.69);
        mMap.addMarker(new MarkerOptions().position(sydney2).title("Y"));
        LatLng sydney3 = new LatLng(45.51, -122.67);
        mMap.addMarker(new MarkerOptions().position(sydney3).title("Z"));
*/
        String csvFile = "maps.txt";
        String line = "";
        String cvsSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] coordinates = line.split(cvsSplitBy, 2);
                float latitude = Float.parseFloat(coordinates[0]);
                float longitude = Float.parseFloat(coordinates[1]);
                LatLng location = new LatLng(latitude, longitude);
                mMap.addMarker(new MarkerOptions().position(location).title("X"));
                System.out.println("Latitude:  " + coordinates[0] + " , Longitude: " + coordinates[1]);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }


       // mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}

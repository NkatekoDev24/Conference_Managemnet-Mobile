package com.example.conference_management;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class Events extends FragmentActivity implements OnMapReadyCallback, SearchView.OnQueryTextListener {

    private GoogleMap myMap;
    private FusedLocationProviderClient fusedLocationClient;
    private SearchView svSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);

        svSearch = findViewById(R.id.svSearch);
        svSearch.setOnQueryTextListener(this);

        Button btnSACapitalCity = findViewById(R.id.btnSouthAfricanFinancialCapitalCity);
        Button btnDrawSACapitalCity = findViewById(R.id.btndrawRSAFinancialCapitalCity);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        btnSACapitalCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCurrentLocation();
            }
        });

        btnDrawSACapitalCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawOnCurrentLocation();
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        myMap = googleMap;

        // Enlarge the map by setting the initial zoom level
        myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-26.203656978747734, 28.034589294025594), 15));
    }

    private void getCurrentLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Request location permission if not granted
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                LatLng currentLocation = new LatLng(location.getLatitude(), location.getLongitude());
                                myMap.addMarker(new MarkerOptions()
                                        .position(currentLocation)
                                        .title("Current Location")
                                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                                myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 30));
                                myMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                            } else {
                                Toast.makeText(Events.this, "Could not get current location.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }

    private void drawOnCurrentLocation() {
        // Get the user's current location
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // Request location permission if not granted
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
        } else {
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, new OnSuccessListener<Location>() {
                        @Override
                        public void onSuccess(Location location) {
                            if (location != null) {
                                LatLng currentLocation = new LatLng(location.getLatitude(), location.getLongitude());

                                // Draw a circle on the current location
                                CircleOptions circleOptions = new CircleOptions()
                                        .center(currentLocation)
                                        .radius(300) // Set the radius of the circle in meters
                                        .fillColor(0x550000FF) // Fill color with transparency
                                        .strokeColor(Color.RED) // Stroke color
                                        .strokeWidth(5);

                                Circle circle = myMap.addCircle(circleOptions);

                                // Move the camera to the current location
                                myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 15));
                            } else {
                                Toast.makeText(Events.this, "Could not get current location.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }



    @Override
    public boolean onQueryTextSubmit(String s) {
        performSearch();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }

    private void performSearch() {
        String query = svSearch.getQuery().toString();
        if (!query.isEmpty()) {
            // Perform search and display results on the map
            LatLng location = new LatLng(-26.203656978747734, 28.034589294025594);
            myMap.addMarker(new MarkerOptions().position(location).title(query));
            myMap.moveCamera(CameraUpdateFactory.newLatLng(location));
        } else {
            Toast.makeText(this, "Enter a search query", Toast.LENGTH_SHORT).show();
        }
    }
}


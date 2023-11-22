package com.example.conference_management;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.navigation.NavigationView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import java.sql.Connection;

public class Dashboard extends AppCompatActivity {
    CardView program, events, message, speakers;
    DrawerLayout drawer;
    NavigationView navigationView;
    ImageButton menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        program = findViewById(R.id.programCard);
        events = findViewById(R.id.eventsCard);
        message = findViewById(R.id.messageCard);
        speakers = findViewById(R.id.speakersCard);
        drawer = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        menuButton = findViewById(R.id.menuButton);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open the drawer when the button is clicked
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                }
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.nav_account:
                        // Handle the Account menu item click by starting the AccountPage activity
                        try {
                            Intent accountIntent = new Intent(Dashboard.this, Account.class);
                            startActivity(accountIntent);
                        } catch (Exception e) {
                            e.printStackTrace();
                            Toast.makeText(Dashboard.this, "Error starting Account activity", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.nav_connections:
                        try
                        {
                            Intent connectionsIntent = new Intent(Dashboard.this, connections.class);
                            startActivity(connectionsIntent);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                            Toast.makeText(Dashboard.this, "Error starting Connections activity", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.nav_connect:
                        try
                        {
                            Intent connectIntent = new Intent(Dashboard.this, connect.class);
                            startActivity(connectIntent);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                            Toast.makeText(Dashboard.this, "Error starting Connect Activity", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.nav_settings:
                        // Handle the Settings menu item click
                        try {
                            Intent settingsIntent = new Intent(Dashboard.this, Settings.class);
                            startActivity(settingsIntent);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(Dashboard.this, "Error starting Settings activity", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.nav_signout:
                        try{
                            Intent signOutIntent = new Intent(Dashboard.this, MainActivity.class);
                            startActivity(signOutIntent);
                        }
                        catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(Dashboard.this, "Error Logging Out", Toast.LENGTH_SHORT).show();
                        }
                }
                // Close the drawer after handling the click
                try {
                    drawer.closeDrawer(GravityCompat.START);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return true;
            }
        });

        program.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Schedules.class);
                startActivity(intent);
            }
        });

        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Events.class);
                startActivity(intent);
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Messages.class);
                startActivity(intent);
            }
        });

        speakers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, Help.class);
                startActivity(intent);
            }
        });
    }
}

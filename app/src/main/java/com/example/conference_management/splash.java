package com.example.conference_management;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Add a delay before moving to the main activity
        int splashTimeout = 2000; // 2 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent mainIntent = new Intent(splash.this, MainActivity.class);
                startActivity(mainIntent);
                finish(); // Close the splash activity
            }
        }, splashTimeout);
    }
}
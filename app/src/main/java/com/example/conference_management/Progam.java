package com.example.conference_management;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;

public class Progam extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progam);

        // Sample program data
        List<ProgramItemModel> programItemList = generateSampleProgram();

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.programRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ProgramAdapter adapter = new ProgramAdapter(programItemList);
        recyclerView.setAdapter(adapter);
    }

    // Define the generateSampleProgram function to generate sample program data
    private List<ProgramItemModel> generateSampleProgram() {
        // Create and return a list of ProgramItemModel objects with sample data
        // Replace this with your actual program data or use a data source
        // Example:
        List<ProgramItemModel> programItems = new ArrayList<>();
        programItems.add(new ProgramItemModel("Session 1", "9:00 AM - 10:30 AM", "Room A"));
        programItems.add(new ProgramItemModel("Session 2", "11:00 AM - 12:30 PM", "Room B"));
        // Add more program items as needed
        return programItems;
    }
}
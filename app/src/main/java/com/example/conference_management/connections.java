package com.example.conference_management;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class connections extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ConnectionAdapter connectionAdapter;
    private List<Connection> connectionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connections);

        // Initialize the RecyclerView and its layout manager
        recyclerView = findViewById(R.id.recyclerViewConnections);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Create a list of Connection objects (you can replace this with your own data source)
        connectionList = new ArrayList<>();
        connectionList.add(new Connection("John Doe", true));
        connectionList.add(new Connection("Jane Smith", false));
        // Add more connections as needed

        // Initialize the ConnectionAdapter with the connectionList
        connectionAdapter = new ConnectionAdapter(this, connectionList);

        // Set the adapter for the RecyclerView
        recyclerView.setAdapter(connectionAdapter);
    }
}
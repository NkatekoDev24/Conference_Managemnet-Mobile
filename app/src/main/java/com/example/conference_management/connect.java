package com.example.conference_management;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class connect extends AppCompatActivity {
    private RecyclerView recyclerViewUsers;
//    private UserAdapter userAdapter;
    private List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connect);

        // Initialize RecyclerView
        recyclerViewUsers = findViewById(R.id.recyclerViewUsers);
        userList = new ArrayList<>();
//        userAdapter = new UserAdapter(this, userList);
        recyclerViewUsers.setLayoutManager(new LinearLayoutManager(this));
//        recyclerViewUsers.setAdapter(userAdapter);

        // Load user data and populate userList (e.g., from Firebase Realtime Database)
        // You'll need to implement this part based on your backend and data retrieval logic.
        // Sample data for testing:
//        userList.add(new User("1", "User 1", true));
//        userList.add(new User("2", "User 2", false));
//        userList.add(new User("3", "User 3", true));

        // Notify the adapter that the data has changed
//        userAdapter.notifyDataSetChanged();
    }
}
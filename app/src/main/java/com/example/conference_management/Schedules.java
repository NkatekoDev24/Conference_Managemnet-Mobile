package com.example.conference_management;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Schedules extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ConferenceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedules);

        // Initialize the RecyclerView
        recyclerView = findViewById(R.id.recyclerViewSchedules);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create a list of hardcoded conferences with images from drawables
        List<Conference> conferenceList = createHardcodedConferences();

        // Initialize the adapter with the list of conferences
        adapter = new ConferenceAdapter(conferenceList);
        recyclerView.setAdapter(adapter);
    }

    // Helper method to create hardcoded conferences with images from drawables
    private List<Conference> createHardcodedConferences() {
        List<Conference> conferences = new ArrayList<>();

        // Add conferences with images from drawables
        conferences.add(new Conference(
                1,
                "JS Conference",
                "JS Conference for Front-end developers",
                "10:00:00",
                "2023-02-10",
                "17:00:00",
                "2023-02-12",
                R.drawable.conf
        ));

        conferences.add(new Conference(
                2,
                "Web Development Conference",
                "A conference for web developers and designers",
                "09:30:00.0000000",
                "2023-04-17",
                "18:00:00.0000000",
                "2023-02-12",
                R.drawable.oip
        ));

        conferences.add(new Conference(
                3,
                "Mobile App Summit",
                "A summit for mobile app developers",
                "10:00:00.0000000",
                "2023-06-20",
                "16:30:00.0000000",
                "2023-06-22",
                R.drawable.ic_conf
        ));

        conferences.add(new Conference(
                4,
                "Web Development Conference",
                "A conference for web developers and designers",
                "09:30:00.0000000",
                "2023-04-17",
                "18:00:00.0000000",
                "2023-02-12",
                R.drawable.ic_conf
        ));

        conferences.add(new Conference(
                5,
                "dsfbjkdj,dsa",
                "jkasdbcnxbzcmdbs",
                "00:00:00.0000000",
                "2023-10-27",
                "15:00:00.0000000",
                "2023-10-27",
                R.drawable.ic_conf
        ));

        conferences.add(new Conference(
                6,
                "Web Development Conference",
                "A conference for web developers and designers",
                "09:30:00.0000000",
                "2023-04-17",
                "18:00:00.0000000",
                "2023-02-12",
                R.drawable.ic_conf
        ));

        conferences.add(new Conference(
                7,
                "Web Development Conference",
                "A conference for web developers and designers",
                "09:30:00.0000000",
                "2023-04-17",
                "18:00:00.0000000",
                "2023-02-12",
                R.drawable.ic_conf
        ));

        return conferences;
    }
}

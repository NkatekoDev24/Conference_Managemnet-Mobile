package com.example.conference_management;

// Define a class to represent a schedule item
public class ScheduleSession {
    private int id;
    private String title;
    private String description;
    private String date;
    private String time;
    private String location;

    // Constructors, getters, and setters

    public ScheduleSession(String title, String description, String date, String time, String location) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public ScheduleSession() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}



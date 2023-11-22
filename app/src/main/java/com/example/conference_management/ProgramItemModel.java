package com.example.conference_management;

public class ProgramItemModel {
    private String sessionName;
    private String sessionTime;
    private String sessionLocation;

    public ProgramItemModel(String sessionName, String sessionTime, String sessionLocation) {
        this.sessionName = sessionName;
        this.sessionTime = sessionTime;
        this.sessionLocation = sessionLocation;
    }

    public String getSessionName() {
        return sessionName;
    }

    public String getSessionTime() {
        return sessionTime;
    }

    public String getSessionLocation() {
        return sessionLocation;
    }
}


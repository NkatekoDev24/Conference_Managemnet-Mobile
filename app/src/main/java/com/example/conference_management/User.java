package com.example.conference_management;

public class User {
    private String userId;
    private String displayName; // Add this field
    private String email;

    public User() {
        // Default constructor required for Firebase Realtime Database
    }

    public User(String userId, String displayName, String email) {
        this.userId = userId;
        this.displayName = displayName;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}



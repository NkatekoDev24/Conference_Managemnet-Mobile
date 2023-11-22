package com.example.conference_management;

public class Connection {
    private String name;
    private boolean isOnline;

    public Connection(String name, boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
    }

    public String getName() {
        return name;
    }

    public boolean isOnline() {
        return isOnline;
    }
}

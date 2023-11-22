package com.example.conference_management;

public class Conference {
    private int id;
    private String title;
    private String description;
    private String eventStartTime;
    private String eventStartDate;
    private String eventEndTime;
    private String eventEndDate;
    private int pictureResourceId; // Store the resource ID of the image

    public Conference() {
    }

    public Conference(int id, String title, String description, String eventStartTime, String eventStartDate, String eventEndTime, String eventEndDate, int pictureResourceId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.eventStartTime = eventStartTime;
        this.eventStartDate = eventStartDate;
        this.eventEndTime = eventEndTime;
        this.eventEndDate = eventEndDate;
        this.pictureResourceId = pictureResourceId;
    }

    // Getters and setters for the class members
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

    public String getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(String eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {
        this.eventStartDate = eventStartDate;
    }

    public String getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(String eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }

    public int getPictureResourceId() {
        return pictureResourceId;
    }

    public void setPictureResourceId(int pictureResourceId) {
        this.pictureResourceId = pictureResourceId;
    }
}

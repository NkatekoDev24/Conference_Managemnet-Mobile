package com.example.conference_management;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Exclude;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import java.util.HashMap;
import java.util.Map;

public class Message {
    private String messageId;
    private String text;
    private String senderId;
    private String senderDisplayName; // Add the sender's display name
    private long timestamp; // Store the timestamp as a long value

    public Message() {
        // Default constructor required for Firebase Realtime Database
    }

    public Message(String text, String senderId, String senderDisplayName) {
        this.text = text;
        this.senderId = senderId;
        this.senderDisplayName = senderDisplayName;

        // Use push method to generate a unique message ID
        DatabaseReference messageRef = FirebaseDatabase.getInstance().getReference().child("messages").push();
        this.messageId = messageRef.getKey();

        // Set the timestamp to the current time in milliseconds
        this.timestamp = System.currentTimeMillis();
    }

    // Getters and setters for message fields

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderDisplayName() {
        return senderDisplayName;
    }

    public void setSenderDisplayName(String senderDisplayName) {
        this.senderDisplayName = senderDisplayName;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}




package com.example.conference_management;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    private String chatId; // Unique chat ID
    private List<Message> messages; // List of messages

    public Chat() {
        // Default constructor required for Firebase Realtime Database
    }

    public Chat(String chatId) {
        this.chatId = chatId;
        this.messages = new ArrayList<>();
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    // Add a message to the chat
    public void addMessage(Message message) {
        messages.add(message);
    }

    // Remove a message from the chat
    public void removeMessage(Message message) {
        messages.remove(message);
    }
}


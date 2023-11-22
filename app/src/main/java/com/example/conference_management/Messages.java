package com.example.conference_management;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Messages extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MessageAdapter messageAdapter;
    private List<Message> messageList;
    private EditText editTextMessage;
    private Button buttonSend;

    private FirebaseAuth mAuth;
    private DatabaseReference messagesDatabase;
    private DatabaseReference usersDatabase;
    private DatabaseReference currentUserDb;

    private String currentUserId;
    private String currentUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        mAuth = FirebaseAuth.getInstance();
        currentUserId = mAuth.getCurrentUser().getUid();
        messagesDatabase = FirebaseDatabase.getInstance().getReference().child("messages");
        usersDatabase = FirebaseDatabase.getInstance().getReference().child("users");
        currentUserDb = usersDatabase.child(currentUserId);

        recyclerView = findViewById(R.id.recyclerViewMessages);
        editTextMessage = findViewById(R.id.editTextMessage);
        buttonSend = findViewById(R.id.buttonSend);

        messageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(this, messageList, usersDatabase);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(messageAdapter);

        currentUserDb.child("displayName").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    currentUserName = dataSnapshot.getValue(String.class);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle error
                Toast.makeText(Messages.this, "Error: " + databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage();
            }
        });

        messagesDatabase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, String s) {
                Message message = dataSnapshot.getValue(Message.class);
                messageList.add(message);
                messageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, String s) {
                // Handle changed messages if needed
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
                // Handle removed messages if needed
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, String s) {
                // Handle moved messages if needed
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle error if needed
            }
        });
    }

    private void sendMessage() {
        final String messageText = editTextMessage.getText().toString().trim();
        if (!TextUtils.isEmpty(messageText)) {
            DatabaseReference newMessageRef = messagesDatabase.push();

            // Create a new message with the sender's name
            Message message = new Message(messageText, currentUserId, currentUserName);

            // Add the message to the database
            newMessageRef.setValue(message);

            // Clear the input field
            editTextMessage.setText("");
        } else {
            Toast.makeText(this, "Message can't be empty", Toast.LENGTH_SHORT).show();
        }
    }
}

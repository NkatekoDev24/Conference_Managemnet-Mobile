package com.example.conference_management;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Account extends AppCompatActivity {
    private EditText editTextUsername;
    private EditText editTextEmail;
    private Button buttonChangePassword;
    private Button buttonSaveChanges;

    private FirebaseAuth mAuth;
    private DatabaseReference usersDatabase;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        mAuth = FirebaseAuth.getInstance();
        usersDatabase = FirebaseDatabase.getInstance().getReference().child("users");
        currentUser = mAuth.getCurrentUser();

        editTextUsername = findViewById(R.id.editTextUsername);
        editTextEmail = findViewById(R.id.editTextEmail);
        buttonChangePassword = findViewById(R.id.buttonChangePassword);
        buttonSaveChanges = findViewById(R.id.buttonSaveChanges);

        // Fetch and display the user's information
        if (currentUser != null) {
            editTextEmail.setText(currentUser.getEmail());
            fetchAndDisplayDisplayName(currentUser.getUid());

            // Change Password Button
            buttonChangePassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // Implement password change logic
                    // ...
                }
            });

            // Save Changes Button
            buttonSaveChanges.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    saveDisplayName();
                }
            });
        }
    }

    private void fetchAndDisplayDisplayName(String userId) {
        DatabaseReference userRef = usersDatabase.child(userId).child("displayName");
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    String displayName = dataSnapshot.getValue(String.class);
                    editTextUsername.setText(displayName);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle error
            }
        });
    }

    private void saveDisplayName() {
        String newDisplayName = editTextUsername.getText().toString().trim();
        if (!newDisplayName.isEmpty()) {
            DatabaseReference userRef = usersDatabase.child(currentUser.getUid()).child("displayName");
            userRef.setValue(newDisplayName);
            Toast.makeText(Account.this, "Display name saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(Account.this, "Display name can't be empty", Toast.LENGTH_SHORT).show();
        }
    }
}

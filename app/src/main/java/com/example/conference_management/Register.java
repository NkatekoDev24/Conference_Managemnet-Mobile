package com.example.conference_management;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    Button btnRegister;
    FirebaseAuth mAuth;
    EditText edemail, edpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        FirebaseApp.initializeApp(this);
        mAuth = FirebaseAuth.getInstance();

        btnRegister = findViewById(R.id.registerButton);
        edemail = findViewById(R.id.edName);
        edpassword = findViewById(R.id.editTextTextPersonName2);

        // Inside the onClick method of btnRegister
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = edemail.getText().toString().trim();
                String userPassword = edpassword.getText().toString().trim();

                mAuth.createUserWithEmailAndPassword(userEmail, userPassword)
                        .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(Register.this, MainActivity.class);
                                    startActivity(intent);
                                    Toast.makeText(Register.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(Register.this, "Registration Failed!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

    }
}
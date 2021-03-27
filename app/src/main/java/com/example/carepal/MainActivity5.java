package com.example.carepal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity5 extends AppCompatActivity {

    EditText emailaddress1;
    Button Reset_button;

    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        final EditText emailaddress1 = findViewById(R.id.email1);
        final Button Reset_button = findViewById(R.id.button1);

        auth = FirebaseAuth.getInstance();
        Reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetpwd();

            }
        });
    }

    private void resetpwd() {
        String email = emailaddress1.getText().toString().trim();
        if (email.isEmpty()) {
            emailaddress1.setError("Please enter email id");
            emailaddress1.requestFocus();
        }
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailaddress1.setError("provide valid email");
            emailaddress1.requestFocus();
        }
        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity5.this, "check your email address", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity5.this, "Try again", Toast.LENGTH_LONG).show();
                }
            }

        });
    }
}
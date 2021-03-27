package com.example.carepal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText emailaddress, PassWord;
    private Button Login_button, Register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        Button Login_button = (Button) findViewById(R.id.button1);
        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addF=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(addF);

            }
        });

        final EditText emailaddress = findViewById(R.id.email1);
        final EditText PassWord = findViewById(R.id.Password1);
        final Button Register_button = findViewById(R.id.Button1);

        Register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailaddress.getText().toString().trim();
                String password = PassWord.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    emailaddress.setError("Email Required");
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    PassWord.setError("Password Required");
                    return;
                }
                if (password.length() < 6) {
                    PassWord.setError("Password should be atleast of 6 characters long");
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                            Intent intSignUp = new Intent(MainActivity.this, MainActivity2.class);
                            startActivity(intSignUp);

                        } else {
                            Toast.makeText(MainActivity.this, "Error! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });
            }

        });
    }
}
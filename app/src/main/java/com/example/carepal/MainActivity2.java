package com.example.carepal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity2 extends AppCompatActivity{
    EditText emailaddress, PassWord;
    Button Login_button, Reset_button;


    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        mFirebaseAuth = FirebaseAuth.getInstance();
        final EditText  emailaddress = findViewById(R.id.email1);
        final EditText PassWord = findViewById(R.id.Password1);
        final Button Login_button=findViewById(R.id.button1);
        final Button Reset_button=findViewById(R.id.button2);

        Reset_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToReset = new Intent(MainActivity2.this,MainActivity5.class);
                startActivity(intToReset);


            }
        });



        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if( mFirebaseUser != null ){
                    Toast.makeText(MainActivity2.this,"You are logged in",Toast.LENGTH_LONG).show();
                    Intent i = new Intent(MainActivity2.this, MainActivity3.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(MainActivity2.this,"Please Login",Toast.LENGTH_LONG).show();
                }
            }
        };
        Login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailaddress.getText().toString();
                String password = PassWord.getText().toString();
                if(email.isEmpty()){
                    emailaddress.setError("Please enter email id");
                    emailaddress.requestFocus();
                }
                else  if(TextUtils.isEmpty(password)){
                    PassWord.setError("Please enter your password");

                }
                else  if(TextUtils.isEmpty(email) && TextUtils.isEmpty(password)){
                    Toast.makeText(MainActivity2.this,"Fields Are Empty!",Toast.LENGTH_LONG).show();
                }
                else  if(!(TextUtils.isEmpty(email) && TextUtils.isEmpty(password))){
                    mFirebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity2.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent intToHome = new Intent(MainActivity2.this,MainActivity3.class);
                                startActivity(intToHome);

                            }
                            else{
                                Toast.makeText(MainActivity2.this,"Login Error, Please Login Again",Toast.LENGTH_LONG).show();

                            }
                        }
                    });
                }
                else{
                    Toast.makeText(MainActivity2.this,"Error Occurred!",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}

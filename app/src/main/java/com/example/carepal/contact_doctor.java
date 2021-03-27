package com.example.carepal;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class contact_doctor extends AppCompatActivity {
    DatabaseReference myRef;
    String number;
    EditText editText, numEntry;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_layout);

        Button callButton = (Button) findViewById(R.id.button_callDoctor);
        Button smsButton = (Button) findViewById(R.id.button_sendTextDoctor);
        editText = (EditText) findViewById(R.id.id_editTextDoctor);
       myRef = FirebaseDatabase.getInstance().getReference().child("Member").child("member1").child("personalInfo");

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef = FirebaseDatabase.getInstance().getReference().child("Member").child("member1").child("personalInfo");
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        number = dataSnapshot.child("dnum").getValue().toString();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
                makePhoneCall();
            }
        });

        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                    if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED) {
                        sendText();
                    }
                    else {
                        requestPermissions(new String[] {Manifest.permission.SEND_SMS}, 1);
                    }
                }

            }
        });
    }

    public void makePhoneCall() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+number));
        startActivity(intent);
    }

    public void sendText() {
        try {
            SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(number,null,editText.getText().toString(),null,null);
            Toast.makeText(this, "Message Sent", Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this,"Failed to send",Toast.LENGTH_LONG).show();
        }

    }
}

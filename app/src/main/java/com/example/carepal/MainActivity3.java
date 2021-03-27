package com.example.carepal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity3 extends AppCompatActivity {

    Button Enter_info,Update_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button button_enterInfo = (Button) findViewById(R.id.button5);
        Button button_vitalSign = (Button) findViewById(R.id.button12);
        Button  button_medication = (Button) findViewById(R.id.button11);
        Button button_diet = (Button) findViewById(R.id.button10);
        Button  button_search = (Button) findViewById(R.id.button9);
        Button  button_monitoring = (Button) findViewById(R.id.button8);
        Button  button_communication = (Button) findViewById(R.id.button7);


        // opens entering personal info component
        button_enterInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToEnter = new Intent(MainActivity3.this,MainActivity4.class);
                startActivity(intToEnter);
            }
        });

        // opens vital sign component
        button_vitalSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this,VitalSignMain.class);
                startActivity(intent);
            }
        });

        // opens medications component
        button_medication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this,MedicationsMain.class);
                startActivity(intent);
            }
        });

        // opens diet component
        button_diet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this,diet_main.class);
                startActivity(intent);
            }
        });

        // opens search component
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this,search_main.class);
                startActivity(intent);
            }
        });

        // opens monitoring component
        button_monitoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this,main_monitor.class);
                startActivity(intent);
            }
        });

        // opens communication component
        button_communication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, contact_info.class);
                startActivity(intent);
            }
        });


    }
}

package com.example.carepal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Member;
import java.util.Calendar;

public class AddNewMedication extends AppCompatActivity {
    DatabaseReference reff;
    long id = 0;
    TimePicker timePicker;
    int notificationId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_medication);

        timePicker = (TimePicker) findViewById(R.id.timePicker);
        MedList medlist = new MedList();
        reff = FirebaseDatabase.getInstance().getReference().child("Member").child("member1").child("medications");
        //Save button
        Button SaveBtn = (Button) findViewById(R.id.saveBtn);
        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int duration = Toast.LENGTH_LONG;
                Context context = getApplicationContext();

                EditText medname = (EditText) findViewById(R.id.medname);
                String mediname = medname.getText().toString();
                EditText docname = (EditText) findViewById(R.id.docname);
                String doctorname = docname.getText().toString();
                EditText medtime = (EditText) findViewById(R.id.medtime);
                String meditime = medtime.getText().toString();

                medlist.setMediname(mediname);
                medlist.setDoctorname(doctorname);
                medlist.setMeditime(meditime);

                reff.child(mediname).setValue(medlist);

                Toast saved = Toast.makeText(context, "Saved!", duration);
                saved.show();
            }
        });


        Button setAlarmBtn = (Button) findViewById(R.id.setAlarmBtn);
        setAlarmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent
                Intent intent = new Intent(AddNewMedication.this, Alarm.class);
                intent.putExtra("notificationId", notificationId);
                intent.putExtra("message", "Take your medication!");

                // PendingIntent
                PendingIntent pendingIntent = PendingIntent.getBroadcast(
                        AddNewMedication.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT
                );

                // AlarmManager
                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);


                int hour = timePicker.getCurrentHour();
                int minute = timePicker.getCurrentMinute();

                // Create time.
                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR_OF_DAY, hour);
                startTime.set(Calendar.MINUTE, minute);
                startTime.set(Calendar.SECOND, 0);
                long alarmStartTime = startTime.getTimeInMillis();

                // Set Alarm
                alarmManager.set(AlarmManager.RTC, alarmStartTime, pendingIntent);
                Toast.makeText(AddNewMedication.this, "Done!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

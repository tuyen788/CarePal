package com.example.carepal;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class main_monitor extends AppCompatActivity implements message.messageListener, warning.warningListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.monitor_main);

        Button yes_button = (Button) findViewById(R.id.yes_button);
        Button no_button = (Button) findViewById(R.id.no_button);

        yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMessage();
            }
        });

        no_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWarning();
            }
        });
    }

    public void openMessage(){
        DialogFragment inform = new message();
        inform.show(getSupportFragmentManager(), "");
    }

    public void openWarning()
    {
        warning warn = new warning();
        warn.show(getSupportFragmentManager(),"warn");
    }

    @Override
    public void onOkClicked() {
        openYes();
    }
    public void clicked() { openYes(); }

    public void openYes(){
        Intent intent = new Intent(this, take.class);
        startActivity(intent);
    }
}




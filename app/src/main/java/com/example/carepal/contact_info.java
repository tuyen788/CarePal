package com.example.carepal;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
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

public class contact_info extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.communication);
        Button clickDoctor = (Button) findViewById(R.id.button_doctor);
        Button clickKin = (Button) findViewById(R.id.button_kin);

        clickDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDoctor();
            }
        });

        clickKin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKin();
            }
        });
    }

    public void openDoctor() {
        Intent intent = new Intent(getApplicationContext(), contact_doctor.class);
        startActivity(intent);
    }

    public void openKin() {
        Intent intent = new Intent(contact_info.this, contact_kin.class);
        startActivity(intent);
    }
}

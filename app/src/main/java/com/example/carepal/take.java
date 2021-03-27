package com.example.carepal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class take extends AppCompatActivity implements warning.warningListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take2);

        Button clickYes = (Button) findViewById(R.id.ryes_button);
        Button clickNo = (Button) findViewById(R.id.rno_button);
        clickYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast();
                Intent intent = new Intent(take.this, main_monitor.class);
                startActivity(intent);
            }
        });

        clickNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWarning();
            }
        });
    }

    public void openWarning()
    {
        warning warn = new warning();
        warn.show(getSupportFragmentManager(),"warn");
    }

    public void showToast() {
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_root));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);

        toast.show();

    }

    @Override
    public void clicked() {
        openYes();
    }

    public void openYes(){
        Intent intent = new Intent(take.this, main_monitor.class);
        startActivity(intent);
    }
}
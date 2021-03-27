package com.example.carepal;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.ContactsContract;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class search_medname extends AppCompatActivity {
    DatabaseReference reff;
    EditText smed;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.layout_searchmedic);
        reff = FirebaseDatabase.getInstance().getReference().child("Member").child("member1").child("medications");
        smed = (EditText) findViewById(R.id.id_sMname);
    }
}

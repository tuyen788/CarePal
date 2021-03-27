package com.example.carepal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class search_main extends AppCompatActivity {
    Button search_doc, search_med, search_visit;
    String lvisit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_search);

        search_doc = (Button) findViewById(R.id.button_sDocName);
        search_med = (Button) findViewById(R.id.button_sMedic);
        search_visit = (Button) findViewById(R.id.button_sVisit);

        search_doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(search_main.this, search_dname.class);
                startActivity(intent);
            }
        });

        search_med.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(search_main.this, search_medname.class);
                startActivity(intent);
            }
        });

        search_visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display_lastvisit();
            }
        });
    }

    public void display_lastvisit() {
        Member member = new Member();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("Member").child(member.getName().toString().trim()).child("personalInfo");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
               lvisit = snapshot.child("dname").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        Toast.makeText(search_main.this, lvisit, Toast.LENGTH_LONG).show();
    }
}

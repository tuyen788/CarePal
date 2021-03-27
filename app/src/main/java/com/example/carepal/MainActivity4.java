package com.example.carepal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity4 extends AppCompatActivity {
    EditText name, age, height, weight, gender, dname, dnum, ddate, kin, knum;
    Button saveinfo, display, update;
    DatabaseReference reff;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        name = findViewById(R.id.name1);
        age = findViewById(R.id.age1);
        height = findViewById(R.id.height1);
        weight = findViewById(R.id.weight1);
        gender = findViewById(R.id.gender1);
        dname = findViewById(R.id.dname1);
        dnum = findViewById(R.id.doc_num);
        ddate = findViewById(R.id.ddate1);
        kin = findViewById(R.id.kin1);
        knum = findViewById(R.id.kin_num);
        saveinfo = findViewById(R.id.saveinfo1);
        display = findViewById(R.id.display1);
        update = findViewById(R.id.update1);
        member = new Member();

        reff = FirebaseDatabase.getInstance().getReference().child("Member");

        saveinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                member.setName(name.getText().toString().trim());
                member.setAge(age.getText().toString().trim());
                member.setHeight(height.getText().toString().trim());
                member.setWeight(weight.getText().toString().trim());
                member.setGender(gender.getText().toString().trim());
                member.setDname(dname.getText().toString().trim());
                member.setDnum(dnum.getText().toString().trim());
                member.setDdate(ddate.getText().toString().trim());
                member.setKin(kin.getText().toString().trim());
                member.setKnum(knum.getText().toString().trim());
                reff.child("member1").child("personalInfo").setValue(member);
                Toast.makeText(MainActivity4.this, "Information Saved", Toast.LENGTH_LONG).show();


            }
        });
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff = FirebaseDatabase.getInstance().getReference().child("Member").child("member1").child("personalInfo");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String Name = (dataSnapshot.child("name").getValue().toString());
                        String Age = (dataSnapshot.child("age").getValue().toString());
                        String Height = (dataSnapshot.child("height").getValue().toString());
                        String Weight = (dataSnapshot.child("weight").getValue().toString());
                        String Gender = (dataSnapshot.child("gender").getValue().toString());
                        String Dname = (dataSnapshot.child("dname").getValue().toString());
                        String Dnum = (dataSnapshot.child("dnum").getValue().toString());
                        String Ddate = (dataSnapshot.child("ddate").getValue().toString());
                        String Kin = (dataSnapshot.child("kin").getValue().toString());
                        String Knum = (dataSnapshot.child("knum").getValue().toString());

                        name.setText(Name);
                        age.setText(Age);
                        height.setText(Height);
                        weight.setText(Weight);
                        gender.setText(Gender);
                        dname.setText(Dname);
                        dnum.setText(Dnum);
                        ddate.setText(Ddate);
                        kin.setText(Kin);
                        knum.setText(Knum);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToUpdate = new Intent(MainActivity4.this, MainActivity6.class);
                startActivity(intToUpdate);
            }
        });


    }
}
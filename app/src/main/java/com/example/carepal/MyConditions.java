package com.example.carepal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MyConditions extends AppCompatActivity
{
    DatabaseReference reff1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_conditions);
        TextView blPressureTv = findViewById(R.id.blPressureTv);
        TextView blSugarTv = findViewById(R.id.blSugarTv);
        TextView ChoHDLTv = findViewById(R.id.ChoHDLTv);
        TextView ChoLDLTv = findViewById(R.id.ChoLDLTv);
        TextView TriTv = findViewById(R.id.TriglyTv);

        reff1 = FirebaseDatabase.getInstance().getReference().child("Member").child("member1").child("vitalSign");
        reff1.addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                int ublPress;
                int lblPress;
                int blSugar ;
                int choH ;
                int choL;
                int Trigl;

                if(dataSnapshot.child("ublPressure") == null)
                {
                    ublPress = 0;
                }
                else
                {
                    ublPress = Integer.valueOf(dataSnapshot.child("ublPressure").getValue().toString());
                }

                if(dataSnapshot.child("lblPressure") == null)
                {
                    lblPress = 0;
                }
                else
                {
                    lblPress = Integer.valueOf(dataSnapshot.child("lblPressure").getValue().toString());
                }
                if(dataSnapshot.child("choHDL")== null)
                {
                    blSugar = 0;
                }
                else
                {
                    blSugar = Integer.valueOf(dataSnapshot.child("blSugar").getValue().toString());
                }
                if(dataSnapshot.child("choHDL")== null)
                {
                    choH = 0;
                }
                else
                {
                    choH = Integer.valueOf(dataSnapshot.child("choHDL").getValue().toString());
                }
                if(dataSnapshot.child("choLDL")== null)
                {
                    choL = 0;
                }
                else
                {
                    choL = Integer.valueOf(dataSnapshot.child("choLDL").getValue().toString());
                }
                if(dataSnapshot.child("trigly") == null)
                {
                    Trigl = 0;
                }
                else
                {
                    Trigl = Integer.valueOf(dataSnapshot.child("trigly").getValue().toString());
                }
                String blPressureMsg, blSugarMsg, ChoHDLMsg, ChoLDLMsg, TriMsg;
                //form messages
                //blood pressure
                if(ublPress <= 0)
                {
                    blPressureMsg = "There is no record for Blood Pressure";
                }
                else if (ublPress<120)
                {
                    blPressureMsg = "Normal.\nMaintain your healthy lifestyle.";
                }
                else if (ublPress>=120 && ublPress<=129)
                {
                    blPressureMsg = "Elevated.\nAdopt a health lifestyle.";
                }
                else if (ublPress>=130 && ublPress<=139)
                {
                    blPressureMsg = "Stage 1 Hypertension.\nAdopt a health lifestyle.\nTalk to your doctor about taking medications";
                }
                else
                {
                    blPressureMsg = "Stage 2 Hypertension.\nAdopt a health lifestyle.\nTalk to your doctor about taking medications";
                }

                //blood sugar
                if(blSugar <= 0)
                {
                    blSugarMsg = "There is no record for Blood Pressure";
                }
                else if (blSugar < 100)
                {
                    blSugarMsg = "Normal.\nMaintain your healthy diet.";
                }
                else if (blSugar < 130)
                {
                    blSugarMsg = "Medium High.\nAdopt a low sugar diet.";
                }
                else
                {
                    blSugarMsg = "Very High.\nTalk to doctor immediately for medications.";
                }

                //ChoHDL
                if(choH <= 0)
                {
                    ChoHDLMsg = "There is no record for Blood Pressure";
                }
                else if(choH<50)
                {
                    ChoHDLMsg = "Low.\nNeed improvement.";
                }
                else
                {
                    ChoHDLMsg = "Normal.\nMaintain your healthy lifestyle.";
                }

                //ChoLDL
                if(choL <= 0)
                {
                    ChoLDLMsg = "There is no record for Blood Pressure";
                }
                else if(choL<100)
                {
                    ChoLDLMsg = "Optimal.\nMaintain your healthy lifestyle.";
                }
                else if(choL>=100 && choL<=129)
                {
                    ChoLDLMsg = "Near Optimal.\nAdopt a healthy lifestyle.";
                }
                else
                {
                    ChoLDLMsg = "High.\nAdopt a healthy lifestyle.\nTalk to doctor for medication.";
                }

                //Trigly
                if(Trigl <= 0)
                {
                    TriMsg = "There is no record for Blood Pressure";
                }
                else if (Trigl < 150)
                {
                    TriMsg = "Optimal.\nMaintain your healthy lifestyle.";
                }
                else
                {
                    TriMsg = "High.\nAdopt a healthy lifestyle.\nTalk to doctor for medication.";
                }

                blPressureTv.setText(blPressureMsg);

                blSugarTv.setText(blSugarMsg);

                ChoHDLTv.setText(ChoHDLMsg);

                ChoLDLTv.setText(ChoLDLMsg);

                TriTv.setText(TriMsg);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {

            }

        });



    }
}
package com.example.carepal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VitalSignMain extends AppCompatActivity {

    int[] readings = new int[5];
    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vital_sign);

        VitalSign vital_signs = new VitalSign();
        reff = FirebaseDatabase.getInstance().getReference().child("Member");
        //Save button
        Button SaveBtn = (Button) findViewById(R.id.SaveBtn);
        SaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int duration = Toast.LENGTH_LONG;
                Context context = getApplicationContext();

                EditText ublPressure = (EditText) findViewById(R.id.UpperblPressureBox);
                int ublPress = Integer.valueOf(ublPressure.getText().toString().trim());
                EditText lblPressure = (EditText) findViewById(R.id.LowerblPressureBox);
                int lblPress = Integer.valueOf(lblPressure.getText().toString().trim());
                EditText blSugar = (EditText) findViewById(R.id.blSugerBox);
                int blSug = Integer.valueOf(blSugar.getText().toString().trim());
                EditText ChoHDL = (EditText) findViewById(R.id.ChoHDLBox);
                int choH = Integer.valueOf(ChoHDL.getText().toString().trim());
                EditText ChoLDL = (EditText) findViewById(R.id.ChoLDLBox);
                int choL = Integer.valueOf(ChoLDL.getText().toString().trim());
                EditText Tri = (EditText) findViewById(R.id.TriBox);
                int Trigl = Integer.valueOf(Tri.getText().toString().trim());

                vital_signs.setUblPressure(ublPress);
                vital_signs.setLblPressure(lblPress);
                vital_signs.setBlSugar(blSug);
                vital_signs.setChoHDL(choH);
                vital_signs.setChoLDL(choL);
                vital_signs.setTrigly(Trigl);
                reff.child("member1").child("vitalSign").setValue(vital_signs);

                Toast saved = Toast.makeText(context, "Saved!", duration);
                saved.show();
            }
        });


        //My conditions button
        Button MyConditionsBtn = (Button) findViewById(R.id.MyConditionsBtn);
        MyConditionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MyConditionsIntent = new Intent(getApplicationContext(), MyConditions.class);
                //MyConditionsIntent.putExtra("readingsArray", readings);
                startActivity(MyConditionsIntent);
            }
        });

        //Maintain Tips button
        Button MaintainTipsBtn = (Button) findViewById(R.id.MaintainTipsBtn);
        MaintainTipsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MaintainTipsIntent = new Intent(getApplicationContext(), MaintainTips.class);
                startActivity(MaintainTipsIntent);
            }
        });

    }

}

package com.example.carepal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MedicationsMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medication_main);

        //see list button
        Button listBtn = (Button)findViewById(R.id.listBtn);
        listBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent SeeMedListIntent = new Intent(getApplicationContext(), SeeMedList.class);
                startActivity(SeeMedListIntent);
            }
        });

        //add new button
        Button addBtn = (Button)findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent AddNewMedicationIntent = new Intent(getApplicationContext(), AddNewMedication.class);
                startActivity(AddNewMedicationIntent);
            }
        });

        //delete button
        Button deleteBtn = (Button)findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent DeleteMedIntent = new Intent(getApplicationContext(), DeleteMed.class);
                startActivity(DeleteMedIntent);
            }
        });
    }
}
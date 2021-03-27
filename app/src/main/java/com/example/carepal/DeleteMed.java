package com.example.carepal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DeleteMed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_med);
        Context context = getApplicationContext();
        Button deleteBtns = (Button) findViewById(R.id.deleteBtns);
        EditText mednameToDelete = (EditText) findViewById(R.id.mednameToDelete);


        deleteBtns.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String toDelete = mednameToDelete.getText().toString();
                DatabaseReference mednameReff = (FirebaseDatabase.getInstance().getReference().child("Member").child("member1").child("medications")).child(toDelete);
                mednameReff.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(context, "Medication delete!", Toast.LENGTH_LONG).show();
                    }
                });

            }
        });
    }
}

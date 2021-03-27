    package com.example.carepal;

    import androidx.appcompat.app.AppCompatActivity;

    import android.os.Bundle;
    import android.view.Gravity;
    import android.view.LayoutInflater;
    import android.view.ViewGroup;
    import android.widget.Button;
    import android.content.Intent;
    import android.view.View;
    import android.widget.EditText;
    import android.widget.Toast;

    import com.google.android.gms.tasks.Task;
    import com.google.firebase.database.DatabaseReference;
    import com.google.firebase.database.FirebaseDatabase;
    import android.app.Activity;


    public class Add_Food extends AppCompatActivity {
    diet_member member;
    EditText AddFood,Calorie;
    Button done,cancel;
    DatabaseReference reff;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add__food);
            done=(Button) findViewById(R.id.don);
            cancel=(Button) findViewById(R.id.can);
            AddFood=(EditText)findViewById(R.id.food);
            Calorie=(EditText)findViewById(R.id.calorie);

            member= new diet_member();
            reff= FirebaseDatabase.getInstance().getReference().child("Member").child("member1").child("food");
            done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(AddFood.length()==0){
                        AddFood.setError("Enter Food Name");

                    }
                    else if(Calorie.length()==0){
                        Calorie.setError("Enter Calorie");
                    }
                    else{
                    showToast();
                    Float calorie=Float.parseFloat((Calorie.getText().toString().trim()));
                    member.setFoodName(AddFood.getText().toString().trim());
                    member.setCalorie(calorie);
                    reff.setValue(member);
                    Intent donn=new Intent(Add_Food.this,diet_main.class);
                    startActivity(donn);

                }}
        });



           cancel.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   Intent can=new Intent(Add_Food.this,diet_main.class);
                   startActivity(can);
               }
           });
        }

        public void showToast() {
            LayoutInflater inflater = getLayoutInflater();
            View layout=inflater.inflate(R.layout.toast_success,(ViewGroup)findViewById(R.id.toast_root));
            Toast toast=new Toast(getApplicationContext());
            toast.setGravity(Gravity.CENTER,0,0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        }
    }
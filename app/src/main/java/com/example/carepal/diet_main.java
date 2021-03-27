    package com.example.carepal;

    import androidx.appcompat.app.AppCompatActivity;

    import android.os.Bundle;
    import android.widget.Button;
    import android.content.Intent;
    import android.view.View;
    import android.widget.TextView;
    import android.widget.Toast;


    public class diet_main extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dietmain);
            Button add=(Button) findViewById(R.id.add);
            Button dis=(Button) findViewById(R.id.dis);
            Button cancel = (Button) findViewById(R.id.can);
            add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent can=new Intent(diet_main.this,Add_Food.class);
                    startActivity(can);
                }
            });

            dis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent can=new Intent(diet_main.this,display_chart.class);
                    startActivity(can);
                }
            });

            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent can=new Intent(diet_main.this,MainActivity3.class);
                    startActivity(can);
                }
            });
        }

    }
package com.example.carepal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MaintainTips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain_tips);

        String blPressureMsg = "BLOOD PRESSURE:\n\t- Lose extra pounds\n\t- Reduce sodium in your diet\n\t- Quit smoking and cut back on caffeine" ;
        String blSugarMsg = "BLOOD SUGAR:\n\t- Control your Carb intake\n\t- Drink water and stay hydrated\n\t- Increase Fiber intake";
        String ChoHDLMsg = "CHOLESTEROL HDL:\n\t- Lose extra weight\n\t- Choose better fat in fish and nuts";
        String ChoLDLMsg = "CHOLESTEROL LDL:\n\t - Add to your diet: oats, whole grains, beans, nuts\n\t\tfruits, fiber rich food";
        String TriMsg = "TRIGLYCERIDES:\n\t - Limit sugar intake\n\t- Avoid trans/saturated fat\n\t- Reduce alcohol intake";

        TextView blPressureTv = findViewById(R.id.blPressMt);
        blPressureTv.setText(blPressureMsg);

        TextView blSugarTv = findViewById(R.id.blSugarMt);
        blSugarTv.setText(blSugarMsg);

        TextView ChoHDLTv = findViewById(R.id.ChoHDLMt);
        ChoHDLTv.setText(ChoHDLMsg);

        TextView ChoLDLTv = findViewById(R.id.ChoLDLMt);
        ChoLDLTv.setText(ChoLDLMsg);

        TextView TriTv = findViewById(R.id.TriMt);
        TriTv.setText(TriMsg);
    }
}
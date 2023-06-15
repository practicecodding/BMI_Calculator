package com.hamidul.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edWeight,edFeet,edInch;
    TextView tvResult;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //======================================================================================================================

        //+++++++++++++++++++++++++++++++++++++++
        edWeight = findViewById(R.id.edWeight);
        edFeet = findViewById(R.id.edFeet);
        edInch = findViewById(R.id.edInch);
        tvResult = findViewById(R.id.tvResult);
        button = findViewById(R.id.button);
        //=======================================

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sWeight,sFeet,sInch;
                Float wight;
                Float feet;
                Float inch;
                double height;
                double bmi;

                //String Start
                sWeight = edWeight.getText().toString();
                if (sWeight.equals("")){
                    edWeight.setError("Please Enter Your Weight");
                    edWeight.requestFocus();
                    return;
                }
                sFeet = edFeet.getText().toString();
                if (sFeet.equals("")) {
                    edFeet.setError("Please Enter Your Height");
                    edFeet.requestFocus();
                    return;
                }
                sInch = edInch.getText().toString();
                    if (sInch.equals("")) {
                        edInch.setError("Please Enter Your Height");
                        edInch.requestFocus();
                        return;
                    }
                //String End

                //Float Start
                wight = Float.parseFloat(sWeight);
                feet = Float.parseFloat(sFeet);
                inch = Float.parseFloat(sInch);
                height = feet*0.3048 + inch*0.0254;
                bmi = wight/(height*height);
                //Float End

                tvResult.setText("Your BMI Index is "+bmi);
                tvResult.setVisibility(View.VISIBLE);







            }
        });











    }
}
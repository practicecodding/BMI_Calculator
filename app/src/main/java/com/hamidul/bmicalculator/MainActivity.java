package com.hamidul.bmicalculator;

import androidx.activity.OnBackPressedCallback;
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
                Float wight,feet,inch;

                //String Start
                sWeight = edWeight.getText().toString();
                sFeet = edFeet.getText().toString();
                sInch = edInch.getText().toString();
                //String End

                //Float Start
                wight = Float.parseFloat(sWeight);
                feet = Float.parseFloat(sFeet);
                inch = Float.parseFloat(sInch);
                //Float End







            }
        });











    }
}
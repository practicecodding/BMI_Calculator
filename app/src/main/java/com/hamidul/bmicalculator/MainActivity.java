package com.hamidul.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

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

        edWeight.addTextChangedListener(textWatcher);
        edFeet.addTextChangedListener(textWatcher);
        edInch.addTextChangedListener(textWatcher);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sWeight,sFeet,sInch;
                float wight;
                float feet;
                float inch;
                float height;
                float bmi;
                DecimalFormat decimalFormat = new DecimalFormat("#.#");

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
                height = (float) (feet*0.3048 + inch*0.0254);
                bmi = (float) (wight/(height*height));
                bmi = Float.valueOf(decimalFormat.format(bmi));
                //Float End

                if (inch>12){
                    edInch.setError("Please Enter Your Valid Inch");
                    edInch.requestFocus();
                    return;
                } else
                if (bmi>24){
                    tvResult.setText("Over Wait \n\nYour BMI Index is "+bmi);
                    tvResult.setVisibility(View.VISIBLE);
                } else if (bmi>=18) {
                    tvResult.setText("Normal \n\nYour BMI Index is "+bmi);
                    tvResult.setVisibility(View.VISIBLE);
                }else {
                    tvResult.setText("Under Wait \n\nYour BMI Index is "+bmi);
                    tvResult.setVisibility(View.VISIBLE);
                }

                //tvResult.setText("Your BMI Index is "+bmi);
                //tvResult.setVisibility(View.VISIBLE);

            }
        });

    } //onCreate

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private TextWatcher textWatcher =new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

            String Weight = edWeight.getText().toString();
            String Feet = edFeet.getText().toString();
            String Inch = edInch.getText().toString();

            //button.setEnabled(!Weight.isEmpty() && !Feet.isEmpty() && !Inch.isEmpty());

            if (count<before){
                tvResult.setVisibility(View.GONE);
            } else {
                tvResult.setVisibility(View.GONE);
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

}
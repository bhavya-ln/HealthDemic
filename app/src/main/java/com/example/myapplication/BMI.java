package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityBMIBinding;

public class BMI extends AppCompatActivity {
    static final String EXTRA_WEIGHT ="com.example.myapplication.extra.WEIGHT" ;
    static final String EXTRA_BMI ="com.example.myapplication.extra.BMI" ;
    static final String EXTRA_HEIGHT ="com.example.myapplication.extra.HEIGHT" ;
    EditText Weight;
    EditText Height;
    Button next;
    Button dietp;
    TextView bmires;
    ActivityBMIBinding activityBMIBinding;
    double  weight;
    double height;
    double bmi;
    String bmi1;
    String weight1;
    String height1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBMIBinding=ActivityBMIBinding.inflate(getLayoutInflater());
        setContentView(activityBMIBinding.getRoot());
        activityBMIBinding.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(activityBMIBinding.Weight.getText())) {
                    Toast.makeText(BMI.this,"Please enter your weight!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(activityBMIBinding.Height.getText())) {
                    Toast.makeText(BMI.this,"Please enter your height!",Toast.LENGTH_SHORT).show();
                    return;
                }
                weight=Double.parseDouble(String.valueOf(activityBMIBinding.Weight.getText())) ;
                height=Double.parseDouble(String.valueOf(activityBMIBinding.Height.getText()));
                double h= height/100;
                double hsqur=h*h;
                bmi= (weight/hsqur);
                bmi1= Double.toString(bmi);
                weight1=activityBMIBinding.Weight.getText().toString();
                height1=activityBMIBinding.Height.getText().toString();
                activityBMIBinding.bmires.setText("Your BMI is :"+bmi+" kilograms per sq.meter ");
            }
        });
    }

    public void openBMI(View view){
        if (TextUtils.isEmpty(activityBMIBinding.Weight.getText())) {
            Toast.makeText(BMI.this,"Please enter your weight!",Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(activityBMIBinding.Height.getText())) {
            Toast.makeText(BMI.this,"Please enter your height!",Toast.LENGTH_SHORT).show();
            return;
        }


        Intent intent=new Intent(this,DietPlan.class);
        intent.putExtra(EXTRA_BMI,bmi1);
        intent.putExtra(EXTRA_WEIGHT, weight1);
        intent.putExtra(EXTRA_HEIGHT,height1);
        startActivity(intent);
    }

}
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityExercisePlanBinding;

public class ExercisePlan extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView textView2;
    private Button time;
    private EditText duration;
    ActivityExercisePlanBinding exercisePlanBinding;
    double height;
    double weight;
    double timeEx;
    double MET;
    double calories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        exercisePlanBinding = ActivityExercisePlanBinding.inflate(getLayoutInflater());
        setContentView(exercisePlanBinding.getRoot());
        exercisePlanBinding.time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(exercisePlanBinding.duration.getText())) {
                    Toast.makeText(ExercisePlan.this,"Please enter the time!",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = getIntent();
                weight = Double.parseDouble(intent.getStringExtra(BMI.EXTRA_WEIGHT));
                timeEx = Double.parseDouble(String.valueOf(exercisePlanBinding.duration.getText()));
                if (exercisePlanBinding.walkRad.isChecked())
                    MET = 3.5;
                else if (exercisePlanBinding.runRad.isChecked())
                    MET = 6.0;
                else if (exercisePlanBinding.swimRad.isChecked())
                    MET = 7.0;
                else if (exercisePlanBinding.cycRad.isChecked())
                    MET = 10.0;
                calories = timeEx * MET * weight * 3.5 / 200;
                exercisePlanBinding.CaloriesBurnt.setText("You have burnt " + calories + " calories.");

            }
        });
    exercisePlanBinding.exit.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openDialog();
        }
    });
    }
    public void openDialog(){
        DisclaimerDialog da=new DisclaimerDialog();
        da.show(getSupportFragmentManager(),"DISCLAIMER");

    }

}

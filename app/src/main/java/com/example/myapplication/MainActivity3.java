package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView textView2;
    private Button button_apply;
    private Button nextb;
    ActivityMain3Binding binding;
    String Gen;
    String c;
    int heartRate;

    public MainActivity3() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Gen = "Male";
                if (binding.radMale.isChecked())
                    Gen = "Male";
                else if (binding.radFemale.isChecked())
                    Gen = "Female";

                Log.d("Activity3", "onClick: " + Gen);
                Intent intent = getIntent();
                int PersonAge = Integer.parseInt(intent.getStringExtra(MainActivity2.EXTRA_AGE));
                if (Gen.equalsIgnoreCase("Male"))
                    heartRate = (220-PersonAge)*3/4;
                else
                    heartRate = (206 -PersonAge)*88/100;

                binding.textView2.setText(" With respect to your age and gender, the maximum heart rate that you should have will be: "+ heartRate);
            }
        });

    }
    public void openActivity3(View view) {

        Intent intent = new Intent(this, BMI.class);
        startActivity(intent);
    }
}



package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    EditText age;
    public static final String EXTRA_AGE = " com.example.myapplication.extra.AGE";
    ActivityMain2Binding activityMain2Binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMain2Binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(activityMain2Binding.getRoot());
    }
    public void openActivity2(View view){
        if (TextUtils.isEmpty(activityMain2Binding.age.getText())) {
            Toast.makeText(MainActivity2.this,"Please enter your age!",Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent(this,MainActivity3.class);
        String ageText = activityMain2Binding.age.getText().toString();
        intent.putExtra(EXTRA_AGE, ageText);
        startActivity(intent);
    }


}
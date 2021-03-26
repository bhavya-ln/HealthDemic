package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText PersonName;
    public static final String EXTRA_NAME = " com.example.myapplication.extra.NAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void openActivity(View view){

        Intent intent = new Intent(this,MainActivity2.class);
        Intent intent2 = new Intent(this,MainActivity3.class);
        PersonName = findViewById(R.id.PersonName);
        String name= PersonName.getText().toString();
        intent2.putExtra(EXTRA_NAME, name);
        startActivity(intent);
    }


}
package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);



    }
    public void patient(View v){
        Intent intent = new Intent(FirstScreen.this,Scheduler.class);
        startActivity(intent);
    }
    public void caretaker(View v){
        Intent intent = new Intent(FirstScreen.this,Caretaker.class);
        startActivity(intent);
    }
    public void doctor(View v){
        Intent intent = new Intent(FirstScreen.this,Doctor.class);
        startActivity(intent);
    }
}
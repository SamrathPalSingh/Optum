package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class DocDept extends AppCompatActivity {
    private ImageView ortho, cardio, paed, neuro, onco, gynae;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_dept);
        ortho = findViewById(R.id.ortho);
        cardio = findViewById(R.id.cardio);
        paed = findViewById(R.id.paed);
        neuro = findViewById(R.id.neuro);
        onco = findViewById(R.id.onco);
        gynae = findViewById(R.id.gynae);
    }

    public void check(View view) {
        Intent intent = new Intent(DocDept.this,DoctorsList.class);
        startActivity(intent);
    }
}
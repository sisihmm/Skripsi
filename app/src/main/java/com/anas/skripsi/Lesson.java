package com.anas.skripsi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Lesson extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
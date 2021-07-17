package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.anas.skripsi.R;

import java.util.ArrayList;

public class lessonAlfabet extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String>arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_alfabet);

        recyclerView = findViewById(R.id.recalfa);



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.anas.skripsi.R;

import java.util.Objects;

public class LessonStudent extends AppCompatActivity {

    CardView alfabet,fruit,pob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_student);

        alfabet = findViewById(R.id.alfabet);
        fruit = findViewById(R.id.fruit1);
        pob = findViewById(R.id.pob);

        alfabet.setOnClickListener(view -> {
            Intent intent = new Intent(LessonStudent.this, LessonAlfabet.class);
            startActivity(intent);
        });

        pob.setOnClickListener(view -> {
            Intent intent = new Intent(LessonStudent.this, Pob.class);
            startActivity(intent);
        });

        fruit.setOnClickListener(view -> {
            Intent intent = new Intent(LessonStudent.this, Fruit.class);
            startActivity(intent);
        });


        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }
}
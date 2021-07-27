package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;

import com.anas.skripsi.R;

import java.util.Objects;

public class LessonStudent extends AppCompatActivity {

    CardView alfabet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_student);

        alfabet = findViewById(R.id.alfabet);

        alfabet.setOnClickListener(view -> {
            Intent intent = new Intent(LessonStudent.this, LessonAlfabet.class);
            startActivity(intent);
        });


        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }
}
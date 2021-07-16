package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.anas.skripsi.Login;
import com.anas.skripsi.R;
import com.anas.skripsi.forget;
import com.anas.skripsi.studentList;

public class lessonStudent extends AppCompatActivity {

    CardView alfabet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_student);

        alfabet = findViewById(R.id.alfabet);

        alfabet.setOnClickListener(view -> {
            Intent intent = new Intent(lessonStudent.this, lessonAlfabet.class);
            startActivity(intent);
        });


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
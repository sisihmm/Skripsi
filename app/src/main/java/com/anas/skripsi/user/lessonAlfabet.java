package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.os.Bundle;

import com.anas.skripsi.AdapterStudent;
import com.anas.skripsi.R;
import com.anas.skripsi.studentModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Objects;


public class LessonAlfabet extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Alfa> alfaArrayList;
    AlfaAdapter alfaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_alfabet);

        recyclerView = findViewById(R.id.recalfa);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        alfaArrayList = new ArrayList<>();
        Alfa myalfa = new Alfa("tes","tes1","tes2");
        alfaArrayList.add(myalfa);
        alfaAdapter = new AlfaAdapter(alfaArrayList);
        recyclerView.setAdapter(alfaAdapter);


        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

}
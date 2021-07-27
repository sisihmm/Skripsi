package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.anas.skripsi.AdapterStudent;
import com.anas.skripsi.R;
import com.anas.skripsi.studentModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class LessonAlfabet extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Alfa> alfaArrayList;
    AlfaAdapter alfaAdapter;
    MediaPlayer alfamusic;
    Button play,stop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_alfabet);

        recyclerView = findViewById(R.id.recalfa);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        alfaArrayList = new ArrayList<>();
//        Alfa myalfa = new Alfa("tes","tes1","tes2");
//        alfaArrayList.add(myalfa);
//        alfaAdapter = new AlfaAdapter(alfaArrayList);
//        recyclerView.setAdapter(alfaAdapter);

        ArrayList<String> alfaArrayList = new ArrayList<String>(
                Arrays.asList("tes1","tes2","tes3"));

        alfamusic = MediaPlayer.create(this, R.raw.alfa);
        play = findViewById(R.id.btnPlay);
        stop = findViewById(R.id.btnStop);

        play.setOnClickListener(view -> {
            alfamusic.start();
        });

        stop.setOnClickListener(view -> {
            alfamusic.stop();
            alfamusic = MediaPlayer.create(this, R.raw.alfa);
        });

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

}
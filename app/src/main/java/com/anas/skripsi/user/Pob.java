package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.anas.skripsi.R;

import java.util.Objects;

public class Pob extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pob);



        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }
}
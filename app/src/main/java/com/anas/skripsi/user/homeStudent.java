package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.anas.skripsi.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class HomeStudent extends AppCompatActivity {

    FirebaseAuth mAuth;
    TextView myName;
    CardView golesson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_student);

        myName = findViewById(R.id.myname);
        mAuth = FirebaseAuth.getInstance();

        golesson = findViewById(R.id.golesson);
        FirebaseUser userDb = mAuth.getCurrentUser();
        FirebaseFirestore dbActivity = FirebaseFirestore.getInstance();

        dbActivity.collection("users").document(userDb.getUid()).get().addOnCompleteListener(task -> {
//            Log.d("USERS", "onComplete: " + task.getResult().getString("email"));
            myName.setText(task.getResult().getString("name"));

        });

        golesson.setOnClickListener(view -> {
            Intent intent = new Intent(HomeStudent.this, LessonStudent.class);
            startActivity(intent);
        });

    }
}
package com.anas.skripsi.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.anas.skripsi.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class homeStudent extends AppCompatActivity {

    FirebaseAuth mAuth;
    TextView myName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_student);

        myName = findViewById(R.id.myname);
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser userDb = mAuth.getCurrentUser();
        FirebaseFirestore dbActivity = FirebaseFirestore.getInstance();

        dbActivity.collection("users").document(userDb.getUid()).get().addOnCompleteListener(task -> {
            Log.d("USERS", "onComplete: " + task.getResult().getString("email"));
            myName.setText(task.getResult().getString("email"));

        });

    }
}
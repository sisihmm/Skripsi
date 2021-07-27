package com.anas.skripsi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class addStudent extends AppCompatActivity {

    EditText nameStud,emailStud;
    Button btStud;
    FirebaseFirestore db;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        nameStud = findViewById(R.id.namestud);
        emailStud = findViewById(R.id.emailstud);
        btStud = findViewById(R.id.buttonstud);

        db = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();

        btStud.setOnClickListener(view -> {
            String name = nameStud.getText().toString().trim();
            String email = emailStud.getText().toString().trim();
            String password = "12345678";


            if (TextUtils.isEmpty(name)){
                nameStud.setError("nama kosong");
                return;
            }
            if (TextUtils.isEmpty(email)){
                emailStud.setError(" email kosong");
                return;
            }

            fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    Map<String, Object> user = new HashMap<>();
                    user.put("name", name);
                    user.put("email", email);
                    user.put("level", "2");

                    db.collection("users").document(task.getResult().getUser().getUid()).set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(addStudent.this,"Student Created",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),studentList.class));

                        }
                    });
            }else {
                    Toast.makeText(addStudent.this,"Student Failed created", Toast.LENGTH_SHORT).show();

                }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

});
    }
}
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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class change_email extends AppCompatActivity {

    EditText newEmail, cnEmail, newName;
    Button btNemail;
    FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_email);

        newName = findViewById(R.id.ncName);
        newEmail = findViewById(R.id.nEmail);
        cnEmail = findViewById(R.id.Cnemail);
        btNemail = findViewById(R.id.buttonsEmai);
        auth = FirebaseAuth.getInstance();

        btNemail.setOnClickListener(v -> {
            String namenew = newName.getText().toString().trim();
            String emailnew = newEmail.getText().toString().trim();
            String cemailnew = cnEmail.getText().toString().trim();

            if (TextUtils.isEmpty(namenew)) {
                newName.setError("email kosong");
                return;
            }
            if (TextUtils.isEmpty(emailnew)) {
                newEmail.setError("email kosong");
                return;
            }
            if (!emailnew.equals(cemailnew)) {
                cnEmail.setError("email tidak sama");
                return;
            }

            FirebaseUser user = auth.getCurrentUser();
            user.updateEmail(newEmail.getText().toString()).addOnSuccessListener(unused -> {
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                Map<String, Object> userNew = new HashMap<>();
                userNew.put("email", newEmail.getText().toString());
                userNew.put("level", "1");
                userNew.put("name", newName.getText().toString());
                db.collection("users").document(user.getUid()).set(userNew).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(change_email.this, "email telah diubah", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Login.class));
                        finish();
                    }
                }).addOnFailureListener(e -> Toast.makeText(change_email.this, "gagal update email", Toast.LENGTH_SHORT).show());

            });

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        });
    }
}


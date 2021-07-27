package com.anas.skripsi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.anas.skripsi.user.HomeStudent;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class Login extends AppCompatActivity {
    EditText etEmail;
    EditText etPassword;
    TextView tvForget;
    Button bLogin;
    TextView tvRegis;

    FirebaseAuth fAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.lemail);
        etPassword = findViewById(R.id.lpassw);
        bLogin = findViewById(R.id.blogin);
        tvRegis = findViewById(R.id.signup);
        tvForget = findViewById(R.id.tvForget);

        fAuth = FirebaseAuth.getInstance();


        bLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                etEmail.setError("Email Kosang");
                return;
            }
            if (TextUtils.isEmpty(password)) {
                etPassword.setError("password Kosang");
                return;
            }

            fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        FirebaseFirestore db = FirebaseFirestore.getInstance();
                        db.collection("users").document(task.getResult().getUser().getUid()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                String level = task.getResult().getString("level");
                                Boolean isAdmin = level.equals("1");
                                if (isAdmin) {
                                    Log.d("LOGIN", "onComplete: " + task.getResult().getString("level"));
                                    Toast.makeText(Login.this, "user Login", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), Home.class);
                                    intent.putExtra("level", level);
                                    startActivity(intent);
                                }
                                else {
                                    Log.d("LOGIN", "onComplete: " + task.getResult().getString("level"));
                                    Toast.makeText(Login.this, "user Login", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), HomeStudent.class);
                                    intent.putExtra("level", level);
                                    startActivity(intent);
                                }

                            }
                        });


                    } else {
                        Toast.makeText(Login.this, "gagal login !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }

            });
        });

        tvRegis.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, Register.class);
            startActivity(intent);
        });

        tvForget.setOnClickListener(v -> {
            Intent intent = new Intent(Login.this, forget.class);
            startActivity(intent);
        });

    }
}


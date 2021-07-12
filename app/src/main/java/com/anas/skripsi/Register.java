package com.anas.skripsi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    EditText etName, etEmail, etPassword, etCpassword;
    Button bRegis;
    TextView tvLogin;
    FirebaseFirestore db;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etname);
        etEmail = findViewById(R.id.etemail);
        etPassword = findViewById(R.id.etpassword);
        etCpassword = findViewById(R.id.etcpassword);
        bRegis = findViewById(R.id.btsignup);
        tvLogin = findViewById(R.id.tvblogin);

        db = FirebaseFirestore.getInstance();
        fAuth = FirebaseAuth.getInstance();


        if (fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(),Login.class));
            finish();
        }

        bRegis.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();
            String cpassword = etCpassword.getText().toString().trim();

            if (TextUtils.isEmpty(name)){
                etName.setError("nama kosong");
                return;
            }
            if (TextUtils.isEmpty(email)){
                etEmail.setError(" email kosong");
                return;
            }
            if (TextUtils.isEmpty(password)){
                etPassword.setError(" password kosong");
                return;
            }
            if (!password.equals(cpassword)){
                etCpassword.setError("password tidak sama");
                return;
            }
            fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    Map<String, Object> user = new HashMap<>();
                    user.put("name", name);
                    user.put("email", email);
                    user.put("level", "1");

                    db.collection("users").document(task.getResult().getUser().getUid()).set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Toast.makeText(Register.this,"User Createed",Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Login.class));
                        }
                    });
                }else{
                    Toast.makeText(Register.this,"User Failed Regist", Toast.LENGTH_SHORT).show();
                }
            });
        });
            tvLogin.setOnClickListener(v -> {
                Intent intent = new Intent(Register.this, Login.class);
                    startActivity(intent);
            });

    }
}
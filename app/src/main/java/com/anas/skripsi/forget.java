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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forget extends AppCompatActivity {
    TextView tvFemail;
    EditText etFmail;
    Button bSend;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        tvFemail = findViewById(R.id.tvblogin);
        etFmail = findViewById(R.id.femail);
        bSend = findViewById(R.id.bsend);

        fAuth = FirebaseAuth.getInstance();

        tvFemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(forget.this, Login.class);
                startActivity(intent);
            }
        });

        bSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(etFmail.getText().toString().trim())){
                    etFmail.setError("kosong");

                fAuth.sendPasswordResetEmail(etFmail.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(forget.this,"send to your email", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Login.class));
                    }
                });
                }else {
                    Toast.makeText(forget.this,"failed send your email", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}
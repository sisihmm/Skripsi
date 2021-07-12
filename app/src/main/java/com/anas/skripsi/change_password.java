package com.anas.skripsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class change_password extends AppCompatActivity {

    TextView mPass,mCpass ;
    Button msave;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        mPass = findViewById(R.id.npassw);
        mCpass = findViewById(R.id.cpass);
        msave = findViewById(R.id.breset);
        user = FirebaseAuth.getInstance().getCurrentUser();

        msave.setOnClickListener(v -> {
            String npassw = mPass.getText().toString().trim();
            String cpass = mCpass.getText().toString().trim();

            if (TextUtils.isEmpty(npassw)){
                mPass.setError("password Kosang");
                return;
            }
            if (!npassw.equals(cpass)){
                mCpass.setError("Password Tidak Sama");
                return;
            }

            user.updatePassword(mPass.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(change_password.this, "Password telah diubah", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),Login.class));
                    finish();
                }
            }).addOnFailureListener(e -> Toast.makeText(change_password.this, "Password gagal diubah",Toast.LENGTH_SHORT).show());
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
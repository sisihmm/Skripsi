package com.anas.skripsi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    TextView tvForget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tvForget = findViewById(R.id.tvForget);

        tvForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }
    //forget password
    public void openDialog(){
        forget_dialog forget_Dialog = new forget_dialog();
        forget_Dialog.show(getSupportFragmentManager(),"Forget Password");
    }

}
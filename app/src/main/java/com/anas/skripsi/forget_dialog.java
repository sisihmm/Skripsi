package com.anas.skripsi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class forget_dialog extends AppCompatDialogFragment {

    private EditText fEmail;
    FirebaseAuth fAuth;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_forgetd, null);

        fAuth =FirebaseAuth.getInstance();

        builder.setView(view)
                .setTitle("send")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Send", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i  ) {
                        if (fEmail.getText().toString().isEmpty()) {
                            fEmail.setError("email kosong");
                            return;
                        }
                        fAuth.sendPasswordResetEmail(fEmail.getText().toString());

                    }
                });

        fEmail = view.findViewById(R.id.etfemail);
        return builder.create();
    }


}

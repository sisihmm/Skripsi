package com.anas.skripsi;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.google.firebase.FirebaseApp;

public class forget_dialog extends AppCompatDialogFragment {

    private EditText fEmail;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.forget_dialog, null);

        builder.setView(view)
                .setTitle("send")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i  ) {
                        if (fEmail.getText().toString().isEmpty()) {
                            fEmail.setError("email kosong");
                            return;
                        }

                    }
                });

        fEmail = view.findViewById(R.id.etfemail);
        return builder.create();
    }


}

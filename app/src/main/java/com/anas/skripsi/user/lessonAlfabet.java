package com.anas.skripsi.user;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.anas.skripsi.AdapterStudent;
import com.anas.skripsi.R;
import com.anas.skripsi.studentList;
import com.anas.skripsi.studentModel;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class lessonAlfabet extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<alfabetModel> alfabetArrayList;
    AdapterAlfabet adapterAlfabet;
    FirebaseFirestore db;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_alfabet);

        recyclerView = findViewById(R.id.recalfa);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("tunggu");
        progressDialog.show();

        recyclerView = findViewById(R.id.recalfa);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        alfabetArrayList = new ArrayList<alfabetModel>();
        adapterAlfabet = new AdapterAlfabet(lessonAlfabet.this,alfabetArrayList);

        recyclerView.setAdapter(adapterAlfabet);


        EventChangeListenertw();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    private void EventChangeListenertw(){
        db.collection("lesson").orderBy("alfa", Query.Direction.ASCENDING)
                .addSnapshotListener((value, error) -> {

                    if (error != null) {

                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                        Log.e("error", error.getMessage());
                        return;

                    }
                    for (DocumentChange dc : value.getDocumentChanges()) {
                        if (dc.getType() == DocumentChange.Type.ADDED) {
                            alfabetArrayList.add(dc.getDocument().toObject(alfabetModel.class));
                        }


                        adapterAlfabet.notifyDataSetChanged();
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                    }

                });
    }


}
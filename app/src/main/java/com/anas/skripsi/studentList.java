package com.anas.skripsi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import org.w3c.dom.Document;

import java.util.ArrayList;

public class studentList extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<studentModel> studentArrayList;
    AdapterStudent adapterStudent;
    FirebaseFirestore db;
    FirebaseAuth fAuth;
    ProgressDialog progressDialog;
    FloatingActionButton tambahMurid,editMurid;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("tunggu");
        progressDialog.show();

        recyclerView = findViewById(R.id.recyclerStudent);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        db = FirebaseFirestore.getInstance();
        studentArrayList = new ArrayList<studentModel>();
        adapterStudent = new AdapterStudent(studentList.this,studentArrayList);

        recyclerView.setAdapter(adapterStudent);

        tambahMurid = findViewById(R.id.tambah_murid);

        EventChangeListener();
                
        tambahMurid.setOnClickListener(view -> {
                Intent intent = new Intent(studentList.this, addStudent.class);
                startActivity(intent);
            });


}
    private void EventChangeListener() {
        db.collection("users").whereGreaterThan("level","1").orderBy("level", Query.Direction.ASCENDING)
                .addSnapshotListener((value, error) -> {

                    if (error != null) {

                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                        Log.e("error", error.getMessage());
                        return;

                    }

                        for (DocumentChange dc : value.getDocumentChanges()) {
                           if (dc.getType() == DocumentChange.Type.ADDED) {
                               studentArrayList.add(dc.getDocument().toObject(studentModel.class));
                                }


                            adapterStudent.notifyDataSetChanged();
                            if (progressDialog.isShowing())
                                progressDialog.dismiss();
                        }

                        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
                            @Override
                            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                                return false;
                            }

                            @Override
                            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                                Toast.makeText(studentList.this, "Item removed", Toast.LENGTH_SHORT).show();

                            }
                        }).attachToRecyclerView(recyclerView);
                });


    }
}
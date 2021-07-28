package com.anas.skripsi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class AdapterStudent extends RecyclerView.Adapter<AdapterStudent.StudentViewHolder> {

    Context context;
    ArrayList<studentModel> studentArrayList;

    public AdapterStudent(Context context, ArrayList<studentModel> studentArrayList) {
        this.context = context;
        this.studentArrayList = studentArrayList;
    }

    @NonNull
    @Override
    public AdapterStudent.StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(context).inflate(R.layout.list_student,parent,false);
        return new StudentViewHolder(v);

        }


    @Override
    public void onBindViewHolder(@NonNull AdapterStudent.StudentViewHolder holder, int position) {

        studentModel studentmodel = studentArrayList.get(position);

        holder.stName.setText(studentmodel.name);
        holder.stEmail.setText(studentmodel.email);
    }

    @Override
    public int getItemCount() {
      return studentArrayList.size();
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder{

        TextView stName,stEmail;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            stName = itemView.findViewById(R.id.stname);
            stEmail = itemView.findViewById(R.id.stemail);
        }
    }

}

package com.anas.skripsi.user;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anas.skripsi.R;

import java.util.ArrayList;

public class AdapterAlfabet extends RecyclerView.Adapter<AdapterAlfabet.AlfabetViewHolder>{

    Context context;
    ArrayList<alfabetModel>alfaArrayList;

//   animasi
        Activity activity;
        int lastPosition = -1;


    public AdapterAlfabet(Context context,ArrayList<alfabetModel>alfaArrayList) {
        this.context = context;
        this.activity = activity;
        this.alfaArrayList = alfaArrayList;
    }


    @NonNull
    @Override
    public AdapterAlfabet.AlfabetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.alfabetcv, parent,false);
        return new AlfabetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAlfabet.AlfabetViewHolder holder, int position) {
            alfabetModel alfabetModel = alfaArrayList.get(position);

            holder.cvAlfa.setText(alfabetModel.alfa);

            setAnimation(holder.itemView,position);
            holder.itemView.setOnClickListener(view ->
                    Toast.makeText(activity, (CharSequence) alfaArrayList.get(position),
                            Toast.LENGTH_SHORT).show());
    }

    private void setAnimation(View itemView, int position) {
        if (position > lastPosition){
            Animation animation = AnimationUtils.loadAnimation(activity, android.R.anim.slide_in_left);

            itemView.setAnimation(animation);
            lastPosition = position;

        }
    }

    @Override
    public int getItemCount() { return alfaArrayList.size(); }


    public static class AlfabetViewHolder extends RecyclerView.ViewHolder {

        TextView cvAlfa;

        public AlfabetViewHolder(@NonNull View itemView) {
            super(itemView);

            cvAlfa = itemView.findViewById(R.id.recalfa);
        }
    }
}



package com.anas.skripsi.user;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anas.skripsi.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.animalViewHolder> {

    Context context;
    ArrayList<AnimalModel>animalModel;

    public AnimalAdapter(Context context,ArrayList<AnimalModel>animalModel){
        this.context = context;
        this.animalModel = animalModel;
    }

    @NonNull
    @Override
    public AnimalAdapter.animalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.animalcv, parent,false);

       return new animalViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalAdapter.animalViewHolder holder, int position) {

        AnimalModel f = animalModel.get(position);

        holder.tv_animal.setText(f.img_name);
//        Picasso.get().load(f.img_animal).resize(120,60).into(holder.imgee_animal);
        Picasso.get().load(f.img_animal).into(holder.imgee_animal);

    }

    @Override
    public int getItemCount() { return animalModel.size(); }

    public class animalViewHolder extends RecyclerView.ViewHolder {

        ImageView imgee_animal;
        TextView tv_animal;

        public animalViewHolder(@NonNull View itemView) {
            super(itemView);
                imgee_animal = itemView.findViewById(R.id.img_animal);
                tv_animal = itemView.findViewById(R.id.tv_animal);
        }
    }
}

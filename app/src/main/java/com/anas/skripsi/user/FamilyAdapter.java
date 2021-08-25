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

public class FamilyAdapter extends RecyclerView.Adapter<FamilyAdapter.FamilyViewHolder> {

    Context context;
    ArrayList<FamilyModel>familyModel;

    public FamilyAdapter(Context context,ArrayList<FamilyModel>familyModel){
        this.context = context;
        this.familyModel = familyModel;
    }


    @NonNull
    @Override
    public FamilyAdapter.FamilyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.familycv, parent, false);
        return new FamilyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FamilyAdapter.FamilyViewHolder holder, int position) {

        FamilyModel f = familyModel.get(position);

        holder.tv_familiku.setText(f.name_family);
        Picasso.get().load(f.img_family).resize(120,60).into(holder.img_familiku);

    }

    @Override
    public int getItemCount() {
        return familyModel.size(); }

    public class FamilyViewHolder extends RecyclerView.ViewHolder {
        ImageView img_familiku;
        TextView tv_familiku;

        public FamilyViewHolder(@NonNull View itemView) {
            super(itemView);
            img_familiku = itemView.findViewById(R.id.img_family);
            tv_familiku = itemView.findViewById(R.id.tv_family);

        }
    }
}

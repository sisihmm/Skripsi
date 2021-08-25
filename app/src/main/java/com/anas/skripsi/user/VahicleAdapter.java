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

public class VahicleAdapter extends RecyclerView.Adapter<VahicleAdapter.VahicleViewHolder> {

    Context context;
    ArrayList<VahicleModel>vahicleModels;


    public VahicleAdapter (Context context , ArrayList<VahicleModel>vahicleModels){
        this.context = context;
        this.vahicleModels = vahicleModels;

    }

    @NonNull
    @Override
    public VahicleAdapter.VahicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.vahiclecv,parent,false);

        return new VahicleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VahicleAdapter.VahicleViewHolder holder, int position) {

        VahicleModel f = vahicleModels.get(position);

        holder.tv_vacu.setText(f.vahicle_name);
        Picasso.get().load(f.vahicle_img).resize(120,60).into(holder.img_vacku);

    }

    @Override
    public int getItemCount() {
        return vahicleModels.size();
    }

    public static class VahicleViewHolder extends RecyclerView.ViewHolder {
        ImageView img_vacku;
        TextView tv_vacu;

        public VahicleViewHolder(@NonNull View itemView) {
            super(itemView);
            img_vacku =itemView.findViewById(R.id.img_vahicle);
            tv_vacu =itemView.findViewById(R.id.tv_vahicle);
        }
    }
}

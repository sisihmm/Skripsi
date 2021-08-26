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

public class kitchenAdaptor extends RecyclerView.Adapter<kitchenAdaptor.kitchenViewHolder> {

    Context context;
    ArrayList<kitchenModel>kitchenModel;

    public kitchenAdaptor(Context context, ArrayList<kitchenModel>kitchenModel){
        this.context = context;
        this.kitchenModel = kitchenModel;
    }

    @NonNull
    @Override
    public kitchenAdaptor.kitchenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.kitchencv,parent,false);

        return new kitchenViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull kitchenAdaptor.kitchenViewHolder holder, int position) {
        kitchenModel f =kitchenModel.get(position);

        holder.tvkit.setText(f.kitchen_name);
        Picasso.get().load(f.kitchen_img).resize(120,60).into(holder.imagekit);


    }

    @Override
    public int getItemCount() {
        return kitchenModel.size();
    }

    public static class kitchenViewHolder extends RecyclerView.ViewHolder {

        ImageView imagekit;
        TextView tvkit;

        public kitchenViewHolder(@NonNull View itemView) {
            super(itemView);

            imagekit = (itemView).findViewById(R.id.img_kitchen);
            tvkit = (itemView).findViewById(R.id.tv_kitchen);
        }
    }
}

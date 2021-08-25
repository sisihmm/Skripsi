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
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FruitAdaptor extends RecyclerView.Adapter<FruitAdaptor.FruitViewHolder> {
    Context context;
    ArrayList<FruitModel> fruitModel;

    public FruitAdaptor(Context context, ArrayList<FruitModel>fruitModel){
        this.context = context;
        this.fruitModel = fruitModel;
    }


    @NonNull
    @Override
    public FruitAdaptor.FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fruitcv,parent,false);

        return new FruitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {

        FruitModel f = fruitModel.get(position);

        holder.tv_fruit.setText(f.fruit_name);
        Picasso.get().load(f.fruit_image_urls).resize(120,60).into(holder.img_fruit);

  }


    @Override
    public int getItemCount() {
        return fruitModel.size();
    }

    public static class FruitViewHolder extends RecyclerView.ViewHolder {

        TextView tv_fruit;
        ImageView img_fruit;

        public FruitViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_fruit = itemView.findViewById(R.id.tv_fruit);
            img_fruit = itemView.findViewById(R.id.img_fruit);
        }
    }
}

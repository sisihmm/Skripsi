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

public class FruitAdaptor extends RecyclerView.Adapter<FruitAdaptor.FruitViewHolder> {
    Context context;
    ArrayList<String> fruitArrayList;

    public FruitAdaptor(Context context, ArrayList<String>fruitArrayList){
        this.context = context;
        this.fruitArrayList = fruitArrayList;
    }


    @NonNull
    @Override
    public FruitAdaptor.FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fruitcv,parent,false);

        return new FruitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {

        String f = fruitArrayList.get(position);

        holder.tv_fruit.setText(f);
        Picasso.get().load(f).resize(120,60).into(holder.img_fruit);
    }


    @Override
    public int getItemCount() {
        return fruitArrayList.size();
    }

    public static class FruitViewHolder extends RecyclerView.ViewHolder {

        TextView tv_fruit;
        ImageView img_fruit;

        public FruitViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_fruit = (TextView)itemView.findViewById(R.id.tv_fruit);
            img_fruit = (ImageView)itemView.findViewById(R.id.img_fruit);
        }
    }
}

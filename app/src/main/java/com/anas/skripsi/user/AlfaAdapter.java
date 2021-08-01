package com.anas.skripsi.user;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anas.skripsi.R;

import java.util.ArrayList;


public class AlfaAdapter extends RecyclerView.Adapter<AlfaAdapter.alfaViewHolder>{

    Context context;
    ArrayList<String> alfaArrayList;

    public AlfaAdapter(Context context, ArrayList<String> alfaArrayList){
        this.context = context;
        this.alfaArrayList = alfaArrayList;
    }

    @NonNull
    @Override
    public AlfaAdapter.alfaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.alfabetcv, parent,false);
        return new alfaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull alfaViewHolder holder, int position) {
        String am = alfaArrayList.get(position);
        holder.alfaN.setText(am);
    }

    @Override
    public int getItemCount() {
        return alfaArrayList.size();
    }

    public static class alfaViewHolder extends RecyclerView.ViewHolder {

        TextView alfaN;

        public alfaViewHolder(@NonNull View itemView) {
            super(itemView);
            alfaN = itemView.findViewById(R.id.alfa1);
        }
    }
}

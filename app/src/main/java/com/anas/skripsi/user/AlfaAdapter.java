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
    ArrayList<Alfa> alfaArrayList;

//    public AlfaAdapter(ArrayList<Alfa> alfaArrayList, Context context){
//        this.context = context;
//        this.alfaArrayList = alfaArrayList;
//    }

    public AlfaAdapter(Context context,ArrayList<Alfa> alfaArrayList) {
        this.context = context;
        this.alfaArrayList = alfaArrayList;
    }

    @NonNull
    @Override
    public AlfaAdapter.alfaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.alfabetcv,parent, false);
        return new alfaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlfaAdapter.alfaViewHolder holder, int position) {
        Alfa alfa = alfaArrayList.get(position);

        holder.alfaB.setText(alfa.getAlfa());

    }

    @Override
    public int getItemCount() {
        return alfaArrayList.size();
    }

    public static class alfaViewHolder extends RecyclerView.ViewHolder {

        TextView alfaB;

        public alfaViewHolder(@NonNull View itemView) {
            super(itemView);
            alfaB = itemView.findViewById(R.id.alfa1);
        }
    }
}

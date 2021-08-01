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

public class PobAdapter extends RecyclerView.Adapter<PobAdapter.pobViewHolder> {

    Context context;
    ArrayList<String> pobArrayList;

    public PobAdapter(Context context, ArrayList<String> pobArrayList){
        this.context = context;
        this.pobArrayList = pobArrayList;
    }

    @NonNull
    @Override
    public PobAdapter.pobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.pobcv, parent,false);
        return new pobViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PobAdapter.pobViewHolder holder, int position) {

        String f = pobArrayList.get(position);

        holder.top.setText(f);

    }

    @Override
    public int getItemCount() {
        return pobArrayList.size();
    }

    public static class pobViewHolder extends RecyclerView.ViewHolder {
        TextView top;

        public pobViewHolder(@NonNull View itemView) {
            super(itemView);
            top = itemView.findViewById(R.id.pob1);

        }
    }
}

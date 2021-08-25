package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.anas.skripsi.AdapterStudent;
import com.anas.skripsi.R;

import java.util.ArrayList;
import java.util.Objects;

public class vahicle extends AppCompatActivity {



    private final String[] vahicle_name = {
            "camel = unta",
            ""
    };

    private final String[] vahicle_image_urls = {
            "https://img2.pngdownload.id/20180511/ajq/kisspng-camel-animation-clip-art-5af62d1316dbc1.8310576215260828350936.jpg",
            ""
    };

    RecyclerView recyclerView;
    VahicleAdapter vahicleAdapter;

    TextView tvvch ;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vahicle);

        tvvch = findViewById(R.id.txvvhc);
        tvvch.setText("Hello everyone, how are you today?\n"+
                "Pada kesempatan kali ini kami akan menerangkan"+
                "bagaimana cara membaca alphabet dalam bahasa inggris.\n"+
                "Materi alphabet ini tentu sudah diajarkan"+
                "di bangku sekolah dasar bahkan saat kita di taman\n"+
                "kanak-kanak.\n"+
                "\n"+
                "Cara Membaca Alphabet dalam Bahasa Inggris");

        recyclerView = findViewById(R.id.revahicle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ArrayList amodel = vacku();
        VahicleAdapter adapter = new VahicleAdapter(getApplicationContext(),amodel);
        recyclerView.setAdapter(adapter);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    private ArrayList vacku() {
        ArrayList myvahicle = new ArrayList<>();
        for (int i=0; i<vahicle_name.length;i++){
            VahicleModel vahicleModel = new VahicleModel();
            vahicleModel.setVahicle_name(vahicle_name[i]);
            vahicleModel.setVahicle_img(vahicle_image_urls[i]);
            myvahicle.add(vahicleModel);
        }
        return myvahicle;
    }
}
package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.anas.skripsi.R;

import java.util.ArrayList;

public class family extends AppCompatActivity {

    TextView txvfamily;

    private final String[] family_name = {
            "Donut",
            
    };

    private final String[] family_image_urls = {
            "https://banner2.cleanpng.com/20190115/rxy/kisspng-clip-art-drawing-portable-network-graphics-image-c-other-club-penguin-cutouts-5c3d8227646a92.3012681215475348874113.jpg",

    };

    RecyclerView recyclerView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        txvfamily = findViewById(R.id.txvfmily);
        txvfamily.setText("Hello everyone, how are you today?\n"+
                "Pada kesempatan kali ini kami akan menerangkan"+
                "bagaimana cara membaca alphabet dalam bahasa inggris.\n"+
                "Materi alphabet ini tentu sudah diajarkan"+
                "di bangku sekolah dasar bahkan saat kita di taman\n"+
                "kanak-kanak.\n"+
                "\n"+
                "Cara Membaca Alphabet dalam Bahasa Inggris");

        recyclerView = findViewById(R.id.refamily);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ArrayList fmodel = familiku();
        FamilyAdapter adaptor = new FamilyAdapter(getApplicationContext(),fmodel);
        recyclerView.setAdapter(adaptor);

    }

    private ArrayList familiku() {
        ArrayList myfamily = new ArrayList<>();
        for (int i = 0; i < family_name.length; i++) {
            FamilyModel familyModel = new FamilyModel();
            familyModel.setName_family(family_name[i]);
            familyModel.setImg_family(family_image_urls[i]);
            myfamily.add(familyModel);
        }
        return myfamily;
    }

}
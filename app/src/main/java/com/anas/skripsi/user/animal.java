package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.anas.skripsi.R;

import java.util.ArrayList;
import java.util.Objects;

public class animal extends AppCompatActivity {

    private final String[] animal_name = {
            "Donut"
    };

    private final String[] animal_image_urls = {
            "https://banner2.cleanpng.com/20190115/rxy/kisspng-clip-art-drawing-portable-network-graphics-image-c-other-club-penguin-cutouts-5c3d8227646a92.3012681215475348874113.jpg"
    };


    RecyclerView recyclerView;
    AnimalAdapter animalAdapter;

    TextView tviewanimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

    tviewanimal = findViewById(R.id.tvieanimal);
    tviewanimal.setText("agjavshcvajcvascv.");


    recyclerView = findViewById(R.id.reanimal);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setHasFixedSize(true);

        ArrayList amodel = animalku();
        AnimalAdapter adaptor = new AnimalAdapter(getApplicationContext(),amodel);
        recyclerView.setAdapter(adaptor);

        //back
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

    private ArrayList animalku() {
        ArrayList myanimal = new ArrayList<>();
        for (int i=0; i<animal_name.length;i++){
            AnimalModel animalModel = new AnimalModel();
            animalModel.setImg_name(animal_name[i]);
            animalModel.setImg_animal(animal_image_urls[i]);
            myanimal.add(animalModel);
        }
        return myanimal;
    }


}
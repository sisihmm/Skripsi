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
            "camel = unta",
            "canary = burung kenari",
            "cat = kucing",
            "cattle = sapi perah",
            "chicken = ayam",
            "dog = anjing",
            "donkey = keledai",
            "dove = burung merpati",
            "duck = bebek"
    };

    private final String[] animal_image_urls = {
            "https://img2.pngdownload.id/20180511/ajq/kisspng-camel-animation-clip-art-5af62d1316dbc1.8310576215260828350936.jpg",
            "https://w7.pngwing.com/pngs/536/832/png-transparent-bird-columbidae-bird-cartoon-animals-songbird-fauna.png",
            "https://w7.pngwing.com/pngs/169/114/png-transparent-cat-cartoon-cat-mammal-animals-cat-like-mammal.png",
            "https://e7.pngegg.com/pngimages/146/62/png-clipart-dairy-cattle-calf-cow-horse-miscellaneous.png",
            "https://www.pngfind.com/pngs/m/289-2896244_rooster-art-gambar-ayam-jago-kartun-hd-png.png",
            "https://img2.pngdownload.id/20180419/atq/kisspng-dog-puppy-cartoon-clip-art-the-dog-png-5ad8310982f867.1422060815241177695365.jpg",
            "https://e7.pngegg.com/pngimages/305/921/png-clipart-cartoon-donkey-donkey-little-donkey.png",
            "https://png.pngtree.com/png-clipart/20210308/original/pngtree-pigeon-seagull-bird-flying-bird-homing-pigeon-birds-poultry-cartoon-vector-png-image_5755834.jpg",
            "https://i.pinimg.com/736x/76/22/f3/7622f3dee575dd89f6f6ee446794b1b4.jpg"
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
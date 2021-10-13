package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
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
            "duck = bebek",
            "goat = kambing",
            "goldfish = ikan mas koki",
            "goose = angsa",
            "guinea pig = marmut",
            "hamster = hamster",
            "horse = kuda",
            "pig = babi",
            "sheep = domba",
            "rabbit = kelinci",
            "pigeon = burung dara",
            "turtle = kura-kura",
            "turkey = ayam kalkunn"
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
            "https://i.pinimg.com/736x/76/22/f3/7622f3dee575dd89f6f6ee446794b1b4.jpg",
            "https://w7.pngwing.com/pngs/34/464/png-transparent-goat-cartoon-arabic-gum-mammal-cow-goat-family-sheep.png",
            "https://w7.pngwing.com/pngs/322/485/png-transparent-koi-pond-goldfish-carp-koi-aquarium-cartoon-pond.png",
            "https://w7.pngwing.com/pngs/230/372/png-transparent-swan-duck-domestic-goose-cartoon-big-white-goose-cartoon-character-other-animals.png",
            "https://www.pngfind.com/pngs/m/663-6639641_guinea-pig-png-marmut-kartun-transparent-png.png",
            "https://img2.pngdownload.id/20180313/chq/kisspng-hamster-kitten-whiskers-clip-art-cute-hamster-meng-meng-da-da-5aa7645d8f0f98.102998231520919645586.jpg",
            "https://e7.pngegg.com/pngimages/559/416/png-clipart-sheep-goat-cartoon-live-cute-horse-s-horse-mammal.png",
            "https://e7.pngegg.com/pngimages/124/367/png-clipart-pig-cartoon-pig-mammal-animals.png",
            "https://img2.pngdownload.id/20191227/ogs/transparent-sheep-sheep-animal-figure-cartoon-livestock-5e05f7937c60a2.4401135615774493635095.jpg",
            "https://w1.pngwing.com/pngs/310/192/png-transparent-rabbit-cartoon-rabbits-and-hares-hare-snout-animation-animal-figure.png",
            "https://cdn.pixabay.com/photo/2012/05/07/01/48/pigeon-47505_640.png",
            "https://png.pngtree.com/png-clipart/20201024/ourlarge/pngtree-hand-drawn-cartoon-tortoise-clipart-png-image_2375744.jpg",
            "https://w7.pngwing.com/pngs/634/196/png-transparent-turkey-meat-free-content-turkey-cartoon-s-computer-galliformes-chicken.png"
    };


    RecyclerView recyclerView;
    AnimalAdapter animalAdapter;

    TextView tviewanimal;

    //musik
    MediaPlayer alfamusic;
    ImageView play, stop;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);

    tviewanimal = findViewById(R.id.tvieanimal);
    tviewanimal.setText("Nama-nama Hewan dalam bahasa inggris.");


    recyclerView = findViewById(R.id.reanimal);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setHasFixedSize(true);

        ArrayList amodel = animalku();
        AnimalAdapter adaptor = new AnimalAdapter(getApplicationContext(),amodel);
        recyclerView.setAdapter(adaptor);

        //musik

        alfamusic = MediaPlayer.create(this, R.raw.alfa);
        play = findViewById(R.id.btnPlay);
        stop = findViewById(R.id.btnStop);

        play.setOnClickListener(view -> {
            alfamusic.start();
        });

        stop.setOnClickListener(view -> {
            alfamusic.stop();
            alfamusic = MediaPlayer.create(this, R.raw.alfa);
        });

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
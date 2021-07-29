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

public class Fruit extends AppCompatActivity {

//    private final String[] fruit_name = {
//            "Donut",
//            "Eclair",
//            "Froyo",
//            "Gingerbread",
//            "Honeycomb",
//            "Ice Cream Sandwich",
//            "Jelly Bean",
//            "KitKat",
//            "Lollipop",
//            "Marshmallow"
//    };
//
//    private final String[] fruit_image_urls = {
//            "https://banner2.cleanpng.com/20190115/rxy/kisspng-clip-art-drawing-portable-network-graphics-image-c-other-club-penguin-cutouts-5c3d8227646a92.3012681215475348874113.jpg",
//            "http://api.learn2crack.com/android/images/eclair.png",
//            "http://api.learn2crack.com/android/images/froyo.png",
//            "http://api.learn2crack.com/android/images/ginger.png",
//            "http://api.learn2crack.com/android/images/honey.png",
//            "http://api.learn2crack.com/android/images/icecream.png",
//            "http://api.learn2crack.com/android/images/jellybean.png",
//            "http://api.learn2crack.com/android/images/kitkat.png",
//            "http://api.learn2crack.com/android/images/lollipop.png",
//            "http://api.learn2crack.com/android/images/marshmallow.png"
//    };

    RecyclerView recyclerView;
    FruitAdaptor fruitAdaptor;
    ArrayList<String>fruitArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);


        recyclerView = findViewById(R.id.refruit);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        fruitArrayList = new ArrayList<>();

        fruitArrayList.add("https://banner2.cleanpng.com/20190115/rxy/kisspng-clip-art-drawing-portable-network-graphics-image-c-other-club-penguin-cutouts-5c3d8227646a92.3012681215475348874113.jpg");
        fruitArrayList.add("tes");



//        for(int i=0;i<fruit_name.length;i++){
//            fruitArrayList.add(fruit_name[i]);
//            fruitArrayList.add(fruit_image_urls[i]);
//        }

        fruitAdaptor = new FruitAdaptor(Fruit.this,fruitArrayList);
        recyclerView.setAdapter(fruitAdaptor);


        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }


}
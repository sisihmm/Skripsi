package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.anas.skripsi.R;

import java.util.ArrayList;

public class kitchen extends AppCompatActivity {

    TextView tvkitchen;
    RecyclerView recyclerView;

    private final String[] kitchen_name = {
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow"
    };

    private final String[] kitchen_image_urls = {
            "https://banner2.cleanpng.com/20190115/rxy/kisspng-clip-art-drawing-portable-network-graphics-image-c-other-club-penguin-cutouts-5c3d8227646a92.3012681215475348874113.jpg",
            "http://api.learn2crack.com/android/images/eclair.png",
            "http://api.learn2crack.com/android/images/froyo.png",
            "http://api.learn2crack.com/android/images/ginger.png",
            "http://api.learn2crack.com/android/images/honey.png",
            "http://api.learn2crack.com/android/images/icecream.png",
            "http://api.learn2crack.com/android/images/jellybean.png",
            "http://api.learn2crack.com/android/images/kitkat.png",
            "http://api.learn2crack.com/android/images/lollipop.png",
            "http://api.learn2crack.com/android/images/marshmallow.png"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        tvkitchen = findViewById(R.id.tv_kitchen);
        tvkitchen.setText("tes");

        recyclerView = findViewById(R.id.rekitchen);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ArrayList kitmodel = kitchenku();
        kitchenAdaptor adaptor = new kitchenAdaptor(getApplicationContext(),kitmodel);
        recyclerView.setAdapter(adaptor);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);
    }

    private ArrayList kitchenku() {
        ArrayList mykitchen = new ArrayList<>();
        for (int i=0; i<kitchen_name.length; i++){
            kitchenModel kitchenM = new kitchenModel();
            kitchenM.setKitchen_name(kitchen_name[i]);
            kitchenM.setKitchen_img(kitchen_image_urls[i]);
            mykitchen.add(kitchenM);
        }

        return mykitchen;
    }
}
package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.anas.skripsi.R;

import java.util.ArrayList;

public class kitchen extends AppCompatActivity {


    private final String[] kitchen_name = {
            "Kicthen = dapur",
            "spoon = sendok",
            "Fork = Garpu",
            "Plate = Piring",
            "Bowl = Mangkok",
            "Stove = Kompor",
            "Pan = Wajan",
            "Knife = Pisau",
            "Fridge = Kulkas",
            "Trash can = Tempat Sampah",
            "Sink = Tempat cuci",
            "Glass = Gelas",
            "Oven = Oven",
            "Rice cooker = penanak nasi"
    };

    private final String[] kitchen_image_urls = {
            "https://2.bp.blogspot.com/-zgKTwtVzIy4/TxlyZNHBHAI/AAAAAAAAABg/RqHeHOsdQZg/w800/dapur+edit.jpg",
            "https://png.pngtree.com/png-vector/20190121/ourlarge/pngtree-rice-spoon-whistle-cartoon-wooden-spoon-png-image_508056.jpg",
            "https://cdn.pixabay.com/photo/2014/03/31/21/34/fork-302253_960_720.jpg",
            "https://cdn-m2.fabelio.com/catalog/product/p/i/piring_dovey_dinner_plate_stoneware_grey_1_2-1_hires.jpg?auto=format",
            "https://www.glorimelamine.com/wp-content/uploads/2020/10/Mangkok-Nasi-Hitam-Merah-Glori-Melamine.jpg",
            "https://static.bmdstatic.com/pk/product/medium/5c5becace22ae.jpg",
            "https://cf.shopee.co.id/file/a3132491cd8d68bdac581497eadff44b",
            "https://png.pngtree.com/png-vector/20191024/ourlarge/pngtree-knife-icon-cartoon-style-png-image_1854140.jpg",
            "https://www.jasaservis.net/wp-content/uploads/2020/07/isi-kulkas-650x450.jpg",
            "https://st.depositphotos.com/2400497/2931/v/600/depositphotos_29310837-stock-illustration-trash-can.jpg",
            "https://thumbs.dreamstime.com/b/cartoon-home-washroom-sink-23446114.jpg",
            "https://png.pngtree.com/element_our/20190603/ourlarge/pngtree-green-glassware-illustration-image_1459655.jpg",
            "https://png.pngtree.com/png-clipart/20210122/ourlarge/pngtree-blue-line-cartoon-oven-clipart-png-image_2770243.jpg",
            "https://media.istockphoto.com/vectors/rice-cooker-vector-design-vector-id639455920"
    };

    TextView tvkitchen;
    RecyclerView recyclerView;
    kitchenAdaptor KitchenAdaptor;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kitchen);

        tvkitchen = findViewById(R.id.tv_kitchen);
        tvkitchen.setText("Hello guys, how are you today?\n"+
                "Hari ini kita bertemu lagi dengan materi baru\n"+
                "Kali ini kita akan mengenal kosakata\n"+
                "dalam bahasa inggris mengenai dapur atau\n"+
                "dalam bahasa inggrisnya berarti kitchen");

        recyclerView = findViewById(R.id.rekitchen);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ArrayList kitmodel = kitchenku();
        kitchenAdaptor adaptor = new kitchenAdaptor(getApplicationContext(),kitmodel);
        recyclerView.setAdapter(adaptor);



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
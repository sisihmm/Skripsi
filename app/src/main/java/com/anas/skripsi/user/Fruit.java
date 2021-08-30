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

    private final String[] fruit_name = {
            "apple = apel",
            "apricot = aprikot",
            "avocado = alpukat",
            "banana = pisang",
            "blackberry = beri hitam",
            "blood orange = jeruk merah",
            "blueberry = bluberi",
            "cantaloupe = blewah",
            "cherry = ceri",
            "citron = limau",
            "citrus = jeruk",
            "coconut = kelapa",
            "custard-apple = srikaya",
            "dragonfruit = buah naga",
            "durian = durian",
            "date = kurma",
            "grape = anggur",
            "grapefruit = jeruk sitrus",
            "guava = jambu biji",
            "honeydew = melon madu"
    };

    private final String[] fruit_image_urls = {
            "https://banner2.cleanpng.com/20190115/rxy/kisspng-clip-art-drawing-portable-network-graphics-image-c-other-club-penguin-cutouts-5c3d8227646a92.3012681215475348874113.jpg",
            "https://png.pngtree.com/png-vector/20190114/ourlarge/pngtree-apricot-plum-summer-fruit-cartoon-fruit-png-image_330834.jpg",
            "https://www.pngitem.com/pimgs/m/196-1969755_clip-art-gratis-gambar-buah-alpukat-clipart-gambar.png",
            "https://3.bp.blogspot.com/-MPn_UWmXBUM/ViM71afduiI/AAAAAAAAEag/uM3lVcVgljY/s1600/Gambar%2BKartun%2BBuah%2BPisang.jpg",
            "https://media.istockphoto.com/photos/closeup-of-two-fresh-blackberry-with-leaves-picture-id173612468?k=20&m=173612468&s=612x612&w=0&h=jY790aT-6qVXYaOXN0mfJrgA7MVQhrCvPn12EtYSAcI=",
            "https://cdn-cas.orami.co.id/parenting/images/7_Khasiat_Jeruk_Bali_Merah_Pomelo_Untuk_Anak_6.width-800.jpg",
            "https://photo.reqnews.com/data/images/blueberry.jpg",
            "https://res.cloudinary.com/dk0z4ums3/image/upload/v1531972597/attached_image/manfaat-buah-blewah-yang-penting-diketahui.jpg",
            "https://images.bisnis-cdn.com/posts/2021/01/08/1340594/ceri.jpg",
            "https://cdn-2.tstatic.net/bogor/foto/bank/images/air-jeruk-nipis_20181024_064643.jpg",
            "https://statik.tempo.co/data/2016/03/17/id_490393/490393_620.jpg",
            "https://asset-a.grid.id/crop/0x4:626x363/700x465/photo/2021/07/09/fresh-coconut-juice-drinking-iso-20210709104718.jpg",
            "https://cdn0-production-images-kly.akamaized.net/b9ho1Tg8kxQOH27HDKwjNMzzWlc=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/2874491/original/038968300_1565087262-iStock-1040422630.jpg",
            "https://cdn0-production-images-kly.akamaized.net/_-cn5j0N3fCgeiyHD5XRzk99czk=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/1753506/original/051033400_1509172164-Buah-Naga-Beda-Warna-Beda-Manfaat.jpg",
            "https://images.bisnis-cdn.com/posts/2017/07/19/672826/durian.jpg",
            "https://cdn.popmama.com/content-images/post/20210415/dried-date-palm-fruits-with-green-leaves-252965-425-04d6fdc79cfe0e2b506b021206903216_600xauto.jpg",
            "https://borneo24.com/wp-content/uploads/2021/06/black-grape-3.jpg",
            "http://rumahbuah.com/wp-content/uploads/2015/04/Rumbu_-JerukBali.jpg",
            "https://mmc.tirto.id/image/2019/06/17/jambu-iji-istockphotoo_ratio-16x9.jpg",
            "https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full//93/MTA-9646212/sayur_home_delivery_sayurhd_buah_segar_manis_melon_madu_1_buah_-1-500_gram_-_2-000_gram-_full02_h06oh7sp.jpg"
    };

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



        ArrayList fmodel = fruitku();
        FruitAdaptor adaptor = new FruitAdaptor(getApplicationContext(),fmodel);
        recyclerView.setAdapter(adaptor);


        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    private ArrayList fruitku() {
        ArrayList myfruit = new ArrayList<>();
        for (int i=0;i<fruit_name.length;i++){
            FruitModel fruitmodel = new FruitModel();
            fruitmodel.setFruit_name(fruit_name[i]);
            fruitmodel.setFruit_image_urls(fruit_image_urls[i]);
            myfruit.add(fruitmodel);
        }
        return myfruit;
    }


}

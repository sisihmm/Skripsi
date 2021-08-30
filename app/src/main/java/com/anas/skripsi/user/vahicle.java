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
            "Airplane: Pesawat terbang ",
            "Ambulance: Ambulans ",
            "Bajaj: Bajaj ",
            "Bicycle/bike: Sepeda ",
            "Boat: Perahu ",
            "Bus: Bus ",
            "Cable car: Kereta gantung ",
            "Canoe: Sampan ",
            "Car: Mobil ",
            "Carriage: Delman ",
            "Cart: Gerobak ",
            "Electric car: Mobil listrik ",
            "Ferry: Kapal feri ",
            "Fire truck: Truk pemadam kebakaran ",
            "Golf cart: Mobil golf ",
            "Helicopter: Helikopter",
            "Hot air balloon: Balon udara"

    };

    private final String[] vahicle_image_urls = {
            "https://andreketungau.files.wordpress.com/2013/11/gambar-pesawat.jpg",
            "https://cdn-2.tstatic.net/jateng/foto/bank/images/ilustrasi-mobil-ambulance.jpg",
            "https://images.tokopedia.net/img/cache/500-square/product-1/2016/7/21/430414/430414_aef6b843-9349-4f97-9db8-4fd9c3fa78cb.jpg.webp",
            "https://images.squarespace-cdn.com/content/v1/57f08e8b579fb34c245b2579/1575940113123-LDVCI6G607CGDQU5VPTX/2019-12-10%2B07.40.04.jpg?format=1000w",
            "https://www.teknikarea.com/wp-content/uploads/2020/06/Bagian-Bagian-Perahu-Nelayan-1280x720.jpg",
            "http://www.molarentcar.com/images/mobil/bus-pariwisata/bus-pariwisata.jpg",
            "https://akcdn.detik.net.id/visual/2018/10/09/77ab8e7f-f85a-4315-b0f5-df542e57edb7_169.jpeg?w=650",
            "https://www.wikihow.com/images/c/c3/Draw-a-Boat-Step-12.jpg",
            "https://foto.kontan.co.id/g0bQnW6s_kt1QfWo6cBNbnArIWU=/smart/2021/03/24/1884039865p.jpg",
            "https://entinanova.files.wordpress.com/2017/01/delman.jpg?w=620",
            "https://1.bp.blogspot.com/--x2omIcbNsc/T0uI4DwYB7I/AAAAAAAAAIs/tsquHxpYBdg/s1600/angkringan.jpg",
            "https://images.bisnis-cdn.com/thumb/posts/2020/12/30/1336834/001-2.jpg?w=744&h=465",
            "https://png.pngtree.com/png-vector/20201224/ourlarge/pngtree-cartoon-hand-drawn-ship-transportation-vector-png-image_2592141.jpg",
            "https://st2.depositphotos.com/1719108/5888/i/600/depositphotos_58880777-stock-photo-cartoon-firetruck.jpg",
            "https://lh3.googleusercontent.com/proxy/R7E0D-R1kHRUdL4xjOB2kwg1jaVnKkr3_N_60r5m5s3E-FfwIZJF9PX5X9lhQfcm-Fb4KCLJtEGSfXmn9VBZKlC1ozHkOFpclWRmrJ1-SdTqChOZCA",
            "https://images.bisnis-cdn.com/posts/2018/07/17/817360/helikopter-subaru-bell-412e.jpg",
            "https://asset-a.grid.id/crop/0x0:0x0/780x800/photo/bobofoto/original/21990_kenapa-balon-udara-bisa-terbang.jpg"

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
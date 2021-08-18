package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.anas.skripsi.R;

import java.util.ArrayList;
import java.util.Objects;


public class LessonAlfabet extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> alfaArrayList;
    AlfaAdapter alfaAdapter;

    TextView mTextView;

    MediaPlayer alfamusic;
    ImageView play, stop;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_alfabet);

        mTextView = findViewById(R.id.textView2);
        mTextView.setText("Hello everyone, how are you today?\n"+
                "Pada kesempatan kali ini kami akan menerangkan"+
                "bagaimana cara membaca alphabet dalam bahasa inggris.\n"+
                "Materi alphabet ini tentu sudah diajarkan"+
                "di bangku sekolah dasar bahkan saat kita di taman\n"+
                "kanak-kanak.\n"+
                "\n"+
                "Cara Membaca Alphabet dalam Bahasa Inggris");


        recyclerView = findViewById(R.id.realfa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        alfaArrayList = new ArrayList<>();
        alfaArrayList.add("Aa = [ei] = Apple = Apel");
        alfaArrayList.add("Bb = [bi:] = Ball = Bola");
        alfaArrayList.add("Cc = [si:] = Cat = Kucing");
        alfaArrayList.add("Dd = [di:] = Dog = Anjing");
        alfaArrayList.add("Ee = [i:] = Elephant = Gajah");
        alfaArrayList.add("Ff = [ef] = Fish = Ikan");
        alfaArrayList.add("Gg =[dӠi:] = Goat = Kambing");
        alfaArrayList.add("Hh = [eit∫] = Hand = Tangan");
        alfaArrayList.add("Ii = [ai] = Iguana = Iguana");
        alfaArrayList.add("Jj = [dӠei] = Juice = Jus");
        alfaArrayList.add("Kk = [kei] = King = Raja");
        alfaArrayList.add("Ll = [el] = Lamb = Domba");
        alfaArrayList.add("Mm = [em] = Monkey = Monyet");
        alfaArrayList.add("Nn = [en] = Nose = Hidung");
        alfaArrayList.add("Oo = [o] = Ocean = Laut");
        alfaArrayList.add("Pp =[pi:] = Pig = Babi");
        alfaArrayList.add("Qq  = [kju:] = Queen = Queen");
        alfaArrayList.add("Rr = [a:/ar] = Rat = Tikus");
        alfaArrayList.add("Ss = [es] = Sun = Matahari");
        alfaArrayList.add("Tt = [ti:] = Train = Kereta api");
        alfaArrayList.add("Uu = [ju:] = Umbrella = Payung");
        alfaArrayList.add("Vv =[vi:} = Violin = Biola");
        alfaArrayList.add("Ww = [‘dΛəlju:] = Water  = Air");
        alfaArrayList.add("Xx = [eks] = X - Ray = Sinar X-ray");
        alfaArrayList.add("Yy = [wai] = Yellow = Kuning");
        alfaArrayList.add("Zz = [zed/zi:] = Zoo = Kebun binatang");




        alfaAdapter = new AlfaAdapter(this, alfaArrayList);

        recyclerView.setAdapter(alfaAdapter);


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

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }


}
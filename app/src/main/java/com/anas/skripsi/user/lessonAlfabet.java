package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.anas.skripsi.R;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;
import java.io.InputStream;
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

        recyclerView = findViewById(R.id.recalfa);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        mTextView = findViewById(R.id.textView2);
        mTextView.setText("Hello everyone, how are you today? \n " +
                "Pada kesempatan kali ini kami akan menerangkan bagaimana cara membaca alphabet\n" +
                " dalam bahasa inggris. Materi alphabet ini tentu sudah diajarkan di bangku sekolah dasar\n" +
                " bahkan saat kita di taman kanak-kanak. Namun banyak dari kita yang bahkan orang dewasa \n" +
                " lupa bagaimana cara membaca alphabet dalam bahasa inggris karena jarang dipakai dalam \n" +
                "kehidupan sehari-hari. Jadi mari kita kembali mempelajari materi yang paling dasaaaaar ini,\n" +
                " hehe okee langsung saja~\n" +
                "\n" +
                "Cara Membaca Alphabet dalam Bahasa Inggris");


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




        alfaAdapter = new AlfaAdapter(LessonAlfabet.this, alfaArrayList);

        recyclerView.setAdapter(alfaAdapter);


        alfamusic = MediaPlayer.create(this, R.raw.alfa);
        play = findViewById(R.id.btnPlay);
        stop = findViewById(R.id.btnStop);


        play.setOnClickListener(view -> {
            alfamusic.start();
        });

        stop.setOnClickListener(view -> {
            alfamusic.stop();
//            alfamusic = MediaPlayer.create(this, R.raw.alfa);
        });

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }


}
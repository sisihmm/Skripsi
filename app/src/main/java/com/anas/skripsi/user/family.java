package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import com.anas.skripsi.R;

import java.util.ArrayList;

public class family extends AppCompatActivity {

    TextView txvfamily;

    private final String[] family_name = {
            "Family = Keluarga",
            "Grandfather = Kakek",
            "Grandmother = Nenek",
            "Parent = Orang Tua",
            "Father = Ayah",
            "Mother = Ibu",
            "Children = Anak-anak",
            "Son = Anak kandung laki-laki",
            "Daughter = Anak kandung Perempuan",
            "Boy = Anak Laki-laki",
            "Girl = Anak Perempuan",
            "Only Child = Anak Tunggal",
            "Twins = Anak Kembar",
            "Step child = Anak tiri",
            "Adoptive child = Anak angkat",
            "Brother = Saudara laki-laki",
            "Sister = Saudara Perempuan",
            "Baby = Bayi",
            "Uncle = Paman",
            "Aunt = Bibi",
            "Husband = Suami",
            "Wife = Istri"
    };

    private final String[] family_image_urls = {
            "https://img.pikbest.com/png-images/qiantu/cartoon-hand-drawn-family-portrait_2673637.png!c1024wm0/compress/true/progressive/true/format/webp/fw/1024",
            "https://png.pngtree.com/element_our/20190601/ourlarge/pngtree-cartoon-grandfather-free-button-image_1371729.jpg",
            "https://d2gg9evh47fn9z.cloudfront.net/800px_COLOURBOX5873675.jpg",
            "https://i.pinimg.com/originals/7d/d4/9a/7dd49ac1a48440024e560c054c851463.jpg",
            "https://png.pngtree.com/element_our/20190601/ourlarge/pngtree-cartoon-father-holding-baby-bust-image_1364014.jpg",
            "https://www.teahub.io/photos/full/44-448451_foto-foto-kartun-lucu-gambar-ibu-dan-anak.jpg",
            "https://png.pngtree.com/png-vector/20210201/ourlarge/pngtree-social-distancing-kids-in-school-png-image_2879773.jpg",
            "https://img.lovepik.com/feishe/40044/2030.jpg!odetail650",
            "https://i1.wp.com/sharingconten.com/wp-content/uploads/2020/01/Gambar-Kartun-Muslimah-Anak-Kecil.jpg?resize=456%2C450&ssl=1",
            "https://png.pngtree.com/element_our/20200702/ourlarge/pngtree-cartoon-character-boy-child-toddler-elementary-school-student-illustration-hand-drawn-image_2298045.jpg",
            "https://media.istockphoto.com/vectors/cartoon-illustration-of-a-cute-cheerful-girl-wearing-beautiful-dress-vector-id1163903640",
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcScOtuDVfICDu52xi53Jh4PBxvAHDupk-BZcw&usqp=CAU",
            "https://assets.pikiran-rakyat.com/crop/13x0:1199x1021/x/photo/2020/09/10/1230464998.jpg",
            "https://1.bp.blogspot.com/-JFipwY1DMEU/XVTkAf0zzPI/AAAAAAAAHSo/q5r9F1aJeSYof8e9lwvNOQP9sAM4o7HCQCLcBGAs/s1600/DisiplinMOther.jpg",
            "https://ik.imagekit.io/chan/app/uploads/2020/11/anak-adopsi.jpg",
            "https://png.pngtree.com/png-clipart/20190921/original/pngtree-world-sleep-day-brother-brother-sleeping-cartoon-hand-drawn-character-png-image_4703698.jpg",
            "https://i.pinimg.com/originals/4b/66/5f/4b665fdce359af1f5590ea1bdf5d307b.jpg",
            "https://png.pngtree.com/element_our/20190604/ourlarge/pngtree-cute-cartoon-female-baby-image_1467727.jpg",
            "https://i.pinimg.com/originals/c7/a2/dc/c7a2dcf76cb9834db0027688bd458d8c.jpg",
            "https://img.pikbest.com/png-images/qiantu/cartoon-cute-aunty-shopping-home_2728310.png!c1024wm0/compress/true/progressive/true/format/webp/fw/1024",
            "https://3.bp.blogspot.com/-xdQb4zFJ1Bc/WNUXCPUT_3I/AAAAAAAAEME/jmr8VQRW0pwVdReXH0TtoreWBgSxvmVbQCLcB/s1600/naruto%2Bmenikah%2Bdengan%2Bhinata.jpg",
            "https://3.bp.blogspot.com/-xdQb4zFJ1Bc/WNUXCPUT_3I/AAAAAAAAEME/jmr8VQRW0pwVdReXH0TtoreWBgSxvmVbQCLcB/s1600/naruto%2Bmenikah%2Bdengan%2Bhinata.jpg"

    };

    RecyclerView recyclerView;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        txvfamily = findViewById(R.id.txvfmily);
        txvfamily.setText("Hello everyone, how are you today?\n"+
                "Pada kesempatan kali ini kami akan menerangkan"+
                "bagaimana cara membaca dalam bahasa inggris.\n"+
                "Materi alphabet ini tentu sudah diajarkan"+
                "di bangku sekolah dasar bahkan saat kita di taman\n"+
                "kanak-kanak.\n"+
                "\n"+
                "Cara Membaca Dan mengeja nama-nama keluarga");

        recyclerView = findViewById(R.id.refamily);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        ArrayList fmodel = familiku();
        FamilyAdapter adaptor = new FamilyAdapter(getApplicationContext(),fmodel);
        recyclerView.setAdapter(adaptor);

    }

    private ArrayList familiku() {
        ArrayList myfamily = new ArrayList<>();
        for (int i = 0; i < family_name.length; i++) {
            FamilyModel familyModel = new FamilyModel();
            familyModel.setName_family(family_name[i]);
            familyModel.setImg_family(family_image_urls[i]);
            myfamily.add(familyModel);
        }
        return myfamily;
    }

}
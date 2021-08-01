package com.anas.skripsi.user;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;

import com.anas.skripsi.R;

import java.util.ArrayList;
import java.util.Objects;

public class Pob extends AppCompatActivity {

    private ScaleGestureDetector scaleGestureDetector;
    private float mScaleFactor = 1.0f;
    private ImageView imageView;
    RecyclerView recyclerView;
    ArrayList<String> pobArrayList;
    PobAdapter pobAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pob);

        recyclerView = findViewById(R.id.repob);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        pobArrayList = new ArrayList<>();
        pobArrayList.add("head = kepala");
        pobArrayList.add("hair = rambut");
        pobArrayList.add("face = wajah");
        pobArrayList.add("forehead = kening");
        pobArrayList.add("eye = mata");
        pobArrayList.add("eyebrow = alis");
        pobArrayList.add("eyelashes = bulu mata");
        pobArrayList.add("ear = telinga");
        pobArrayList.add("nose = hidung");
        pobArrayList.add("chin = dagu");
        pobArrayList.add("cheek = pipi");
        pobArrayList.add("neck = leher");
        pobArrayList.add("lips = bibir");
        pobArrayList.add("tooth = gigi");
        pobArrayList.add("tongue = lidah");
        pobArrayList.add("mouth = mulut");
        pobArrayList.add("elbow = sikut");
        pobArrayList.add("arm = pergelangan tangan");
        pobArrayList.add("hand = tangan");
        pobArrayList.add("finger = jari");
        pobArrayList.add("thumb = jempol");
        pobArrayList.add("index finger = jari telunjuk");
        pobArrayList.add("middle finger = jari tengah");
        pobArrayList.add("ring finger = jari manis");
        pobArrayList.add("little finger = jari kelingking");
        pobArrayList.add("shoulder = bahu");
        pobArrayList.add("chest = dada");
        pobArrayList.add("stomach = perut");
        pobArrayList.add("waist = pinggang");
        pobArrayList.add("skin = kulit");
        pobArrayList.add("knee = lutut");
        pobArrayList.add("leg  = pergelangan kaki");
        pobArrayList.add("foot = kaki");
        pobArrayList.add("ankle = mata kaki");
        pobArrayList.add("heel = tumit");
        pobArrayList.add("toes = jari kaki");
        pobArrayList.add("back = punggung");
        pobArrayList.add("thigh = paha");
        pobArrayList.add("calf = betis");
        pobArrayList.add("bottom = pantat");

        pobAdapter = new PobAdapter(this, pobArrayList);
        recyclerView.setAdapter(pobAdapter);


        imageView = findViewById(R.id.ivpob);
        scaleGestureDetector = new ScaleGestureDetector(this, new ScaleListener());

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        scaleGestureDetector.onTouchEvent(motionEvent);
        return true;
    }

    private class ScaleListener extends ScaleGestureDetector.SimpleOnScaleGestureListener {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            mScaleFactor *= scaleGestureDetector.getScaleFactor();
            mScaleFactor = Math.max(0.1f, Math.min(mScaleFactor, 10.0f));
            imageView.setScaleX(mScaleFactor);
            imageView.setScaleY(mScaleFactor);
            return true;
        }

    }
    }
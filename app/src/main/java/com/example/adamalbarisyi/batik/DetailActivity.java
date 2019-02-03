package com.example.adamalbarisyi.batik;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    TextView tvName;
    ImageView Imgphoto;
    TextView descripion;

    public static final String BATIK_TITLE = "BATIK_TITLE";
    public static final String BATIK_DESCRIPTION = "BATIK_DESCRIPTION";
    public static final String BATIK_IMGPHOTO = "BATIK_IMGPHOTO";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tvName = findViewById(R.id.tv_name_item);
        Imgphoto = findViewById(R.id.img_backdrop_item);
        descripion = findViewById(R.id.tv_description_item);


        String tittle = getIntent().getStringExtra(BATIK_TITLE);
        String description = getIntent().getStringExtra(BATIK_DESCRIPTION);
        String imgphoto = getIntent().getStringExtra(BATIK_IMGPHOTO);

        tvName.setText(tittle);
        descripion.setText(description);
        Glide.with(DetailActivity.this)
                .load(imgphoto)
                .into(Imgphoto);

    }


}

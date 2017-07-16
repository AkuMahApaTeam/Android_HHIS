package com.mrabid.hhis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mrabid.hhis.R;

public class ArtikelActivity extends AppCompatActivity {

    TextView judul_,deskripsi_,sinopsis_;
    ImageView image_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_artikel);
        getSupportActionBar().hide();

        judul_=(TextView) findViewById(R.id.txt_MjdlArtikel);
        deskripsi_=(TextView) findViewById(R.id.txt_MdeskripsiArtikel);
        sinopsis_=(TextView) findViewById(R.id.txt_MsinopsisArtikel);
        image_=(ImageView)findViewById(R.id.img_Martikel);

        judul_.setText(getIntent().getExtras().getString("judul"));
        deskripsi_.setText(Html.fromHtml(getIntent().getExtras().getString("deskripsi")).toString());
        sinopsis_.setText(getIntent().getExtras().getString("abstrak"));
        Glide.with(this).load("http://172.20.10.3/hhis/backend/web/"+getIntent().getExtras().getString("image")).into(image_);
    }
}

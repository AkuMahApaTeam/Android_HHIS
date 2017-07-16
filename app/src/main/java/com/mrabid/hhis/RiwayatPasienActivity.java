package com.mrabid.hhis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RiwayatPasienActivity extends AppCompatActivity {

    TextView namaDokter,tglPeriksa,namaPasien,tinggiBadan,beratBadan,umur,no_telp,riwayat_kesehatan,diagnosa,keluhan,larangan,note,perawatan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_pasien);

        namaDokter = (TextView)findViewById(R.id.txt_dokter);
        tglPeriksa = (TextView)findViewById(R.id.txt_tgl);
        tinggiBadan = (TextView)findViewById(R.id.txt_tngBadan);
        beratBadan = (TextView)findViewById(R.id.txt_brtBdn);
        namaPasien = (TextView)findViewById(R.id.txt_namaPasien);
        umur = (TextView)findViewById(R.id.txt_umur);
        no_telp = (TextView)findViewById(R.id.txt_No_telp);
        riwayat_kesehatan = (TextView)findViewById(R.id.txt_riwayat);
        diagnosa = (TextView)findViewById(R.id.txt_diagnosa);
        keluhan = (TextView)findViewById(R.id.txt_keluhan);
        larangan = (TextView)findViewById(R.id.txt_larangan);
        note = (TextView)findViewById(R.id.txt_note);
        perawatan = (TextView)findViewById(R.id.txt_keperawatan);


        namaDokter.setText(getIntent().getExtras().getString("nama_dokter"));
        tglPeriksa.setText(getIntent().getExtras().getString("tgl_periksa"));
        tinggiBadan.setText(getIntent().getExtras().getString("tinggi_badan")+"Cm");
        beratBadan.setText(getIntent().getExtras().getString("berat_badan")+"Kg");
        namaPasien.setText(getIntent().getExtras().getString("nama_pasien"));
        umur.setText(getIntent().getExtras().getString("umur"));
        no_telp.setText(getIntent().getExtras().getString("no_telp_pasien"));
        riwayat_kesehatan.setText(getIntent().getExtras().getString("riwayat_kesehatan_keluarga"));
//        turPenyakit.setText(getIntent().getExtras().getString("alamat"));
//        gejala.setText(getIntent().getExtras().getString("no_telp_pasien"));
        diagnosa.setText(getIntent().getExtras().getString("diagnosa"));
        keluhan.setText(getIntent().getExtras().getString("keluhan_utama"));
        larangan.setText(getIntent().getExtras().getString("larangan"));
        note.setText(getIntent().getExtras().getString("note"));
        perawatan.setText(getIntent().getExtras().getString("perawatan"));

    }
}

package com.mrabid.hhis.Fragment;

import android.app.ProgressDialog;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mrabid.hhis.Adapter.PasienAdapter;
import com.mrabid.hhis.Helper.AppConfig;
import com.mrabid.hhis.Modal.Dokter;
import com.mrabid.hhis.Modal.Pasien;
import com.mrabid.hhis.Modal.RiwayatPasien;
import com.mrabid.hhis.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

public class PasienFragment extends Fragment {

    private EditText EdtCari;
    private ImageView imgCari;
    private ImageView imgLogo;
    private TextView txt_NAMA;
    private ProgressDialog loading;
    private RecyclerView RcyPasien;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EdtCari = (EditText) getActivity().findViewById(R.id.edt_cari);
        imgCari = (ImageView) getActivity().findViewById(R.id.img_cari);
        RcyPasien = (RecyclerView) getActivity().findViewById(R.id.rcy_pasien);
        txt_NAMA = (TextView)getActivity().findViewById(R.id.txt_NAMA);

        imgCari.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                getData();
            }
        });
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_pasien_fragment, container, false);
    }



    private void getData() {
        String no_ktp = EdtCari.getText().toString();
        if (no_ktp.equals("")) {
            Toast.makeText(getActivity(), "Tolong diisi..", Toast.LENGTH_SHORT).show();
            return;
        }
        loading = ProgressDialog.show(getActivity(),"Please wait...","mencari...",false,false);

        String url = AppConfig.PASIEN+no_ktp;

        JsonObjectRequest stringRequest = new JsonObjectRequest(url,null,new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                loading.dismiss();
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getActivity(),"error fuck"+error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

    private void showJSON(JSONObject response){

        List<Pasien> listPasien = new ArrayList<>();
        List<RiwayatPasien> listRiwayat = new ArrayList<>();


        RcyPasien.setHasFixedSize(true);
        RcyPasien.setLayoutManager(new LinearLayoutManager(getActivity()));

            try {
                Pasien pasien;
                Dokter dokter;
                    JSONObject data = response;

                pasien = new Pasien(data.getInt("id_pasien"),data.getString("nama_pasien"),data.getString("alamat"),
                        data.getString("no_telp_pasien"),data.getString("gol_darah"),data.getString("jenis_kelamin"),
                        data.getInt("nik"),listRiwayat);

//                dokter = new Dokter(data.getString(""));

                txt_NAMA.setText("Data pasien :"+data.getString("nama_pasien"));

                JSONArray jArray = (JSONArray) data.get("riwayat");
                    if (jArray != null) {
                        for (int i=0;i<jArray.length();i++){
                            JSONObject data2 = (JSONObject) jArray.getJSONObject(i);

                            JSONObject datadokter = (JSONObject) data2.get("dokter");

                            listRiwayat.add(new RiwayatPasien(
                                    data2.getInt("id_dokter"),
                                    new Dokter(datadokter.getString("nama_dokter"),datadokter.getString("no_telp")),
                                    data2.getInt("id_riwayat"),
                                    data2.getInt("berat_badan"),
                                    data2.getInt("tinggi_badan"),
                                    data2.getString("riwayat_kesehatan_keluarga"),
                                    data2.getString("keluhan_utama"),
                                    data2.getString("diagnosa"),
                                    data2.getString("larangan"),
                                    data2.getString("note"),
                                    data2.getString("tgl_periksa"),
                                    data2.getString("perawatan"),
                                    data2.getInt("umur")));

                        }
                    }


                    RcyPasien.setAdapter(new PasienAdapter(getActivity(), listRiwayat,pasien));
                    //Toast.makeText(getActivity(), "akhir ", Toast.LENGTH_LONG).show();

            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getActivity(), "CEK " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
            //TxtHasil.setText("Tanggal Periksa:\t"+tgl_periksa+"\nnama pasien:\t" +namaPasien+ "\numur:\t"+ umur+"\nberat badan:\t" +beratBadan);

    }

}

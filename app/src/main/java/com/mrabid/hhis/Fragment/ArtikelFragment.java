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
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mrabid.hhis.Adapter.ArtikelAdapter;
import com.mrabid.hhis.Helper.AppConfig;
import com.mrabid.hhis.Modal.Artikel;
import com.mrabid.hhis.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ArtikelFragment extends Fragment {

    private ProgressDialog loading;
    RecyclerView rcyartikel;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rcyartikel=(RecyclerView) getActivity().findViewById(R.id.rcy_artikel);

        getData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_artikel_fragment, container, false);
    }

    private void getData(){
        String url = AppConfig.ARTIKEL;

        loading = ProgressDialog.show(getActivity(),"Please wait...","mencari...",false,false);
        JsonArrayRequest stringRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                showJSON(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        loading.dismiss();
                        Toast.makeText(getActivity(),"Server Error or No Internet Connection",Toast.LENGTH_LONG).show();
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }

    private void showJSON(JSONArray response){
        List<Artikel> artikel = new ArrayList<>();

        try {

            for (int i = 0; i < response.length(); i++) {
                JSONObject data = (JSONObject) response.getJSONObject(i);
                artikel.add(new Artikel(data.getString("judul"),(data.getString("deskripsi")),
                        data.getString("image"), (data.getString("abstrak"))));
            }

            rcyartikel.setHasFixedSize(true);
            rcyartikel.setLayoutManager(new LinearLayoutManager(getActivity()));
            rcyartikel.setAdapter(new ArtikelAdapter(getActivity(), artikel));

            loading.dismiss();


        } catch (JSONException e) {
            e.printStackTrace();
            loading.dismiss();
            Toast.makeText(getActivity(), "CEK " + e.getMessage(), Toast.LENGTH_LONG).show();
        }
        //TxtHasil.setText("Tanggal Periksa:\t"+tgl_periksa+"\nnama pasien:\t" +namaPasien+ "\numur:\t"+ umur+"\nberat badan:\t" +beratBadan);
    }
}

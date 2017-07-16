package com.mrabid.hhis.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mrabid.hhis.Modal.Pasien;
import com.mrabid.hhis.Modal.RiwayatPasien;
import com.mrabid.hhis.R;
import com.mrabid.hhis.RiwayatPasienActivity;

import java.util.List;

/**
 * Created by Mr.Abid on 5/12/2017.
 */

public class PasienAdapter extends RecyclerView.Adapter<PasienAdapter.ViewHolder> {
    Context context;
    List<RiwayatPasien> listPasien;
    Pasien pasien;

    public PasienAdapter(Context context, List<RiwayatPasien> listPasien, Pasien pasien) {
        this.context = context;
        this.listPasien = listPasien;
        this.pasien = pasien;
    }

    @Override
    public PasienAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_pasien,null));
    }

    @Override
    public void onBindViewHolder(PasienAdapter.ViewHolder holder, int position) {
        final RiwayatPasien p = listPasien.get(position);

        holder.nama_dokter.setText(""+p.getDokter().getNamaDokter());
        holder.tgl_periksa.setText(""+p.getTglPeriksa());
        holder.no_telp.setText(""+p.getDokter().getNoTelp());
        holder.diagnosa.setText(""+p.getDiagnosa());

        holder.cvPasien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent (context,RiwayatPasienActivity.class);
                a.putExtra("nama_dokter", (p.getDokter().getNamaDokter()));
                a.putExtra("tgl_periksa",(p.getTglPeriksa()));
                a.putExtra("nama_pasien",pasien.getNamaPasien());
                a.putExtra("umur",p.getUmur().toString());
                a.putExtra("riwayat_kesehatan_keluarga",(p.getRiwayatKesehatanKeluarga()));
                a.putExtra("diagnosa",(p.getDiagnosa()));
                a.putExtra("keluhan_utama",String.valueOf(p.getKeluhanUtama()));
                a.putExtra("larangan",p.getLarangan());
                a.putExtra("note",p.getNote());
                a.putExtra("perawatan",p.getPerawatan());
                a.putExtra("tinggi_badan",p.getTinggiBadan().toString());
                a.putExtra("berat_badan",p.getBeratBadan().toString());
                a.putExtra("no_telp_pasien",pasien.getNoTelpPasien());
                context.startActivity(a);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listPasien.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView nama_dokter,no_telp,tgl_periksa,diagnosa;
        public CardView cvPasien;

        public ViewHolder(View itemView) {
            super(itemView);

            nama_dokter = (TextView)itemView.findViewById(R.id.txt_namaDokter);
            tgl_periksa = (TextView)itemView.findViewById(R.id.txt_tgl);
            no_telp=(TextView)itemView.findViewById(R.id.txt_noTelp);
            diagnosa=(TextView)itemView.findViewById(R.id.txt_dignosa);



            cvPasien = (CardView)itemView.findViewById(R.id.cv_pasien);


        }
    }
}

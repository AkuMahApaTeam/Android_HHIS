package com.mrabid.hhis.Modal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mr.Abid on 6/12/2017.
 */

public class RiwayatPasien {
    private Integer idDokter;
    private Dokter dokter;
    private Integer idRiwayat;
    private Integer beratBadan;
    private Integer tinggiBadan;
    private Integer umur;
    private String riwayatKesehatanKeluarga;
    private String keluhanUtama;
    private String diagnosa;
    private String larangan;
    private String note;
    private String tglPeriksa;
    private String perawatan;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public RiwayatPasien(Integer idDokter,Dokter dokter , Integer idRiwayat, Integer beratBadan, Integer tinggiBadan, String riwayatKesehatanKeluarga, String keluhanUtama, String diagnosa, String larangan, String note, String tglPeriksa, String perawatan, Integer umur) {
        this.idDokter = idDokter;
        this.dokter = dokter;
        this.idRiwayat = idRiwayat;
        this.beratBadan = beratBadan;
        this.tinggiBadan = tinggiBadan;
        this.riwayatKesehatanKeluarga = riwayatKesehatanKeluarga;
        this.keluhanUtama = keluhanUtama;
        this.diagnosa = diagnosa;
        this.larangan = larangan;
        this.note = note;
        this.tglPeriksa = tglPeriksa;
        this.perawatan = perawatan;
        this.umur = umur;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }

    public Integer getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(Integer idDokter) {
        this.idDokter = idDokter;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public Integer getIdRiwayat() {
        return idRiwayat;
    }

    public void setIdRiwayat(Integer idRiwayat) {
        this.idRiwayat = idRiwayat;
    }

    public Integer getBeratBadan() {
        return beratBadan;
    }

    public void setBeratBadan(Integer beratBadan) {
        this.beratBadan = beratBadan;
    }

    public Integer getTinggiBadan() {
        return tinggiBadan;
    }

    public void setTinggiBadan(Integer tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }

    public String getRiwayatKesehatanKeluarga() {
        return riwayatKesehatanKeluarga;
    }

    public void setRiwayatKesehatanKeluarga(String riwayatKesehatanKeluarga) {
        this.riwayatKesehatanKeluarga = riwayatKesehatanKeluarga;
    }

    public String getKeluhanUtama() {
        return keluhanUtama;
    }

    public void setKeluhanUtama(String keluhanUtama) {
        this.keluhanUtama = keluhanUtama;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    public String getLarangan() {
        return larangan;
    }

    public void setLarangan(String larangan) {
        this.larangan = larangan;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getTglPeriksa() {
        return tglPeriksa;
    }

    public void setTglPeriksa(String tglPeriksa) {
        this.tglPeriksa = tglPeriksa;
    }

    public String getPerawatan() {
        return perawatan;
    }

    public void setPerawatan(String perawatan) {
        this.perawatan = perawatan;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String toString(){
        return getIdDokter().toString()+getTglPeriksa();
    }
}
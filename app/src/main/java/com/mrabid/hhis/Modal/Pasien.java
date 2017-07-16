package com.mrabid.hhis.Modal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Mr.Abid on 7/15/2017.
 */

public class Pasien {
    private Integer idPasien;
    private String namaPasien;
    private String alamat;
    private String noTelpPasien;
    private String golDarah;
    private String jenisKelamin;
    private Integer nik;
    private List<RiwayatPasien> riwayat = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Pasien(Integer idPasien, String namaPasien, String alamat, String noTelpPasien, String golDarah, String jenisKelamin, Integer nik, List<RiwayatPasien> riwayat) {
        this.idPasien = idPasien;
        this.namaPasien = namaPasien;
        this.alamat = alamat;
        this.noTelpPasien = noTelpPasien;
        this.golDarah = golDarah;
        this.jenisKelamin = jenisKelamin;
        this.nik = nik;
        this.riwayat = riwayat;
    }

    public Integer getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(Integer idPasien) {
        this.idPasien = idPasien;
    }

    public String getNamaPasien() {
        return namaPasien;
    }

    public void setNamaPasien(String namaPasien) {
        this.namaPasien = namaPasien;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoTelpPasien() {
        return noTelpPasien;
    }

    public void setNoTelpPasien(String noTelpPasien) {
        this.noTelpPasien = noTelpPasien;
    }

    public String getGolDarah() {
        return golDarah;
    }

    public void setGolDarah(String golDarah) {
        this.golDarah = golDarah;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public Integer getNik() {
        return nik;
    }

    public void setNik(Integer nik) {
        this.nik = nik;
    }

    public List<RiwayatPasien> getRiwayat() {
        return riwayat;
    }

    public void setRiwayat(List<RiwayatPasien> riwayat) {
        this.riwayat = riwayat;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

package com.mrabid.hhis.Modal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mr.Abid on 7/15/2017.
 */

public class Dokter {
    private Integer idDokter;
    private Integer idNoIzin;
    private String email;
    private String alamatRumah;
    private String alamatPraktik;
    private String namaDokter;
    private String noTelp;
    private String password;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Dokter(Integer idDokter, Integer idNoIzin, String email, String alamatRumah, String alamatPraktik, String namaDokter, String noTelp, String password) {
        this.idDokter = idDokter;
        this.idNoIzin = idNoIzin;
        this.email = email;
        this.alamatRumah = alamatRumah;
        this.alamatPraktik = alamatPraktik;
        this.namaDokter = namaDokter;
        this.noTelp = noTelp;
        this.password = password;
    }

    public Dokter(String namaDokter, String noTelp) {
        this.namaDokter = namaDokter;
        this.noTelp = noTelp;
    }

    public Integer getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(Integer idDokter) {
        this.idDokter = idDokter;
    }

    public Integer getIdNoIzin() {
        return idNoIzin;
    }

    public void setIdNoIzin(Integer idNoIzin) {
        this.idNoIzin = idNoIzin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAlamatRumah() {
        return alamatRumah;
    }

    public void setAlamatRumah(String alamatRumah) {
        this.alamatRumah = alamatRumah;
    }

    public String getAlamatPraktik() {
        return alamatPraktik;
    }

    public void setAlamatPraktik(String alamatPraktik) {
        this.alamatPraktik = alamatPraktik;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public void setNamaDokter(String namaDokter) {
        this.namaDokter = namaDokter;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return getIdDokter().toString()+getIdNoIzin().toString()+getEmail()+getAlamatRumah()+getAlamatPraktik()+getNamaDokter()+getNoTelp()+getPassword();
    }
}

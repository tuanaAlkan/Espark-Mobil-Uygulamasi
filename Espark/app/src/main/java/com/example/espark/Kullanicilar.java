package com.example.espark;

public class Kullanicilar {

    String id, ad, sifre, lok;

    public Kullanicilar() {
    }

    public Kullanicilar(String id, String ad, String sifre, String lok) {
        this.id = id;
        this.ad = ad;
        this.sifre = sifre;
        this.lok = lok;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getLok() {
        return lok;
    }

    public void setLok(String lok) {
        this.lok = lok;
    }
}

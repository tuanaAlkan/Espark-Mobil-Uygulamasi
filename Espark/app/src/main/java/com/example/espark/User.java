package com.example.espark;

public class User {

    int sifre;
    String kullaniciId, kullaniciAd, lokasyon;

    public User() {
    }

    public User(String id, int sifre, String kullaniciAd, String lokasyon) {
        int Id = Integer.valueOf(id);
        Id++;
        this.kullaniciId = id;
        this.sifre = sifre;
        this.kullaniciAd = kullaniciAd;
        this.lokasyon = lokasyon;
    }
/*
    public int getKullaniciId() {
        return kullaniciId;
    }

    public void setKullaniciId(int kullaniciId) {
        this.kullaniciId = kullaniciId;
    }

    public int getSifre() {
        return sifre;
    }

    public void setSifre(int sifre) {
        this.sifre = sifre;
    }

    public String getKullaniciAd() {
        return kullaniciAd;
    }

    public void setKullaniciAd(String kullaniciAd) {
        this.kullaniciAd = kullaniciAd;
    }

    public String getLokasyon() {
        return lokasyon;
    }

    public void setLokasyon(String lokasyon) {
        this.lokasyon = lokasyon;
    }*/
}

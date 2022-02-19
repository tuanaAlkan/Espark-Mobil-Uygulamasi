package com.example.espark;

public class AboneKayit {

    String firmaAdi;
    String telNO, TCKimliK, dogumTarih;

    public AboneKayit() {
    }

    public AboneKayit(String firmaAdi, String telNO, String TCKimliK, String dogumTarih) {
        this.firmaAdi = firmaAdi;
        this.telNO = telNO;
        this.TCKimliK = TCKimliK;
        this.dogumTarih = dogumTarih;
    }

    public String getFirmaAdi() {
        return firmaAdi;
    }

    public void setFirmaAdi(String firmaAdi) {
        this.firmaAdi = firmaAdi;
    }

    public String getTelNO() {
        return telNO;
    }

    public void setTelNO(String telNO) {
        this.telNO = telNO;
    }

    public String getTCKimliK() {
        return TCKimliK;
    }

    public void setTCKimliK(String TCKimliK) {
        this.TCKimliK = TCKimliK;
    }

    public String getDogumTarih() {
        return dogumTarih;
    }

    public void setDogumTarih(String dogumTarih) {
        this.dogumTarih = dogumTarih;
    }
}

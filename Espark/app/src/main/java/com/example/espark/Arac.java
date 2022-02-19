package com.example.espark;

import android.widget.ListView;

public class Arac {

    String aracPlaka;
    String tarife;
    String sure;

    public Arac() {
    }

    public Arac(String aracPlaka) {
        this.aracPlaka = aracPlaka;
    }

    public Arac(String aracPlaka, String tarife, String sure) {
        this.aracPlaka = aracPlaka;
        this.tarife = tarife;
        this.sure = sure;
    }

    public String getAracPlaka() {
        return aracPlaka;
    }

    public void setAracPlaka(String aracPlaka) {
        this.aracPlaka = aracPlaka;
    }

    public String getTarife() {
        return tarife;
    }

    public void setTarife(String tarife) {
        this.tarife = tarife;
    }

    public String getSure() {
        return sure;
    }

    public void setSure(String sure) {
        this.sure = sure;
    }
}

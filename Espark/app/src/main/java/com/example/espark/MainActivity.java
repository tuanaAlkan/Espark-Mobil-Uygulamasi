package com.example.espark;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    //Sayaç değişkeni
    int sayac = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Tanımlama
        progressBar = findViewById(R.id.progressbar);

        //Zamanlayıcı
        final Timer zaman = new Timer();

        //Zamanlayıcı Görevi
        TimerTask zamanlayiciGörev = new TimerTask() {
            @Override
            public void run() {

                sayac = sayac+2;

                //Progressbara sayacı ata
                progressBar.setProgress(sayac);

                if(sayac == 100) {
                    zaman.cancel();
                    Intent gecis = new Intent(MainActivity.this,Giris.class);
                    startActivity(gecis);
                }
            }
        };

        //Zamanlayıcı çizelgesini ayarla
        zaman.schedule(zamanlayiciGörev,0,100);
    }
}
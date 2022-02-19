package com.example.espark;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AnaMenu extends AppCompatActivity {

    ImageButton AracGiris, AracCikis, BorcAra, Ozel, Gunsonu, Cikis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_menu);

        AracGiris = findViewById(R.id.aracgiris);
        AracCikis = findViewById(R.id.araccikis);
        BorcAra = findViewById(R.id.borcara);
        Ozel = findViewById(R.id.ozel);
        Gunsonu = findViewById(R.id.gunsonu);
        Cikis = findViewById(R.id.cikis);

        AracGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aracgir = new Intent(AnaMenu.this, AracGiris.class);
                startActivity(aracgir);
            }
        });

        AracCikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent araccikis = new Intent(AnaMenu.this, AracCikis.class);
                startActivity(araccikis);
            }
        });

        BorcAra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent borcara = new Intent(AnaMenu.this, BorcAra.class);
                startActivity(borcara);
            }
        });

        Ozel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ozel = new Intent(AnaMenu.this, Ozel.class);
                startActivity(ozel);
            }
        });

        Gunsonu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gunsonu = new Intent(AnaMenu.this, Gunsonu.class);
                startActivity(gunsonu);
            }
        });

        Cikis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder uyari = new AlertDialog.Builder(AnaMenu.this);
                uyari.setTitle("Çıkış");
                uyari.setMessage("Çıkışınız yapılıyor..");
                uyari.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent cikis = new Intent(AnaMenu.this,Giris.class);
                        startActivity(cikis);
                    }
                });
                uyari.setNegativeButton("Vazgeç", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                uyari.show();
            }
        });
    }
}
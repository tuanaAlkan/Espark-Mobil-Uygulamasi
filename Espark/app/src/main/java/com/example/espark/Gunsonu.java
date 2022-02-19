package com.example.espark;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Gunsonu extends AppCompatActivity {

    Button Evet, Hayir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gunsonu);

        Evet = findViewById(R.id.evet);
        Hayir = findViewById(R.id.hayir);

        Evet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent evet = new Intent(Gunsonu.this,AnaMenu.class);
                startActivity(evet);
            }
        });

        Hayir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder uyari = new AlertDialog.Builder(Gunsonu.this);
                uyari.setTitle("Çıkış Durumu");
                uyari.setMessage("Çıkışınız yapılıyor..");
                uyari.setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        Intent cikis = new Intent(Gunsonu.this,Giris.class);
                        startActivity(cikis);

                    }
                });
                uyari.show();
            }
        });

    }
}
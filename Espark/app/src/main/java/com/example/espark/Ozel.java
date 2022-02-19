package com.example.espark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Ozel extends AppCompatActivity {

    TextView AracSayisi, CikanAracSayisi, KacakAracSayisi, ToplamArac, AbonmanSayisi;
    Button AboneOl, Tamam;

    private DatabaseReference mDatabase;

    int icerideki_aracsayisi, cikan_aracsayisi, kacak_aracsayisi, toplam_aracsayisi;
    int aracSay = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ozel);

        AracSayisi = findViewById(R.id.aracsayisi);
        CikanAracSayisi = findViewById(R.id.cikanaracsayisi);
        KacakAracSayisi = findViewById(R.id.kacakaracsayisi);
        ToplamArac = findViewById(R.id.toplamarac);
        AbonmanSayisi = findViewById(R.id.abonmansayisi);
        AboneOl = findViewById(R.id.aboneol);
        Tamam = findViewById(R.id.tamam);
/*
        icerideki_aracsayisi = Integer.parseInt(AracSayisi.getText().toString());
        cikan_aracsayisi = Integer.parseInt(CikanAracSayisi.toString());
        toplam_aracsayisi = (icerideki_aracsayisi+cikan_aracsayisi);
        ToplamArac.setText(toplam_aracsayisi);
        kacak_aracsayisi = (toplam_aracsayisi-(icerideki_aracsayisi+cikan_aracsayisi));
        KacakAracSayisi.setText(kacak_aracsayisi);
*/
        AboneOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abone = new Intent(Ozel.this, Abone.class);
                startActivity(abone);
            }
        });

        Tamam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tamam = new Intent(Ozel.this,AnaMenu.class);
                startActivity(tamam);
            }
        });

    }
}
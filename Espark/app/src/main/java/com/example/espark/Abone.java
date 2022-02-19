package com.example.espark;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Abone extends AppCompatActivity {

    EditText FirmaAdi, TelNo, TCKimlik, DogumTarihi;
    Button kayitolustur;

    private String firma, tel, TC, tarih;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abone);

        FirmaAdi = findViewById(R.id.firmaAd);
        TelNo = findViewById(R.id.telno);
        TCKimlik = findViewById(R.id.TCkimlik);
        DogumTarihi = findViewById(R.id.dogumtarihi);
        kayitolustur = findViewById(R.id.kayitol);

        kayitolustur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Abone Kayıtları");

                firma = FirmaAdi.getText().toString();
                tel = TelNo.getText().toString();
                TC = TCKimlik.getText().toString();
                tarih = DogumTarihi.getText().toString();

                if(firma.isEmpty() || tel.isEmpty() || TC.isEmpty() || TC.length()!=11 || tarih.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Lütfen Gerekli Alanları Doğru Doldurunuz!", Toast.LENGTH_SHORT).show();
                }
                else{
                    AboneKayit abone = new AboneKayit(firma,tel,TC,tarih);
                    mDatabase.push().setValue(abone);
                    finish();
                }
            }
        });

    }
}
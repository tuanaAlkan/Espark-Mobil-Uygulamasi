package com.example.espark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

//import android.content.Context;
import android.content.Intent;
//import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;

public class Giris extends AppCompatActivity {

    EditText KullaniciAd, Sifre, Lokasyon;
    Button KayitOl, SifremiUnuttum, GirisYap;

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private String ad, sifr, loksyn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);

        KullaniciAd = findViewById(R.id.kullaniciad);
        Sifre = findViewById(R.id.sifre);
        Lokasyon = findViewById(R.id.lokasyon);
        KayitOl = findViewById(R.id.kayitol);
        SifremiUnuttum = findViewById(R.id.sifremiunuttum);
        GirisYap = findViewById(R.id.girisyap);

        mAuth = FirebaseAuth.getInstance();

        KayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent kayit = new Intent(Giris.this,Kayit.class);
                startActivity(kayit);
            }
        });

        SifremiUnuttum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sifre = new Intent(Giris.this, SifremiUnuttum.class);
                startActivity(sifre);
            }
        });

        GirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ad = KullaniciAd.getText().toString();
                sifr = Sifre.getText().toString();
                loksyn = Lokasyon.getText().toString();
                //mDatabase = FirebaseDatabase.getInstance().getReference("Kullanicilar");

                if(ad.isEmpty() || sifr.isEmpty() || loksyn.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Lütfen Gerekli Alanları Doldurunuz!", Toast.LENGTH_SHORT).show();
                }
                else{
                    loginFunc();
                }

            }
        });
    }

    private void loginFunc() {
        mAuth.signInWithEmailAndPassword(ad,sifr).addOnCompleteListener(Giris.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Intent giris = new Intent(Giris.this, AnaMenu.class);
                                startActivity(giris);
                            }
                            else{
                                Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                            }
                    }
                });
    }

}
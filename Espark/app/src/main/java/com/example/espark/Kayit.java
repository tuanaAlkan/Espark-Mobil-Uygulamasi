package com.example.espark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Kayit extends AppCompatActivity {

    EditText KullaniciId ,KullaniciAdi, Sifre, Lokasyon;
    Button KayitOl;

    private FirebaseAuth mAuth;

    private String id, ad, sifre, lok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kayit);

        KullaniciId = findViewById(R.id.kullaniciId);
        KullaniciAdi = findViewById(R.id.kullaniciad);
        Sifre = findViewById(R.id.sifre);
        Lokasyon = findViewById(R.id.lokasyon);
        KayitOl = findViewById(R.id.kayitol);

        mAuth = FirebaseAuth.getInstance();

        KayitOl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Kullanıcılar");

                id = KullaniciId.getText().toString();
                ad = KullaniciAdi.getText().toString();
                sifre = Sifre.getText().toString();
                lok = Lokasyon.getText().toString();

                if(id.isEmpty() || ad.isEmpty() || sifre.isEmpty() ||lok.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Lütfen Gerekli Alanları Doldurunuz!", Toast.LENGTH_SHORT).show();
                }
                else{
                    registerFunc();
                    Kullanicilar kullanici = new Kullanicilar(id,ad,sifre,lok);
                    mDatabase.push().setValue(kullanici);
                    finish();
                }
            }
        });

    }

    private void registerFunc(){
        mAuth.createUserWithEmailAndPassword(ad, sifre).addOnCompleteListener(Kayit.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent kayitOl = new Intent(Kayit.this,AnaMenu.class);
                            startActivity(kayitOl);
                            finish();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
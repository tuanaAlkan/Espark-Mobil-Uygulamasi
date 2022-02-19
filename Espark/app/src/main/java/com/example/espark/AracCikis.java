package com.example.espark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AracCikis extends AppCompatActivity {

    EditText Plaka;
    Button CikisYap;

    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac_cikis);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        Plaka = findViewById(R.id.plaka);
        CikisYap = findViewById(R.id.aracicikar);

        CikisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String plka = Plaka.getText().toString();
                mDatabase = FirebaseDatabase.getInstance().getReference("Araclar");
                Query query = mDatabase
                        .child(mUser.getUid())
                        .equalTo(plka);
                query.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for (DataSnapshot querySnapshot: snapshot.getChildren()) {
                            querySnapshot.getRef().removeValue();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Log.e(null, "onCancelled", error.toException());
                    }
                });

            }
        });

        SimpleDateFormat sekil = new SimpleDateFormat("dd/MM/yyyy h:m:s");
        Date tarih = new Date();
        System.out.println("Arac Cikis Tarih ve Saati : "+sekil.format(tarih));

    }

}
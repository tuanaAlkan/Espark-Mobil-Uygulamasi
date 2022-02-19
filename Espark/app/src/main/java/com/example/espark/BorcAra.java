package com.example.espark;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.badge.BadgeUtils;

public class BorcAra extends AppCompatActivity {

    EditText BorcPlaka;
    Button borcAra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borc_ara);

        BorcPlaka = findViewById(R.id.borcplaka);
        borcAra = findViewById(R.id.borcara);

        borcAra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String borc = BorcPlaka.getText().toString();
                AlertDialog.Builder diyalogOlusturucu =
                        new AlertDialog.Builder(BorcAra.this);

                diyalogOlusturucu.setMessage(borc+ " plakalı aracın borcu bulunmamaktadır!")
                        .setCancelable(false)
                        .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                diyalogOlusturucu.create().show();
            }
        });

    }
}
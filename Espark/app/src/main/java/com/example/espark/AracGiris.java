package com.example.espark;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class AracGiris extends AppCompatActivity {

    EditText AracPlaka;
    ListView Tarife, Sure;
    Button AracGirisiYap;

    //private DatabaseReference mDatabase;
    private HashMap<String, Object> mData;

    private String aracplaka, tarife, sure, id;

    Context context = this;

    String[] tarifeler =
            {"Uygun Tarife","Standart Tarife","Lüks Tarife"};

    String[] uyguntarife =
            {"0-1 saat = 5TL","1-2 saat = 7TL","2-4 saat = 10TL","4-8 saat = 15TL","8+ saat = 20TL"};
    
    String[] standarttarife =
            {"0-1 saat = 7TL","1-2 saat = 10TL","2-4 saat = 15TL","4-8 saat = 20TL","8+ saat = 25TL"};
    
    String[] lükstarife =
            {"0-1 saat = 10TL","1-2 saat = 13TL","2-4 saat = 17TL","4-8 saat = 25TL","8+ saat = 30TL"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arac_giris);

        //mDatabase = FirebaseDatabase.getInstance().getReference();

        AracPlaka = findViewById(R.id.aracplaka);
        Tarife = findViewById(R.id.tarife);
        Sure = findViewById(R.id.sure);
        AracGirisiYap = findViewById(R.id.aracgirisiyap);

        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, tarifeler);

        Tarife.setAdapter(veriAdaptoru);

        Tarife.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder diyalogOlusturucu =
                        new AlertDialog.Builder(AracGiris.this);

                diyalogOlusturucu.setMessage(tarifeler[position])
                        .setCancelable(false)
                        .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                });
                                diyalogOlusturucu.create().show();

                //Seçilen tarifeye göre süre ve fiyat ayarla
                switch (position)
                {
                    case 0:
                        ArrayAdapter<String> adapter=new ArrayAdapter<String>
                                (context, android.R.layout.simple_list_item_1,android.R.id.text1,uyguntarife);
                        Sure.setAdapter(adapter);
                        break;
                    case 1:
                        ArrayAdapter<String> adapter2=new ArrayAdapter<String>
                                (context, android.R.layout.simple_list_item_1,android.R.id.text1,standarttarife);
                        Sure.setAdapter(adapter2);
                        break;
                    case 2:
                        ArrayAdapter<String> adapter3=new ArrayAdapter<String>
                                (context, android.R.layout.simple_list_item_1,android.R.id.text1,lükstarife);
                        Sure.setAdapter(adapter3);
                        break;
                }
            }
        });

        AracGirisiYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("Araclar");

                aracplaka = AracPlaka.getText().toString();
                tarife = Tarife.getAdapter().toString();
                sure = Sure.getAdapter().toString();

                if(aracplaka.isEmpty() || tarife.isEmpty() || sure.isEmpty()){
                    Toast.makeText(getApplicationContext(), "Lütfen Gerekli Alanları Doldurunuz!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Arac arac = new Arac(aracplaka);
                    mDatabase.push().setValue(arac);
                    finish();

                    SimpleDateFormat sekil = new SimpleDateFormat("dd/MM/yyyy h:m:s");
                    Date tarih = new Date();
                    System.out.println("Arac Giris Tarih ve Saati : "+sekil.format(tarih));
                }

            }
        });

    }

}
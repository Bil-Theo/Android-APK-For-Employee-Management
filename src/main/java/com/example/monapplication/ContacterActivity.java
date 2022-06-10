package com.example.monapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;

public class ContacterActivity extends AppCompatActivity {
    EditText mat;
    ProjetBDD bdd;
    EditText text, sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacter);
        mat = this.findViewById(R.id.mat);
    }
    public void appel(View v){
        bdd =  new ProjetBDD(this);
        Cursor cursor =  bdd.getContact("tel",mat.getText().toString().trim());
        cursor.moveToFirst();
        String s = cursor.getString(0);
        Uri uri = Uri.parse("tel:"+s);
        Intent i = new Intent(Intent.ACTION_DIAL, uri);
        Toast.makeText(this, "Lancement de l'appel", Toast.LENGTH_LONG).show();
        startActivity(i);
    }
    public void mail(View v){
        bdd =  new ProjetBDD(this);
        Cursor cursor =  bdd.getContact("email",mat.getText().toString().trim());
        cursor.moveToFirst();
        String s = cursor.getString(0);
        Uri uri = Uri.parse("mailto:"+s);
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        Toast.makeText(this, "Lancement de la boite mail", Toast.LENGTH_LONG).show();
        startActivity(i);
    }
}
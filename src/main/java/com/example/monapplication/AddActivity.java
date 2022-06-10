package com.example.monapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddActivity extends AppCompatActivity {
    TextView nom, prenom, tel, email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        nom = this.findViewById(R.id.nom);
        prenom = this.findViewById(R.id.prenom);
        email =  this.findViewById(R.id.email);
        tel = this.findViewById(R.id.tel);
    }

    public void ajouter(View v){
        ProjetBDD bdd = new ProjetBDD(this);
        Employe  e = new Employe(nom.getText().toString().trim(),prenom.getText().toString().trim(),email.getText().toString().trim(),tel.getText().toString().trim());
        long verite = bdd.ajouterEmploye(e);
        if(verite==-1){
            Toast.makeText(this, "Operation interrompue", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this, "Operation reussie", Toast.LENGTH_LONG).show();
        }
        finish();
    }

}
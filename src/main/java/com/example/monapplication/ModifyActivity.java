package com.example.monapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ModifyActivity extends AppCompatActivity {

    EditText identifiant;
    EditText nom;
    EditText prenom;
    EditText email;
    EditText tel;
    ProjetBDD bdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify);
        identifiant =this.findViewById(R.id.identifiant);
        nom=this.findViewById(R.id.nom);
        prenom=this.findViewById(R.id.prenom);
        email=this.findViewById(R.id.email);
        tel=this.findViewById(R.id.tel);

    }

    public void modifier(View view) {
        bdd =  new ProjetBDD(this);
        Employe e = new Employe(nom.getText().toString().trim(), prenom.getText().toString().trim(), email.getText().toString().trim(), tel.getText().toString().trim());
        bdd.modifier(e, identifiant.getText().toString().trim());
        Toast.makeText(this, "Employe Modifie avec succes", Toast.LENGTH_LONG).show();
        finish();
    }
}
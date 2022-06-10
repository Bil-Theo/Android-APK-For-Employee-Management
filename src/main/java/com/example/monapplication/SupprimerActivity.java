package com.example.monapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SupprimerActivity extends AppCompatActivity {
    EditText text, sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supprimer);
        text = this.findViewById(R.id.mat);
    }

    public void supprimer(View v) {
        if(text.getText().toString().trim() == null){
            sms.setText("Le champ Identifiant est Obligatoir");
            return;
        }else{
            ProjetBDD bdd = new ProjetBDD(this);
            bdd.supprimer(text.getText().toString().trim());
            Toast.makeText(this, "Employe Supprimer avec succes", Toast.LENGTH_LONG).show();
            finish();
        }
    }

}
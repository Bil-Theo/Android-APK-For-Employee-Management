package com.example.monapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      MenuInflater inflater=getMenuInflater();
      inflater.inflate(R.menu.mon_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.employer: Toast.makeText(this, "Consulter la list d'employer", Toast.LENGTH_LONG).show();
                consulter();
                return true;
            case R.id.Ajouter:
                Toast.makeText(this, "Ajouter employe", Toast.LENGTH_SHORT).show();
                ajouter();
                return true;
            case R.id.modifier:
                Toast.makeText(this, "Modifier employe", Toast.LENGTH_SHORT).show();
                modifier();
                return true;
            case R.id.supprimer:
                Toast.makeText(this, "Supprimer employe", Toast.LENGTH_SHORT).show();
                supprimer();
                return true;
            case R.id.contact:
                Toast.makeText(this, "Contacter employe", Toast.LENGTH_SHORT).show();
                contacter();
                return true;
            default: return super.onOptionsItemSelected(item);
        }

    }

    public void consulter(){
        Intent i = new Intent(this, ListActivity.class);
        startActivity(i);
    }
    public void ajouter(){
        Intent i = new Intent(this, AddActivity.class);
        startActivity(i);
    }
    public  void modifier(){
        Intent i = new Intent(this, ModifyActivity.class);
        startActivity(i);
    }
    public void contacter(){
        Intent i = new Intent(this, ContacterActivity.class);
        startActivity(i);
    }
    public void supprimer(){
        Intent i = new Intent(this, SupprimerActivity.class);
        startActivity(i);
    }

}
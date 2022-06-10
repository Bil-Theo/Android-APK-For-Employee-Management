package com.example.monapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        ListView lv = this.findViewById(R.id.my_list);
        ProjetBDD bdd = new ProjetBDD(this);
        Cursor cursor = bdd.getEmployes();
        EmployerAdapter adapter = new EmployerAdapter(this, cursor);
        lv.setAdapter(adapter);
    }
}
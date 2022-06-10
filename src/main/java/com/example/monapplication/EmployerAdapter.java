package com.example.monapplication;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class EmployerAdapter extends CursorAdapter {
    public EmployerAdapter(Context context, Cursor cursor){
        super(context, cursor, 0);
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.activity_simplelist, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView mat, nom, prenom, email, tel;
        mat = view.findViewById(R.id.mat);
        nom = view.findViewById(R.id.nom);
        prenom = view.findViewById(R.id.prenom);
        email = view.findViewById(R.id.email);
        tel = view.findViewById(R.id.tel);
        mat.setText(cursor.getString(0));
        nom.setText(cursor.getString(1));
        prenom.setText(cursor.getString(2));
        email.setText(cursor.getString(3));
        tel.setText(cursor.getString(4));
        mat.setText(mat.getText().toString().trim()+'\t');
        nom.setText(nom.getText().toString().trim()+'\t');
        prenom.setText(prenom.getText().toString().trim()+'\t');
        email.setText(email.getText().toString().trim()+'\t');

    }
}

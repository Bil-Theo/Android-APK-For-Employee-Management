package com.example.monapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


import androidx.annotation.Nullable;

public class ProjetBDD extends SQLiteOpenHelper {
    @Nullable
    private Context context;

    public ProjetBDD(@Nullable Context context) {
        super(context, "Projet", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String requete = "CREATE TABLE Employe(_id Integer PRIMARY KEY AUTOINCREMENT, nom TEXT,prenom TEXT,email TEXT,tel TEXT)";
        db.execSQL(requete);
    }
    public long ajouterEmploye(Employe e){
        SQLiteDatabase bd = this.getWritableDatabase();
        ContentValues content =  new ContentValues();
        content.put("nom", e.nom);
        content.put("prenom",e.prenom);
        content.put("email",e.email);
        content.put("tel",e.tel);
        long verite = bd.insert("Employe", null, content);
        bd.close();
        return verite;
    }


    public void supprimer(String identifiant){
        SQLiteDatabase bd = this.getWritableDatabase();
        bd.execSQL("DELETE FROM Employe WHERE _id =?", new String[]{identifiant});
        bd.close();
    }
    public Cursor getEmployes(){
        SQLiteDatabase bd = getReadableDatabase();
        Cursor cursor = bd.rawQuery("SELECT * FROM Employe", null);
        //bd.close();
        return cursor;
    }
    public Cursor getContact(String ressource_ex, String identifiant){
        SQLiteDatabase bd =  getReadableDatabase();
        return bd.rawQuery("SELECT "+ressource_ex+" FROM Employe WHERE _id='"+identifiant+"'", null);
    }
    public void modifier(Employe e,String identifiant){
        SQLiteDatabase bd =  getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("_id", identifiant);
        content.put("nom", e.nom);
        content.put("prenom", e.prenom);
        content.put("email", e.email);
        content.put("tel", e.tel);
        bd.update("Employe", content, "_id=?", new String[]{identifiant});
        bd.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.example.basededatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Gorro on 27/10/16.
 */

public class DBController {

    private DBHelper dbHelper;
    private SQLiteDatabase db;

    public DBController(Context context) {
        dbHelper = new DBHelper(context);
    }

    public DBController open() {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insertData(String nombre, String direccion, int edad) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", nombre);
        contentValues.put("edad", edad);
        contentValues.put("domicilio", direccion);
        db.insert(DBHelper.TABLE_NAME, null, contentValues);
    }

    public Cursor getData() {
        String[] columnas = new String[]{
                DBHelper.ID, "nombre", "edad", "domicilio"
        };
        return db.query(DBHelper.TABLE_NAME, columnas, null, null, null, null, null);
    }

    public void delete(long id) {
        db.delete(DBHelper.TABLE_NAME, DBHelper.ID + "=" + id, null);
    }

    public void deleteName(String name) {
        db.delete(DBHelper.TABLE_NAME, "nombre=" + name, null);
    }

}

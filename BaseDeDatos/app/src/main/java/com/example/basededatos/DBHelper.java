package com.example.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Gorro on 27/10/16.
 */

public class DBHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "CursoAndroid";
    static final String DBNAME = "CursoAndroidDB.db";
    static final int VERSIONDB = 1;
    public static String ID = "id";

    String sqliteCreate = "CREATE TABLE " + TABLE_NAME + " ( " +
            ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "nombre TEXT, " +
            "edad INTEGER, " +
            "domicilio TEXT );";

    public DBHelper(Context context) {
        super(context, DBNAME, null, VERSIONDB);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqliteCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_NAME);
        db.execSQL(sqliteCreate);
    }
}

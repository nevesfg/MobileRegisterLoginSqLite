package com.nevesfg.projetos.aula5.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "appLogin.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE `usuarios` ( `email` TEXT PRIMARY KEY, `name` TEXT NOT NULL, `username` TEXT NOT NULL, `password` TEXT NOT NULL);";

//        String sql = "CREATE table user (email TEXT PRIMARY KEY,  name TEXT, username TEXT, password TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

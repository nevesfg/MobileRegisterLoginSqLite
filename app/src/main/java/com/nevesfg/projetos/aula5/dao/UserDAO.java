package com.nevesfg.projetos.aula5.dao;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.nevesfg.projetos.aula5.helper.DBHelper;
import com.nevesfg.projetos.aula5.model.User;

public class UserDAO {

    private User user;
    private DBHelper db;

    public UserDAO(Context ctx, User user){
        db = new DBHelper(ctx);
        this.user = user;
    }

    public boolean verificarUsername() {
        SQLiteDatabase dbLite = this.db.getReadableDatabase();
        String sql = "SELECT * FROM usuarios WHERE name = ? AND password = ?";
        Cursor cursor = dbLite.rawQuery(sql,new String[]{this.user.getName(), this.user.getPassword()});

        if(cursor.getCount() > 0){
            return true;
        }
     return false;
    }

    public boolean cadastrarUsuario() {
        SQLiteDatabase dbLite = this.db.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", this.user.getEmail());
        values.put("name", this.user.getName());
        values.put("username", this.user.getUsername());
        values.put("password", this.user.getPassword());

        long newRowId = dbLite.insert("usuarios", null, values);

        if (newRowId != -1) {
            Log.e("MeuApp", "Inserção bem-sucedida. ID da nova linha: " + newRowId);
            return true;
        } else {
            Log.e("MeuApp", "Erro na inserção dos dados. ID da nova linha: " + newRowId);
        }
        return false;
    }
}

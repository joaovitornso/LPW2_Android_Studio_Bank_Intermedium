package com.example.teladecadastro.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(@Nullable Context context) {
//        super(context, name, factory, version);
        super(context, DBContract.DB_NAME, null, DBContract.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
//        String sql  = "CREATE TABLE user (email TEXT PRIMARY KEY, senha TEXT, nome TEXT, cpf TEXT;";
//        db.execSQL(sql);
        db.execSQL((DBContract.SQL_CREATE_TABLE));

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DBContract.SQL_DELETE_TABLE);
        onCreate(db);
    }
}

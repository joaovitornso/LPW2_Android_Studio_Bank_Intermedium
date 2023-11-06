package com.example.teladecadastro.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.teladecadastro.helper.DBHelper;
import com.example.teladecadastro.model.User;

public class UserDAO {

    private User user;
    private DBHelper db;

    public UserDAO(Context ctx, User users){
        this.db = new DBHelper(ctx);
        this.user = user;
    }

    public boolean verify_Email_and_Password(){
        SQLiteDatabase dblite = this.db.getReadableDatabase();
        String sql = "SELECT * FROM user WHERE email = ?;";
        Cursor cursor = dblite.rawQuery(sql, new String[]{this.user.getEmail(), this.user.getPassword()});

        if (cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }


    }

    public boolean insertNewUser(){
        SQLiteDatabase dbLite = this.db.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("name", this.user.getName());
        cv.put("email", this.user.getName());
        cv.put("cpf", this.user.getName());
        cv.put("password", this.user.getName());

        long ret = dbLite.insert("user", null, cv);

        return ret != -1; //Se o valor for -1 é que não conseguiu inserir, ou seja, false.

//        return (ret > 0){
//            return true;
//        }
//        return false;
    }

    public boolean updateUser(){
        SQLiteDatabase dbLite = this.db.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("name", this.user.getName());
        cv.put("email", this.user.getName());
        cv.put("cpf", this.user.getName());
        cv.put("password", this.user.getName());

        long ret = dbLite.update("user", cv, "email: ?", new String[]{this.user.getEmail()});

        return ret != -1; //Se o valor for -1 é que não conseguiu inserir, ou seja, false.

//        return (ret > 0){
//            return true;
//        }
//        return false;
    }
    public boolean deleteUser(){
        SQLiteDatabase dbLite = this.db.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put("name", this.user.getName());
        cv.put("email", this.user.getName());
        cv.put("cpf", this.user.getName());
        cv.put("password", this.user.getName());

        long ret = dbLite.delete("user", "email: ?", new String[]{this.user.getEmail()});

        return ret != -1; //Se o valor for -1 é que não conseguiu inserir, ou seja, false.

//        return (ret > 0){
//            return true;
//        }
//        return false;
    }

    public User getUserByEmail(){
        SQLiteDatabase dbLite = this.db.getWritableDatabase();

        String sql = "SELECT * FROM user WHERE email = ?;";

        Cursor cursor = dbLite.rawQuery(sql, new String[]{this.user.getEmail()});

        if (cursor != null){
            cursor.moveToFirst();
        }

        this.user.setName(cursor.getString(cursor.getColumnIndexOrThrow("name")));
        this.user.setPassword(cursor.getString(cursor.getColumnIndexOrThrow("password")));
        this.user.setCpf(cursor.getString(cursor.getColumnIndexOrThrow("cpf")));
        this.user.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("email")));

        return this.user;
    }


}

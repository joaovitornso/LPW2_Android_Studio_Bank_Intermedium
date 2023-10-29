package com.example.teladecadastro.dao;

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
        String sql = "SELECT * FROM user WHERE email = ?";
        Cursor cursor = dblite.rawQuery(sql, new String[]{this.user.getEmail(), this.user.getPassword()});

        if (cursor.getCount() > 0){
            return true;
        } else {
            return false;
        }


    }


}

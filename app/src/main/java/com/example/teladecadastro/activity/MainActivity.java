package com.example.teladecadastro.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.teladecadastro.R;
import com.example.teladecadastro.dao.UserDAO;
import com.example.teladecadastro.helper.DBContract;
import com.example.teladecadastro.helper.DBHelper;

import java.sql.DatabaseMetaData;

public class MainActivity extends AppCompatActivity {
    public Button text_cadaster;
    public Button button_enter;

    UserDAO uDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text_cadaster = findViewById(R.id.text_cadaster1);
        text_cadaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, Cadastro.class);
                startActivity(it);

            }
        });

        button_enter = findViewById(R.id.button_enter);
        button_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Login.class);
//                startActivity(intent);
                String userEmail = ((EditText) findViewById(R.id.edtEmail)).getText().toString();
                String userPassword = ((EditText) findViewById(R.id.edtPassword)).getText().toString();

                SharedPreferences sp = getSharedPreferences("appBank", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("email", userEmail);
                editor.apply();
//                editor.commit();

                if (uDao.verify_Email_and_Password()) {
                    Intent intent = new Intent(MainActivity.this, Login.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "As Informações não são válidas", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private boolean verifyInformations(String userEmail, String userPassword) {
        DBHelper db_helper = new DBHelper(this);

        SQLiteDatabase db = db_helper.getReadableDatabase();

        String[] projection = {
                DBContract.COLUMN_EMAIL,
                DBContract.COLUMN_PASSWORD
        };
        String selection = DBContract.COLUMN_EMAIL + " = ? AND " + DBContract.COLUMN_PASSWORD + " = ?";
        String[] selectionArgs = {userEmail, userPassword};

        Cursor cursor = db.query(
                DBContract.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        boolean validInformartions = cursor.getCount() > 0;

        //Lembrando de fechar o database depois de realizar a operação.
        cursor.close();
        db.close();

        return validInformartions;
    }
}
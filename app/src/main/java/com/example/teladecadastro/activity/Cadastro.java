package com.example.teladecadastro.activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teladecadastro.R;
import com.example.teladecadastro.helper.DBContract;
import com.example.teladecadastro.helper.DBHelper;

public class Cadastro extends AppCompatActivity {
    Button return_home;
    Button button_finish_cadaster;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadaster);

        button_finish_cadaster = findViewById(R.id.button_finish_cadaster);
        button_finish_cadaster.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ((EditText) findViewById(R.id.edtNameUser)).getText().toString();
                String cpf = ((EditText) findViewById(R.id.edtCpf)).getText().toString();
                String email = ((EditText) findViewById(R.id.edtEmail)).getText().toString();
                String password = ((EditText) findViewById(R.id.edtPassword1)).getText().toString();

                if (name.equals("") || cpf.equals("") || email.equals("") || password.equals("")){
                    Toast.makeText(Cadastro.this, "Faça o preenchimento de todos os campos para continuar", Toast.LENGTH_SHORT).show();
                } else {
                    DBHelper db_helper = new DBHelper(Cadastro.this);
                    SQLiteDatabase db = db_helper.getWritableDatabase();

                    ContentValues values = new ContentValues();
                    values.put(DBContract.COLUMN_NAME, name);
                    values.put(DBContract.COLUMN_CPF, cpf);
                    values.put(DBContract.COLUMN_EMAIL, email);
                    values.put(DBContract.COLUMN_PASSWORD, password);

                    long newRowId = db.insert(DBContract.TABLE_NAME, null, values);

                    db.close();

                    if (newRowId != -1) {
                        Toast.makeText(Cadastro.this, "SUCESSO: Cadastro de novo usuário BEM SUCEDIDO!", Toast.LENGTH_SHORT).show();
                        Intent it = new Intent(Cadastro.this, MainActivity.class);

                        startActivity(it);
                    } else {
                        Toast.makeText(Cadastro.this, "ERRO: Cadastro de usuário FALHOU !.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        retornarHome();
        return_home.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Cadastro.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    protected void retornarHome(){
        return_home = findViewById(R.id.text_cadaster);
    }
}

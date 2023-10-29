package com.example.teladecadastro.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teladecadastro.R;

public class Login extends AppCompatActivity {
    private Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);
        retornarHome();

        logout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    protected void retornarHome(){
        logout = findViewById(R.id.text_cadaster);
    }
}

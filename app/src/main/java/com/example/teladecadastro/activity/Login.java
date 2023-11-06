package com.example.teladecadastro.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.teladecadastro.R;
import com.example.teladecadastro.dao.UserDAO;
import com.example.teladecadastro.model.User;

public class Login extends AppCompatActivity {
    private Button logout;
    TextView txtEmail, txtName, txtCpf;
    UserDAO uDao;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_account);



        txtEmail = findViewById(R.id.txtEmail);
        txtName = findViewById(R.id.txtName);
        txtCpf = findViewById(R.id.txtCpf);

        SharedPreferences sp = getSharedPreferences("appBank", Context.MODE_PRIVATE);
        String email = sp.getString("email", "abc");

        User user = new User();
        user.setEmail(email);

        uDao = new UserDAO(getApplicationContext(), user);

        user = uDao.getUserByEmail();

        txtEmail.setText(user.getEmail());
        txtName.setText(user.getName());
        txtCpf.setText(user.getCpf());

//   ---------------------------------------------------------------------------------------------
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
        logout = findViewById(R.id.text_cadaster1);
    }
}

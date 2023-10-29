package com.nevesfg.projetos.aula5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nevesfg.projetos.aula5.dao.UserDAO;
import com.nevesfg.projetos.aula5.model.User;

public class registerActivity extends AppCompatActivity {

    Button edtButton, edtNextPageLogin;
    EditText edtEmail, edtName, edtUsername, edtPassword;
    UserDAO uDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtEmail = findViewById(R.id.inputEmail);
        edtName = findViewById(R.id.inputName);
        edtUsername = findViewById(R.id.inputUser);
        edtPassword = findViewById(R.id.inputPassword);
        edtButton = findViewById(R.id.btnCadastrar);
        edtNextPageLogin = findViewById(R.id.btnNextLogin);


        edtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userEmail = edtEmail.getText().toString();
                String userName= edtName.getText().toString();
                String userUsername = edtUsername.getText().toString();
                String userPassword = edtPassword.getText().toString();

                User userDados = new User(userEmail, userName ,userUsername , userPassword);

                UserDAO uDao = new UserDAO(getApplicationContext(), userDados);

                if(uDao.cadastrarUsuario()){
                    Toast.makeText(registerActivity.this, "Cadastrado com sucesso", Toast.LENGTH_SHORT).show();
                    Intent it = new Intent(registerActivity.this, MainActivity.class);
//                it.putExtra("text", edtText.getText().toString());
                    startActivity(it);
                } else {
                    Toast.makeText(registerActivity.this, "Cadastro ja existe", Toast.LENGTH_SHORT).show();
                }

            }
        });

        edtNextPageLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent it = new Intent(registerActivity.this, MainActivity.class);
                    startActivity(it);
            }
        });


    }
}
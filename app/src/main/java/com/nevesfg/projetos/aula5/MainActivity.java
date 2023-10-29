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

public class MainActivity extends AppCompatActivity {

    Button edtButton, edtNextCadastro;
    EditText edtName, edtPasswordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        edtName = findViewById(R.id.inputName);
        edtPasswordLogin = findViewById(R.id.inputPasswordLogin);

        edtButton = findViewById(R.id.btnLogin);
        edtNextCadastro = findViewById(R.id.btnNextCadastro);


        edtButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = edtName.getText().toString();
                String passwordLogin = edtPasswordLogin.getText().toString();


                User dadosLogin = new User(name, passwordLogin);

                UserDAO uDao = new UserDAO(getApplicationContext(), dadosLogin);

                if(uDao.verificarUsername()){
                    Intent it = new Intent(MainActivity.this, activityHome.class);
//                it.putExtra("text", edtText.getText().toString());
                    startActivity(it);
                } else {
                    Toast.makeText(MainActivity.this, "Dados incorretos", Toast.LENGTH_SHORT).show();
                }

            }
        });

        edtNextCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(MainActivity.this, registerActivity.class);
                startActivity(it);
            }
        });


    }
}
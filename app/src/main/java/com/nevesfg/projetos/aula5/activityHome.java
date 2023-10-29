package com.nevesfg.projetos.aula5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class activityHome extends AppCompatActivity {

    TextView edtViewTest;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        edtViewTest = findViewById(R.id.textViewTest);

        Intent it = getIntent();
        String text = it.getStringExtra("text");

        edtViewTest.setText(text);



    }
}
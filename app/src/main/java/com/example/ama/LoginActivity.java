package com.example.ama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseDatabase db;
    private Button ingresarBtn;
    private TextView registrarTxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = FirebaseDatabase.getInstance();

        ingresarBtn = findViewById(R.id.ingresarBtn);
        registrarTxt = findViewById(R.id.registrarTxt);

        registrarTxt.setOnClickListener(this);
        ingresarBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.registrarTxt:
                Intent i = new Intent(this, RegistroActivity.class);
                startActivity(i);
                break;
        }
    }
}
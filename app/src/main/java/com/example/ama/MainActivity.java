package com.example.ama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button consBtn, repBtn, mapBtn, pBtn;
    //Para separar la barra de busqueda
    private Button perfilBtn, reportBtn, homeBtn, puntosBtn, consejosBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        consBtn = findViewById(R.id.consBtn);
        repBtn = findViewById(R.id.repBtn);
        mapBtn = findViewById(R.id.mapBtn);
        pBtn = findViewById(R.id.pBtn);
        perfilBtn = findViewById(R.id.perfilBtn);
        reportBtn = findViewById(R.id.reportBtn);
        homeBtn = findViewById(R.id.homeBtn);
        puntosBtn = findViewById(R.id.puntosBtn);
        consejosBtn = findViewById(R.id.consejosBtn);


        consBtn.setOnClickListener(this);
        repBtn.setOnClickListener(this);
        mapBtn.setOnClickListener(this);
        pBtn.setOnClickListener(this);

        perfilBtn.setOnClickListener(this);
        reportBtn.setOnClickListener(this);
        homeBtn.setOnClickListener(this);
        puntosBtn.setOnClickListener(this);
        consejosBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.consBtn:
                Intent a = new Intent(this, ConsejosActivity.class);
                startActivity(a);
        }

    }
}
package com.example.ama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseDatabase db;
    private Button consBtn, repBtn, mapBtn, pBtn, cerrarBtn;
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
        cerrarBtn = findViewById(R.id.cerrarBtn);


        consBtn.setOnClickListener(this);
        repBtn.setOnClickListener(this);
        mapBtn.setOnClickListener(this);
        pBtn.setOnClickListener(this);

        cerrarBtn.setOnClickListener(this);

        perfilBtn.setOnClickListener(this);
        reportBtn.setOnClickListener(this);
        homeBtn.setOnClickListener(this);
        puntosBtn.setOnClickListener(this);
        consejosBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.pBtn:
                cerrarBtn.setVisibility(View.VISIBLE);
                break;
            case R.id.cerrarBtn:
                Intent s = new Intent(this, LoginActivity.class);
                startActivity(s);
                finish();
                break;
            case R.id.perfilBtn:
                Intent b = new Intent(this, PerfilActivity.class);
                startActivity(b);
                finish();
                break;
            case R.id.reportBtn:
                Intent c = new Intent(this, ReportarActivity.class);
                startActivity(c);
                finish();
                break;
            case R.id.consejosBtn:
            case R.id.consBtn:
                Intent a = new Intent(this, ConsejosActivity.class);
                startActivity(a);
                finish();
                break;
            case R.id.puntosBtn:
                Intent p = new Intent(this, AddLocationActivity.class);
                startActivity(p);
                finish();
                break;
            case R.id.mapBtn:
                Intent m = new Intent(this, MapaListActivity.class);
                startActivity(m);
                finish();
                break;

        }

    }
}
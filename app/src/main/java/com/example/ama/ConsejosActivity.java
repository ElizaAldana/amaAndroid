package com.example.ama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConsejosActivity extends AppCompatActivity implements View.OnClickListener {

    public Button reportBtn2, homeBtn2, puntosBtn2, perfilBtn2, consejosBtn2, pBtn2, cerrarBtn2, publiBtn;
    public TextView nickTv, advTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);

        reportBtn2 = findViewById(R.id.reportBtn2);
        homeBtn2 = findViewById(R.id.homeBtn2);
        puntosBtn2 = findViewById(R.id.puntosBtn2);
        perfilBtn2 = findViewById(R.id.perfilBtn2);
        consejosBtn2 = findViewById(R.id.consejosBtn2);
        pBtn2 = findViewById(R.id.pBtn2);
        cerrarBtn2 = findViewById(R.id.cerrarBtn2);
        publiBtn = findViewById(R.id.publiBtn);


        nickTv = findViewById(R.id.nickTv);
        advTv = findViewById(R.id.advTv);

        reportBtn2.setOnClickListener(this);
        homeBtn2.setOnClickListener(this);
        puntosBtn2.setOnClickListener(this);
        perfilBtn2.setOnClickListener(this);
        consejosBtn2.setOnClickListener(this);
        pBtn2.setOnClickListener(this);
        cerrarBtn2.setOnClickListener(this);
        publiBtn.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()){

            case R.id.pBtn2:
                cerrarBtn2.setVisibility(View.VISIBLE);
                break;
            case R.id.cerrarBtn2:
                finish();
                break;
            case R.id.perfilBtn2:
                Intent b = new Intent(this, PerfilActivity.class);
                startActivity(b);
                finishAfterTransition();
                break;
            case R.id.reportBtn2:
                Intent c = new Intent(this, ReportarActivity.class);
                startActivity(c);
                finishAfterTransition();
                break;
            case R.id.homeBtn2:
                Intent d = new Intent(this, MainActivity.class);
                startActivity(d);
                finishAfterTransition();
                break;
            case R.id.consejosBtn2:
                Intent a = new Intent(this, ConsejosActivity.class);
                startActivity(a);
                finishAfterTransition();
                break;
            case R.id.publiBtn:
                Intent p = new Intent(this, MainActivity.class);
                startActivity(p);
                finishAfterTransition();
                break;


        }

    }
}
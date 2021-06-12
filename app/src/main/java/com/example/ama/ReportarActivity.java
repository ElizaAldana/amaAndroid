package com.example.ama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ReportarActivity extends AppCompatActivity implements View.OnClickListener {

    private Button reportarBtn1, cerrarBtn3, pBtnr;
    private Button perfilBtnr, reportBtnr, homeBtnr, puntosBtnr, consejosBtnr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reportar);

        pBtnr = findViewById(R.id.pBtnr);
        perfilBtnr = findViewById(R.id.perfilBtnr);
        reportBtnr = findViewById(R.id.reportBtnr);
        homeBtnr = findViewById(R.id.homeBtnr);
        puntosBtnr = findViewById(R.id.puntosBtnr);
        consejosBtnr = findViewById(R.id.consejosBtnr);
        cerrarBtn3 = findViewById(R.id.cerrarBtn3);
        reportarBtn1 = findViewById(R.id.reportarBtn1);

        pBtnr.setOnClickListener(this);
        perfilBtnr.setOnClickListener(this);
        reportBtnr.setOnClickListener(this);
        homeBtnr.setOnClickListener(this);
        puntosBtnr.setOnClickListener(this);
        consejosBtnr.setOnClickListener(this);
        cerrarBtn3.setOnClickListener(this);
        reportarBtn1.setOnClickListener(this);

    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.pBtnr:
                cerrarBtn3.setVisibility(View.VISIBLE);
                break;
            case R.id.cerrarBtn3:
                finish();
                break;
            case R.id.perfilBtnr:
                Intent b = new Intent(this, PerfilActivity.class);
                startActivity(b);
                finishAfterTransition();
                break;
            case R.id.reportBtnr:
                Intent c = new Intent(this, ReportarActivity.class);
                startActivity(c);
                finishAfterTransition();
                break;
            case R.id.homeBtnr:
                Intent h = new Intent(this, MainActivity.class);
                startActivity(h);
                finishAfterTransition();
            case R.id.puntosBtnr:
                Intent p = new Intent(this, AddLocationActivity.class);
                startActivity(p);
                finishAfterTransition();
            case R.id.consejosBtnr:
                Intent a = new Intent(this, ConsejosActivity.class);
                startActivity(a);
                break;
            case R.id.reportarBtn1:
                Intent re = new Intent(this, MainActivity.class);
                startActivity(re);
                finishAfterTransition();


        }
    }
}
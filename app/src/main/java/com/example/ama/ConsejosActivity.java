package com.example.ama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ConsejosActivity extends AppCompatActivity {

    public Button reportBtn2, homeBtn2, puntosBtn2, perfilBtn2, consejosBtn2;
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
        nickTv = findViewById(R.id.nickTv);
        advTv = findViewById(R.id.advTv);
    }
}
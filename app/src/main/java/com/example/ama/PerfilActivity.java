package com.example.ama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PerfilActivity extends AppCompatActivity {

    private Button perfilBtn3, reportBtn3, homeBtn3, puntosBtn3, consejosBtn3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.reportBtn3:
                Intent c = new Intent(this, ReportarActivity.class);
                startActivity(c);
                finishAfterTransition();
                break;
            case R.id.homeBtn3:
                Intent h = new Intent(this, MainActivity.class);
                startActivity(h);
                finishAfterTransition();
            case R.id.puntosBtn3:
                Intent p = new Intent(this, AddLocationActivity.class);
                startActivity(p);
                finishAfterTransition();
            case R.id.consejosBtn3:
                Intent a = new Intent(this, ConsejosActivity.class);
                startActivity(a);
                break;
        }
    }
}
package com.example.ama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddLocationActivity extends AppCompatActivity implements View.OnClickListener {

    private Button perfilBtn5, puntosBtn5, consejosBtn5, pBtn5, reportBtn5, homeBtn5, addLocationBtn;
    private EditText puntoName, puntoDesc, puntoDir, puntoTel, puntoHor;
    private FirebaseDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_location);

        db = FirebaseDatabase.getInstance();
        pBtn5 = findViewById(R.id.pBtn5);
        perfilBtn5 = findViewById(R.id.perfilBtn5);
        puntosBtn5 = findViewById(R.id.puntosBtn5);
        consejosBtn5 = findViewById(R.id.consejosBtn5);
        reportBtn5 = findViewById(R.id.reportBtn5);
        homeBtn5 = findViewById(R.id.homeBtn5);

        addLocationBtn = findViewById(R.id.addLocationBtn);

        puntoDesc = findViewById(R.id.puntoDesc);
        puntoName = findViewById(R.id.puntoName);
        puntoHor = findViewById(R.id.puntoHor);
        puntoTel = findViewById(R.id.puntoTel);
        puntoDir = findViewById(R.id.puntoDir);

        perfilBtn5.setOnClickListener(this);
        reportBtn5.setOnClickListener(this);
        homeBtn5.setOnClickListener(this);
        puntosBtn5.setOnClickListener(this);
        consejosBtn5.setOnClickListener(this);
        addLocationBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.addLocationBtn:
                DatabaseReference ref = db.getReference().child("locaciones").child("ecoPuntos").child(puntoName.getText().toString());
                Location location = new Location(
                        puntoDesc.getText().toString(),
                        puntoDir.getText().toString(),
                        puntoTel.getText().toString(),
                        puntoHor.getText().toString(),
                        puntoName.getText().toString()
                );
                ref.setValue(location);
                Intent a = new Intent(this, MapaListActivity.class);
                startActivity(a);
                break;
            case R.id.homeBtn5:
                Intent h = new Intent(this, MapaListActivity.class);
                startActivity(h);
                finish();
                break;
        }

    }
}
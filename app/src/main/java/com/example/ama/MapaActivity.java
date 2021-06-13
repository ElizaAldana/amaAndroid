package com.example.ama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MapaActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase db;
    private ImageView mapImage;
    private TextView locationDir, locationDesc, locationHor, locationTel, locationNom;
    private Button homeBtn6, consejosBtn6, reportBtn6, perfilBtn6, puntosBtn6, volverBtn;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);

        db = FirebaseDatabase.getInstance();

        mapImage = findViewById(R.id.mapImage);

        name = getIntent().getExtras().getString("name");

        locationNom = findViewById(R.id.locationNom);
        locationDir = findViewById(R.id.locationDir);
        locationDesc = findViewById(R.id.locationDesc);
        locationHor = findViewById(R.id.locationHor);
        locationTel = findViewById(R.id.locationTel);

        perfilBtn6 = findViewById(R.id.perfilBtn6);
        reportBtn6 = findViewById(R.id.reportBtn6);
        homeBtn6 = findViewById(R.id.homeBtn6);
        puntosBtn6 = findViewById(R.id.puntosBtn6);
        consejosBtn6 = findViewById(R.id.consejosBtn6);
        volverBtn = findViewById(R.id.volverBtn);


        perfilBtn6.setOnClickListener(this);
        reportBtn6.setOnClickListener(this);
        homeBtn6.setOnClickListener(this);
        puntosBtn6.setOnClickListener(this);
        consejosBtn6.setOnClickListener(this);
        volverBtn.setOnClickListener(this);

        switch(name) {
            case "Redciclar":
                mapImage.setImageResource(R.drawable.redciclarmap);
                break;
            case "Biopravu":
                mapImage.setImageResource(R.drawable.biopravumap);
                break;
            case "Recicladora":
                mapImage.setImageResource(R.drawable.recicladoramap);
                break;
            case "Reciclaje Industrial de Papel":
                mapImage.setImageResource(R.drawable.recipapelmap);
                break;
            case "La casa de los Tarros Cali":
                mapImage.setImageResource(R.drawable.recipapelmap);
                break;
        }

        loadDatabase();

    }

    private void loadDatabase() {
        FirebaseDatabase.getInstance().getReference().child("locaciones").child("ecoPuntos").child(name).addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot data) {
                        Location location = data.getValue(Location.class);
                        locationNom.setText(location.getNombre());
                        locationDesc.setText(location.getDescripcion());
                        locationTel.setText("Teléfono: "+location.getTelefono());
                        locationDir.setText("Dirección: "+location.getDireccion());
                        locationHor.setText("Horario: "+location.getHorario());
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                }
        );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.volverBtn:
            case R.id.puntosBtn6:
                Intent vo = new Intent(this, MapaListActivity.class);
                startActivity(vo);
                finish();
                break;
            case R.id.reportBtn6:
                Intent r = new Intent(this, ReportarActivity.class);
                startActivity(r);
                finish();
                break;
            case R.id.homeBtn6:
                Intent h = new Intent(this, MainActivity.class);
                startActivity(h);
                finish();
                break;
            case R.id.consejosBtn6:
                Intent c = new Intent(this, ConsejosActivity.class);
                startActivity(c);
                finish();
                break;
            case R.id.perfilBtn6:
                Intent pe = new Intent(this, PerfilActivity.class);
                startActivity(pe);
                finish();
                break;
        }

    }
}
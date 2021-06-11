package com.example.ama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MapaListActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase db;
    private ListView lugaresList;
    private ImageView perfilBtn4, puntosBtn4, consejosBtn4, pBtn4,reportBtn4, homeBtn4;
    private Button agregarLugarBtn;
    private ArrayList<Location> dataLocations;
    private ArrayAdapter<Location> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa_list);

        db = FirebaseDatabase.getInstance();
        pBtn4 = findViewById(R.id.pBtn4);
        perfilBtn4 = findViewById(R.id.perfilBtn4);
        reportBtn4 = findViewById(R.id.reportBtn4);
        homeBtn4 = findViewById(R.id.homeBtn4);
        puntosBtn4 = findViewById(R.id.puntosBtn4);
        consejosBtn4 = findViewById(R.id.consejosBtn4);
        agregarLugarBtn = findViewById(R.id.agregarLugarBtn);
        lugaresList = findViewById(R.id.lugaresList);

        dataLocations = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dataLocations);
        lugaresList.setAdapter(adapter);

        perfilBtn4.setOnClickListener(this);
        reportBtn4.setOnClickListener(this);
        homeBtn4.setOnClickListener(this);
        puntosBtn4.setOnClickListener(this);
        consejosBtn4.setOnClickListener(this);
        agregarLugarBtn.setOnClickListener(this);

        loadDatabase();

    }

    private void loadDatabase() {
        DatabaseReference ref = db.getReference().child("locaciones").child("ecoPuntos");
        ref.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot data) {
                        dataLocations.clear();
                        for(DataSnapshot child : data.getChildren()){
                            Location locationN = child.getValue(Location.class);
                            dataLocations.add(locationN);
                        }
                        adapter.notifyDataSetChanged();

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
            case R.id.homeBtn4:
                Intent h = new Intent(this, MainActivity.class);
                startActivity(h);
                break;
        }

    }
}
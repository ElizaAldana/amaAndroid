package com.example.ama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PerfilActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView userId, emailId, ciudadId;
    private Button perfilBtn3, reportBtn3, homeBtn3, puntosBtn3, consejosBtn3;
    private ListView favTv;
    private FirebaseDatabase db;
    private FirebaseAuth auth;
    private ConsejoAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        userId = findViewById(R.id.userId);
        emailId = findViewById(R.id.emailId);
        ciudadId = findViewById(R.id.ciudadId);
        favTv = findViewById(R.id.favTv);

        perfilBtn3 = findViewById(R.id.perfilBtn3);
        reportBtn3 = findViewById(R.id.reportBtn3);
        homeBtn3 = findViewById(R.id.homeBtn3);
        puntosBtn3 = findViewById(R.id.puntosBtn3);
        consejosBtn3 = findViewById(R.id.consejosBtn3);
        favTv = findViewById(R.id.favTv);

        perfilBtn3.setOnClickListener(this);
        reportBtn3.setOnClickListener(this);
        homeBtn3.setOnClickListener(this);
        puntosBtn3.setOnClickListener(this);
        consejosBtn3.setOnClickListener(this);

        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        adapter = new ConsejoAdapter();
        favTv.setAdapter(adapter);

        recoverUser();
        loadDatabase();

    }

    private void recoverUser() {
        if(auth.getCurrentUser() != null){
            String idUser = auth.getCurrentUser().getUid();
            db.getReference().child("users").child("registrados").child(idUser).addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            Users user = snapshot.getValue(Users.class);
                            String idUsername = user.getNombre();
                            String idEmail = user.getCorreo();
                            String idCiudad = user.getCiudad();
                            userId.setText(idUsername);
                            emailId.setText(idEmail);
                            ciudadId.setText(idCiudad);

                        }

                        @Override
                        public void onCancelled(DatabaseError error) {

                        }
                    }
            );
        }
    }

    //Me pinta pero quiero guardar solo los favoritos
    private void loadDatabase() {
        String idUser = auth.getCurrentUser().getUid();
        DatabaseReference ref = db.getReference().child("Favoritos").child(idUser);
        ref.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot data) {
                        adapter.clear();
                        for (DataSnapshot child : data.getChildren()){
                            Consejos consejo = child.getValue(Consejos.class);
                            adapter.addConsejo(consejo);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError error) {

                    }
                }
        );
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
                break;
            case R.id.puntosBtn3:
                Intent p = new Intent(this, AddLocationActivity.class);
                startActivity(p);
                finishAfterTransition();
                break;
            case R.id.consejosBtn3:
                Intent a = new Intent(this, ConsejosActivity.class);
                startActivity(a);
                break;
        }
    }
}
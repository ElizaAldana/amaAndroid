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
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PerfilActivity extends AppCompatActivity {

    private TextView userId, emailId, ciudadId;
    private Button perfilBtn3, reportBtn3, homeBtn3, puntosBtn3, consejosBtn3;
    private ListView

    private ListView
    private FirebaseDatabase db;
    private FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        userId = findViewById(R.id.userId);
        emailId = findViewById(R.id.emailId);
        ciudadId = findViewById(R.id.ciudadId);

        perfilBtn3 = findViewById(R.id.perfilBtn3);
        reportBtn3 = findViewById(R.id.reportBtn3);
        homeBtn3 = findViewById(R.id.homeBtn3);
        puntosBtn3 = findViewById(R.id.puntosBtn3);
        consejosBtn3 = findViewById(R.id.consejosBtn3);




        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();


        recoverUser();

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
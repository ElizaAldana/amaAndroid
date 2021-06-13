package com.example.ama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ConsejosActivity extends AppCompatActivity implements View.OnClickListener {

    private Button reportBtn2, homeBtn2, puntosBtn2, perfilBtn2, consejosBtn2, publiBtn;
    private ListView dataTv;
    private EditText tituloEt, advTv;
    private ConsejoAdapter adapter;

    private FirebaseDatabase db;
    private FirebaseAuth auth;

    //Strings para clicks
    private String idUser;
    private String idUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consejos);

        reportBtn2 = findViewById(R.id.reportBtn2);
        homeBtn2 = findViewById(R.id.homeBtn2);
        puntosBtn2 = findViewById(R.id.puntosBtn2);
        perfilBtn2 = findViewById(R.id.perfilBtn2);
        consejosBtn2 = findViewById(R.id.consejosBtn2);
        publiBtn = findViewById(R.id.publiBtn);

        tituloEt = findViewById(R.id.tituloEt);
        advTv = findViewById(R.id.advTv);
        dataTv = findViewById(R.id.dataTv);

        reportBtn2.setOnClickListener(this);
        homeBtn2.setOnClickListener(this);
        puntosBtn2.setOnClickListener(this);
        perfilBtn2.setOnClickListener(this);
        consejosBtn2.setOnClickListener(this);
        publiBtn.setOnClickListener(this);

        adapter = new ConsejoAdapter();
        dataTv.setAdapter(adapter);

        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();

        recoverUser();
        loadDatabase();



    }

    private void recoverUser() {
        if(auth.getCurrentUser() != null){
            idUser = auth.getCurrentUser().getUid();
            db.getReference().child("users").child("registrados").child(idUser).addValueEventListener(
                    new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot snapshot) {
                            Users user = snapshot.getValue(Users.class);
                            idUsername = user.getNombre();

                        }

                        @Override
                        public void onCancelled(DatabaseError error) {

                        }
                    }
            );
        }
    }



    private void loadDatabase() {
        DatabaseReference ref = db.getReference().child("consejos");
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
        switch (v.getId()){

            case R.id.perfilBtn2:
                Intent b = new Intent(this, PerfilActivity.class);
                startActivity(b);
                finish();
                break;
            case R.id.reportBtn2:
                Intent c = new Intent(this, ReportarActivity.class);
                startActivity(c);
                finish();
                break;
            case R.id.homeBtn2:
                Intent d = new Intent(this, MainActivity.class);
                startActivity(d);
                finish();
                break;
            case R.id.puntosBtn2:
                Intent p = new Intent(this, AddLocationActivity.class);
                startActivity(p);
                finish();
                break;
            case R.id.publiBtn:
                String id = db.getReference().child("consejos").push().getKey();
                DatabaseReference reference = db.getReference().child("consejos").child(id);
                Consejos consejo = new Consejos(
                        idUsername,
                        advTv.getText().toString(),
                        id,
                        tituloEt.getText().toString()
                );
                reference.setValue(consejo);
                advTv.setText("");
                tituloEt.setText("");
                break;



        }

    }
}
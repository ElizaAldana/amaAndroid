package com.example.ama;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ConsejosActivity extends AppCompatActivity implements View.OnClickListener {

    private Button reportBtn2, homeBtn2, puntosBtn2, perfilBtn2, consejosBtn2, pBtn2, cerrarBtn2, publiBtn;
    private TextView  dataTv;
    private EditText nickTv, advTv;
    private FirebaseDatabase db;

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
        dataTv = findViewById(R.id.dataTv);

        reportBtn2.setOnClickListener(this);
        homeBtn2.setOnClickListener(this);
        puntosBtn2.setOnClickListener(this);
        perfilBtn2.setOnClickListener(this);
        consejosBtn2.setOnClickListener(this);
        pBtn2.setOnClickListener(this);
        cerrarBtn2.setOnClickListener(this);
        publiBtn.setOnClickListener(this);

        dataTv.setMovementMethod(new ScrollingMovementMethod());


        
        db = FirebaseDatabase.getInstance();
        loadDatabase();


    }

    private void loadDatabase() {
        DatabaseReference ref = db.getReference().child("users").child("registrados");
        ref.addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot data) {
                        dataTv.setText("");
                        for (DataSnapshot child : data.getChildren()){
                            Users userN = child.getValue(Users.class);
                            dataTv.append(userN.getNombre() + "\n");
                            dataTv.append(advTv.getText());
                            advTv.setText(null);
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
            case R.id.publiBtn:
                db.getReference().child("users").child("registrados").child(nickTv.getText().toString()).addListenerForSingleValueEvent(
                        new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot data) {
                                Users users = data.getValue(Users.class);
                                dataTv.setText("");
                                dataTv.append(users.getNombre() + "\n");
                                dataTv.append(advTv.getText());
                                advTv.setText(null);
                            }

                            @Override
                            public void onCancelled(DatabaseError error) {

                            }
                        }
                );//ONCE
                break;



        }

    }
}
package com.example.ama;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase db;
    private EditText nombreInput, contrasenaInput, confirmInput, emailInput, ciudadInput;
    private Button registerBtn;
    private TextView ingresarTxt;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        db = FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        nombreInput = findViewById(R.id.nombreInput);
        contrasenaInput = findViewById(R.id.contrasenaInput);
        confirmInput = findViewById(R.id.confirmInput);
        emailInput = findViewById(R.id.emailInput);
        ciudadInput = findViewById(R.id.ciudadInput);
        registerBtn = findViewById(R.id.registerBtn);
        ingresarTxt = findViewById(R.id.ingresarTxt);

        registerBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registerBtn:
                auth.createUserWithEmailAndPassword(emailInput.getText().toString(), contrasenaInput.getText().toString())
                        .addOnCompleteListener(
                                task -> {
                                   if(task.isSuccessful()){
                                       String id = auth.getCurrentUser().getUid();
                                       Users user = new Users(
                                               nombreInput.getText().toString(),
                                               emailInput.getText().toString(),
                                               contrasenaInput.getText().toString(),
                                               confirmInput.getText().toString(),
                                               ciudadInput.getText().toString(),
                                               id
                                       );
                                       db.getReference().child("users").child("registrados").child(id).setValue(user).addOnCompleteListener(
                                               taskdb -> {
                                                   if(taskdb.isSuccessful()){
                                                       Intent r = new Intent(this, PerfilActivity.class);
                                                       startActivity(r);
                                                       finish();
                                                   }
                                               }
                                       );
                                   }else{
                                       Toast.makeText(this,task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                   }
                                }
                        );
                break;
        }
    }
}
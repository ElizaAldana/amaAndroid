package com.example.ama;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseDatabase db;
    private EditText nombreInput, contrasenaInput, confirmInput, emailInput, ciudadInput;
    private Button registerBtn;
    private TextView ingresarTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        db = FirebaseDatabase.getInstance();
        nombreInput = findViewById(R.id.nombreInput);
        contrasenaInput = findViewById(R.id.contrasenaInput);
        confirmInput = findViewById(R.id.confirmInput);
        emailInput = findViewById(R.id.emailInput);
        registerBtn = findViewById(R.id.registerBtn);
        ingresarTxt = findViewById(R.id.ingresarTxt);

        registerBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.registerBtn:
                DatabaseReference reference = db.getReference().child("users").child("registrados").child(UUID.randomUUID().toString());
                break;
        }
    }
}
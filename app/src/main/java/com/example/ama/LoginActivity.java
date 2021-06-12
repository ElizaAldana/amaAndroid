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
import com.google.firebase.database.FirebaseDatabase;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    private FirebaseDatabase db;
    private Button ingresarBtn;
    private TextView registrarTxt;
    private FirebaseAuth auth;
    private EditText userEmail, userContrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db = FirebaseDatabase.getInstance();

        ingresarBtn = findViewById(R.id.ingresarBtn);
        registrarTxt = findViewById(R.id.registrarTxt);
        userEmail = findViewById(R.id.userEmail);
        userContrasena = findViewById(R.id.userContrasena);

        auth = FirebaseAuth.getInstance();

        registrarTxt.setOnClickListener(this);
        ingresarBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.registrarTxt:
                Intent i = new Intent(this, RegistroActivity.class);
                startActivity(i);
                break;
            case R.id.ingresarBtn:
                auth.signInWithEmailAndPassword(userEmail.getText().toString(), userContrasena.getText().toString()).addOnCompleteListener(
                        task -> {
                            if(task.isSuccessful()){
                                Intent a = new Intent(this, MainActivity.class);
                                startActivity(a);
                                finish();
                            }else{
                                Toast.makeText(this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                            }
                        }
                );
        }
    }
}